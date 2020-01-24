import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;


public class Client {

	private String username;
	private static int transactionID = 0;
	private static Server server;
	
	public Client(String username, Server server) throws ClassNotFoundException{
		this.username = username;
		this.server = server;
		this.transactionID = getTransactionID();
	}
	public int getTransactionID() throws ClassNotFoundException{
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		try{
			connection = DriverManager.getConnection("jdbc:sqlite:balances.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS LATESTTRANSACTIONID (TRANSACTIONID INTEGER)");
			statement.executeUpdate("INSERT INTO LATESTTRANSACTIONID values('"+transactionID+"')");
			System.out.println("in getTransactionID method");
			ResultSet resultSet = statement.executeQuery("SELECT * from LATESTTRANSACTIONID");
			System.out.println("in getTransactionID method2");
			int id = resultSet.getInt("TRANSACTIONID");
			System.out.println("in getTransactionID method id: " + id);
			connection.close();
			return id;
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
		return 0;
	}
	
	public void updateTransactionID() throws ClassNotFoundException{
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		try{
			connection = DriverManager.getConnection("jdbc:sqlite:balances.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			statement.executeUpdate("DROP TABLE IF EXISTS LATESTTRANSACTIONID");
			statement.executeUpdate("CREATE TABLE LATESTTRANSACTIONID (TRANSACTIONID INTEGER)");
			statement.executeUpdate("INSERT INTO LATESTTRANSACTIONID values('"+transactionID+"')");
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
	
	public void changeBalance(BigDecimal change) throws IOException, ClassNotFoundException{
		Transaction transaction = server.doTransaction(username, transactionID, change);
		if(transaction.getErrorCode() == 0){
			System.out.println(transaction.toString());
			transactionID++;
			updateTransactionID();
		} else if(transaction.getErrorCode() == 1){
			System.out.println("Player is blacklisted");
		} else if(transaction.getErrorCode() == 2){
			System.out.println("Balance change is over the limit");
		} else if(transaction.getErrorCode() == 3){
			System.out.println("Balance went below 0");
		} else if(transaction.getErrorCode() == 4){
			System.out.println("Balance is missing");
		}
		
	}
	public void createBalance(BigDecimal balance) throws ClassNotFoundException{
		Balance bl = new Balance(balance, username);
		server.addBalance(bl);
	}
	
	public static void main(String[] args) throws Exception{
		Server newServer = new Server();
		newServer.periodicBalanceBackup();
		Client cl1 = new Client("roald2", newServer);
		//cl1.createBalance(BigDecimal.valueOf(10000));
		//Balance bl1 = new Balance(BigDecimal.valueOf(10000), "roald2", 1);
		//Server.addBalance(bl1);
		cl1.changeBalance(BigDecimal.valueOf(500));
		cl1.changeBalance(BigDecimal.valueOf(1000));
		cl1.changeBalance(BigDecimal.valueOf(55));
		Client cl2 = new Client("roald3", newServer);
		//cl2.createBalance(BigDecimal.valueOf(20000));
		//Balance bl2 = new Balance(BigDecimal.valueOf(20000), "roald3", 1);
		//Server.addBalance(bl2);
		//Server.addBalanceChangeLimit("roald3", BigDecimal.valueOf(500));
		cl2.changeBalance(BigDecimal.valueOf(500));
		cl2.changeBalance(BigDecimal.valueOf(1000));
		cl2.changeBalance(BigDecimal.valueOf(55));
	}
	
}
