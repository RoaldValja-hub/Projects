import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;


public class Server {

	private static List<Balance> balanceList = new ArrayList<Balance>();
	
	public Transaction doTransaction(String username, int transactionID, BigDecimal change) throws IOException, ClassNotFoundException{
		writeLogIN(username, transactionID, change);
		int errorCode;
		Balance userBalance = null;
		boolean foundBalance = false;
		for(Balance bl : balanceList){
			if(bl.getUsername().equals(username)){
				userBalance = bl;
				foundBalance = true;
				break;
			}
		}
		if(!foundBalance){
			userBalance = getBackedupPlayer(username);
		}
		if(userBalance == null){
			errorCode = 4;
			Transaction transaction = new Transaction(transactionID, 0,
					BigDecimal.ZERO, BigDecimal.ZERO, errorCode);
			writeLogOUT(transactionID, errorCode, 0, BigDecimal.ZERO, BigDecimal.ZERO, username);
			return transaction;
		}
		if(isBlacklisted(username)){
			errorCode = 1;
			Transaction transaction = new Transaction(transactionID, userBalance.getBalanceVersion(),
					BigDecimal.ZERO, userBalance.getBalance(), errorCode);
			writeLogOUT(transactionID, errorCode, userBalance.getBalanceVersion(), BigDecimal.ZERO, userBalance.getBalance(), username);
			return transaction;
		}else if(change.compareTo(getBalanceChangeLimit(username)) == 1){
			errorCode = 2;
			Transaction transaction = new Transaction(transactionID, userBalance.getBalanceVersion(),
					BigDecimal.ZERO, userBalance.getBalance(), errorCode);
			writeLogOUT(transactionID, errorCode, userBalance.getBalanceVersion(), BigDecimal.ZERO, userBalance.getBalance(), username);
			return transaction;
		}else if(userBalance.getBalance().subtract(change).compareTo(BigDecimal.ZERO) == -1){
			errorCode = 3;
			Transaction transaction = new Transaction(transactionID, userBalance.getBalanceVersion(),
					BigDecimal.ZERO, userBalance.getBalance(), errorCode);
			writeLogOUT(transactionID, errorCode, userBalance.getBalanceVersion(), BigDecimal.ZERO, userBalance.getBalance(), username);
			return transaction;
		}else{
			errorCode = 0;
			BigDecimal balance = userBalance.getBalance().subtract(change);
			userBalance.changeBalance(change);
			Transaction transaction = new Transaction(transactionID, userBalance.getBalanceVersion(),
					change, balance, errorCode);
			if(isDuplicateTransaction(transaction)){
				writeLogOUT(transactionID, errorCode, userBalance.getBalanceVersion(), change, balance, username);
				return transaction;
			}
			writeLogOUT(transactionID, errorCode, userBalance.getBalanceVersion(), change, balance, username);
			userBalance.increaseBalanceVersion();
			addTransaction(transaction);
			return transaction;
		}
	}
	public void addTransaction(Transaction transaction) throws ClassNotFoundException{
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		try{
			connection = DriverManager.getConnection("jdbc:sqlite:balances.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS TRANSACTIONS (TRANSACTIONID INTEGER, BALANCE_VERSION INTEGER, "
					+ "BALANCE_CHANGE STRING, BALANCE_AFTER_CHANGE STRING, ERRORCODE INTEGER)");
			statement.executeUpdate("INSERT INTO TRANSACTIONS values('"+transaction.getTransactionID()+"',"
					+ "'"+transaction.getBalanceVersion()+"','"+transaction.getBalanceChange()+"','"+transaction.getNewBalance()+"','"+transaction.getErrorCode()+"')");
			connection.close();
			}catch(SQLException e){  System.err.println(e.getMessage()); }       
		finally {         
			try {
				if(connection != null)
					connection.close();
				}
			catch(SQLException e) {          
				System.err.println(e); 
				}
			}
	}
	public boolean isDuplicateTransaction(Transaction transaction) throws ClassNotFoundException{
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		try{
			connection = DriverManager.getConnection("jdbc:sqlite:balances.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			ResultSet resultSet = statement.executeQuery("SELECT * from TRANSACTIONS order by TRANSACTIONID DESC limit 1000");
			while(resultSet.next()){
				BigDecimal bd1 = new BigDecimal(resultSet.getString("BALANCE_CHANGE"));
				BigDecimal bd2 = new BigDecimal(resultSet.getString("BALANCE_AFTER_CHANGE"));
				if(resultSet.getInt("TRANSACTIONID") == transaction.getTransactionID() && 
						resultSet.getInt("BALANCE_VERSION") == transaction.getBalanceVersion() &&
						bd1.compareTo(transaction.getBalanceChange()) == 0 &&
						bd2.compareTo(transaction.getNewBalance()) == 0 &&
						resultSet.getInt("ERRORCODE") == transaction.getErrorCode()){
					return true;
				}
			}
			connection.close();
			return false;
			}catch(SQLException e){  System.err.println(e.getMessage()); }       
		finally {         
			try {
				if(connection != null)
					connection.close();
				}
			catch(SQLException e) {        
				System.err.println(e); 
				}
			}
		return false;
		
	}
	public Balance getBackedupPlayer(String username) throws ClassNotFoundException{
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
	    try{
	    	connection = DriverManager.getConnection("jdbc:sqlite:balances.db");
	    	Statement statement = connection.createStatement();
	    	statement.setQueryTimeout(30);
	    	ResultSet resultSet = statement.executeQuery("SELECT * from player");
	    	while(resultSet.next()){
	    		if(username.equals(resultSet.getString("USERNAME"))){
	    			BigDecimal bd = new BigDecimal(resultSet.getString("BALANCE"));
	    			Balance bl = new Balance(bd, username, resultSet.getInt("BALANCE_VERSION"));
	    			connection.close();
	    			addBalance(bl);
	    			return bl;
	    			}
	    		}
	    	}catch(SQLException e){  System.err.println(e.getMessage()); }       
	    finally {         
	    	try {
	    		if(connection != null)
	    			connection.close();
	    		}
	    	catch(SQLException e) {      
	    		System.err.println(e); 
	    		}
	    	}
	    return null;
	    }
	
	public void backupPlayer(Balance balanceObject) throws ClassNotFoundException{
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		try{
			connection = DriverManager.getConnection("jdbc:sqlite:balances.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS PLAYER (USERNAME STRING, BALANCE_VERSION INTEGER, BALANCE STRING)");
			ResultSet resultSet = statement.executeQuery("SELECT * from player");
			boolean updateQuery = false;
			while(resultSet.next()){
				if(balanceObject.getUsername().equals(resultSet.getString("USERNAME"))){
					updateQuery = true;
					statement.executeUpdate("UPDATE PLAYER SET BALANCE_VERSION='"+balanceObject.getBalanceVersion()+"'"
							+ ", BALANCE='"+balanceObject.getBalance()+"' WHERE USERNAME='"+balanceObject.getUsername()+"'");
					}
				}
			if(!updateQuery){
				statement.executeUpdate("INSERT INTO PLAYER values('"+balanceObject.getUsername()+"', '"+balanceObject.getBalanceVersion()+"', '"+balanceObject.getBalance()+"')");
				}
			}catch(SQLException e){  System.err.println(e.getMessage()); }       
		finally {         
			try {
				if(connection != null)
					connection.close();
				}
			catch(SQLException e) {        
				System.err.println(e); 
				}
			}
		}
	
	private void writeLogIN(String username, int transactionID, BigDecimal change) throws IOException{
		Date currentDate = new Date();
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = simpleFormat.format(currentDate);
		File logFile = new File("log.txt");
		logFile.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true));
		String logInput = date + " IN user: " + username + " with transaction ID: " 
				+ transactionID + " wanted to change balance by " + change;
		writer.append(logInput);
		writer.newLine();
		writer.close();
	}
	private void writeLogOUT(int transactionID, int errorCode, int balanceVersion, BigDecimal balanceChange, BigDecimal balanceAfterChange, String username) throws IOException{
		Date currentDate = new Date();
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = simpleFormat.format(currentDate);
		File logFile = new File("log.txt");
		logFile.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true));
		String logoutput = date + " OUT user: " + username + " got errorcode (" + errorCode + ") with transaction ID: " 
				+ transactionID + " changed balance by " + balanceChange + ". Balance after change is " 
				+ balanceAfterChange + " with balance version " + balanceVersion;
		writer.append(logoutput);
		writer.newLine();
		writer.close();
	}
	
	public BigDecimal getBalanceChangeLimit(String username) throws IOException{
		File limitsFile = new File("balanceLimits.txt");
		BufferedReader reader = new BufferedReader(new FileReader(limitsFile));
		String st;
		while ((st = reader.readLine()) != null){
			int split = st.indexOf(":");
			String name = st.substring(0, split);
			if(username.equals(name)){
				String limitInStr = st.substring(split+2, st.length());
				int limitInInt = Integer.parseInt(limitInStr);
				reader.close();
				return BigDecimal.valueOf(limitInInt);
			}
		}
		reader.close();
		return null;
	}
	//see ei uuenda vanu limiite.
	public void addBalanceChangeLimit(String username, BigDecimal limit) throws IOException{
		File limitsFile = new File("balanceLimits.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(limitsFile, true));
		if(!limitsFile.exists()){
			limitsFile.createNewFile();
			writer.append(username + ": " + limit);
			writer.newLine();
			writer.close();
		} else {
			BufferedReader reader = new BufferedReader(new FileReader(limitsFile));
			List<String> lines = new ArrayList<String>();
			String st;
			while((st = reader.readLine()) != null){
				int split = st.indexOf(":");
				String name = st.substring(0, split);
				if(username.equals(name)){
					String newLine = username + ": " + limit;
					lines.add(newLine);
				}else{
					lines.add(st);
				}
			}
			writer.close();
			reader.close();
			limitsFile.delete();
			File newLimitsFile = new File("balanceLimits.txt");
			BufferedWriter newWriter = new BufferedWriter(new FileWriter(limitsFile, true));
			newLimitsFile.createNewFile();
			for(int i = 0; i < lines.size(); i++){
				newWriter.append(lines.get(i));
				newWriter.newLine();
			}
			newWriter.close();
		}
		
	}
	
	public void addBalance(Balance newBalance) throws ClassNotFoundException{
		balanceList.add(newBalance);
		backupPlayer(newBalance);
	}
	
	public boolean isBlacklisted(String username) throws IOException{
		File blacklistFile = new File("blacklist.txt");
		BufferedReader reader = new BufferedReader(new FileReader(blacklistFile));
		String st;
		while ((st = reader.readLine()) != null){
			if(st.equals(username)){
				reader.close();
				return true;
			}
		}
		reader.close();
		return false;
	}
	
	public void blacklistPlayer(String username) throws IOException {
		File blacklistFile = new File("blacklist.txt");
		blacklistFile.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(blacklistFile, true));
		BufferedReader reader = new BufferedReader(new FileReader(blacklistFile));
		String st;
		while ((st = reader.readLine()) != null){
			if(st.equals(username)){
				break;
			}
		}
		if(st == null){
			writer.append(username);
			writer.newLine();
			writer.close();
		}
		reader.close();
		
	}
	public void periodicBalanceBackup(){
		Timer time = new Timer();
		ScheduledTask schedule = new ScheduledTask(balanceList);
		time.schedule(schedule, 5000, 5000);
	}
	
	public static void main(String[] args) throws Exception{
		Server sv = new Server();
		//Balance bl1 = new Balance(BigDecimal.valueOf(10000), "roald2", 1);
		//sv.addBalance(bl1);
		//sv.doTransaction("roald2", 3, BigDecimal.valueOf(2000));
		sv.addBalanceChangeLimit("test2", BigDecimal.valueOf(200));
		/*
		Transaction transaction = new Transaction(3, 1,
				BigDecimal.valueOf(2000), BigDecimal.valueOf(8000), 0);
		System.out.println(sv.isDuplicateTransaction(transaction));
		*/
	}
}
