package HW_Problem1;

import java.util.Stack;

public class Client {

	public String name;
	public double balance;
	public Transaction receipt;
	public Stack<Transaction> history = new Stack<Transaction>();
	
	public Client(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public Transaction getReciept()
	{
		return this.receipt;
	}
	
	public double getBalance()
	{
		return this.balance;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void changeBalance(double change)
	{
		this.balance += change;
	}
	
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	
	public void addTransaction(Transaction e)
	{
		history.push(e);
	}
	
	public Transaction getHistory()
	{
		if(!history.empty())
		{
			return history.peek();
		}
		else
		{
			return null;
		}
	}
	
	public String getAllTransactions()
	{
		String temp = "";
		while(!history.isEmpty())
		{
			temp += history.pop() + "\n";
		}
		return temp;
	}
	

}
