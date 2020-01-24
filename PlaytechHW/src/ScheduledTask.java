import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.TimerTask;


public class ScheduledTask extends TimerTask{

	private static List<Balance> balanceList;
	
	public ScheduledTask(List<Balance> balanceList){
		this.balanceList = balanceList;
	}
	public void backupPlayer(Balance balance) throws ClassNotFoundException{
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
				if(balance.getUsername().equals(resultSet.getString("USERNAME"))){
					updateQuery = true;
					statement.executeUpdate("UPDATE PLAYER SET BALANCE_VERSION='"+balance.getBalanceVersion()+"'"
							+ ", BALANCE='"+balance.getBalance()+"' WHERE USERNAME='"+balance.getUsername()+"'");
					}
				}
			if(!updateQuery){
				statement.executeUpdate("INSERT INTO PLAYER values('"+balance.getUsername()+"', '"+balance.getBalanceVersion()+"', '"+balance.getBalance()+"')");
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
	
	@Override
	public void run() {
		for(int i = 0; i < balanceList.size(); i++){
			Balance balance = balanceList.get(i);
			try {
				backupPlayer(balance);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	

}
