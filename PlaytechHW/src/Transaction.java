import java.math.BigDecimal;


public class Transaction {

	private int transactionID;
	private int balanceVersion;
	private BigDecimal balanceChange;
	private BigDecimal newBalance;
	private int errorCode;
	
	public Transaction(int transactionID, int balanceVersion, BigDecimal balanceChange, 
			BigDecimal newBalance, int errorCode){
		this.transactionID = transactionID;
		this.balanceVersion = balanceVersion;
		this.balanceChange = balanceChange;
		this.newBalance = newBalance;
		this.errorCode = errorCode;
	}
	
	public int getTransactionID(){
		return transactionID;
	}
	public int getBalanceVersion(){
		return balanceVersion;
	}
	public BigDecimal getBalanceChange(){
		return balanceChange;
	}
	public BigDecimal getNewBalance(){
		return newBalance;
	}
	public int getErrorCode(){
		return errorCode;
	}
	public String toString(){
		return "Transaction ID is " + transactionID + ", balance version is " + balanceVersion + 
				", balance change is " + balanceChange + ", new balance is " + newBalance + 
				" and errorcode is " + errorCode;
	}
}
