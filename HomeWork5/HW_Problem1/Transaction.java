package HW_Problem1;

public class Transaction {
	
	private String type;
	private double amount;

	public Transaction(String type, double amount) {
		this.type = type;
		this.amount = amount;
	}
	
	public String getType()
	{
		return this.type;
	}
	
	public double getAmount()
	{
		return this.amount;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public void setAmount(double amount)
	{
		this.amount = amount;
	}
	
	public String toString()
	{
		return this.type + "   \tAmount: $" + this.amount;
	}

}
