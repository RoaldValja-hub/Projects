import java.math.BigDecimal;


public class Balance {

	private BigDecimal balance;
	private String username;
	private int balanceVersion;
	
	
	public Balance(BigDecimal balance, String username){
		this.balance = balance;
		this.username = username;
		this.balanceVersion = 1;
	}
	public Balance(BigDecimal balance, String username, int balanceVersion){
		this.balance = balance;
		this.username = username;
		this.balanceVersion = balanceVersion;
	}
	
	public BigDecimal getBalance(){
		return balance;
	}
	public String getUsername(){
		return username;
	}
	public int getBalanceVersion(){
		return balanceVersion;
	}
	public void increaseBalanceVersion(){
		balanceVersion++;
	}
	public BigDecimal changeBalance(BigDecimal change){
		balance = balance.subtract(change);
		return balance;
	}
}
