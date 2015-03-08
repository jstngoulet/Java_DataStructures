package HW_Problem1;
/**
 * 
 * This application was created by the following student:
 * 		@author Justin Goulet
 * 		@dateLastModified: 03.06.2015
 * 		@description: under the circumstances given, 
 * this application both simulates or allows a user to go through a banking day by having a 
 * line of custmers and fullfuilling their needs. The application has several options and 
 * all can be achieved by selecting the proper input. Under conditions, there are five options:
 * 	1) Withdraw - The user can withdraw a balance up to the maximum in their account
 * 	2) Deposit - The user can deposit any amount into the system
 * 	3) Open New Account - If the user does not exist and they wish to deposit or withdraw, they have to create an account first.
 * 		This allows the customer to put in their starting balance and then finish their transaction
 * 	4) Close account - This option will withdraw all monies in the person's account and show a complete list of transactions
 * 		during the time in which the application was open. It will show both type of transaction and the amount it changed
 * 	5) View last transaction - Also in a stack, the user can see what their last transaction was. This include type and amount
 * 	6) The user can close the bank and skip everyone in front of the line. This would hopefully only happen if the bank runs 
 * out of money. You never know!
 */
import java.util.Scanner;

import java.util.*;

public class BankTeller {
	private String name, key = "";
	private double balance;
	private static Scanner keyboard;
	private int transactionCounter = 0, maxOfOperations = 5;
	
	//We need to create an arraylist and a stack. 
	//The arraylist will hld all current clients. the stack holds all patrons standing in line.
	ArrayList<Client> clients = new ArrayList<Client>();
	Stack<Client> line = new Stack<Client>();
	
	public static void main(String [] args)
	{
		new BankTeller();
	}

	public BankTeller() {
		//create a few accounts already in the system
		Client shaggy = new Client("Shaggy", 12345);
		Client fred = new Client("Fred", 51212);
		Client scooby = new Client("Scooby", 12);
		Client wilma = new Client("Wilma", 1241);
		Client daphne = new Client("Daphne", 1231);
		
		//Add all clients to the database
		clients.add(shaggy);
		clients.add(fred);
		clients.add(scooby);
		clients.add(wilma);
		clients.add(daphne);
		
		//Now, that we have a working bank, let's simulate the experience
		//First, create a line of people - Let's say that some of the people are already in the system
		line.push(shaggy);//Bottom
		line.push(scooby);
		line.push(new Client("Justin", 1234));
		line.push(new Client("Shelly", 321551));
		line.push(new Client("Sally", 22));
		line.push(daphne);
		line.push(wilma);//Top
		
		//Now that we have our line of people, 
		//we are going to replace everywhere we get the name 
		//with the person on top of the stack
		
			//Change while loop from: while(key.endsWith("end")); for simulation
		welcomeClient();
		nslog("Good Bye!");
	}
	
	public void welcomeClient()
	{
		//key = getInput();
		while(!line.isEmpty())
		{
			nslog("\n\nWelcome to my bank. Please input your name: ");
			key = line.pop().getName();
			nslog("Name: " + key);

			//Increment counter first tho.
			transactionCounter++;
			if(transactionCounter == 5)
			{
				//If counter == 5, display the size of the stack and the customer next in line
				nslog("\nCustomers in line remaining " + line.size());
				nslog("Next client: " + line.peek().getName() + "\n");
				transactionCounter = 0;
			}

			name = key;
			nslog("\n\nWelcome " + name + "!\nHow may I help you?\nYou may leave at any time by saying \"End\"");
			//String task = getOption();
			//Now, instead of getting input, create a random number generator to simulate the choice
			Random rand = new Random();
			int randomNum = rand.nextInt(maxOfOperations) + 1;
			//After first time, the program gets the chance to close 
			maxOfOperations = 5;
			String task = randomNum + "";

			//But, you still need to show options
			nslog("\n1) Withdraw\t\t2) Deposit\n3) Open Account\t\t4) Close Account\n5) View Last Transaction\n6) End of Line\n");

			boolean okTask = false;

			while(okTask == false)
			{
				if(task.startsWith("w") || task.startsWith("1"))
				{
					okTask = true;
					withdraw();
				}
				else if(task.startsWith("d") || task.startsWith("2"))
				{
					okTask = true;
					deposit();
				}
				else if(task.startsWith("o") || task.startsWith("3"))
				{
					okTask = true;
					openAccount();
				}
				else if(task.startsWith("c") || task.startsWith("4"))
				{
					okTask = true;
					closeAccount();
				}
				else if(task.startsWith("v") || task.startsWith("5"))
				{
					okTask = true;
					viewHistory();
				}
				else if(task.equalsIgnoreCase("end") || task.startsWith("6"))
				{
					nslog("Leanving So soon?");
					//Get next person in line
					if(!line.isEmpty())
					{
						welcomeClient();
					}
					else
					{
						nslog("Good Bye!");
						System.exit(0);
					}
				}
				else
				{
					nslog("I am reading: " + task.charAt(0));
					nslog("Invalid Operation. Please select a valid option.");
					task = getOption();
					okTask = false;
				}
			}

			if(line.isEmpty())
			{
				key = "end";
			}

			nslog("\n1) Withdraw\t\t2) Deposit\n3) Open Account\t\t4) Close Account\n5) View Last Transaction\n6) End of Line\n");
		}
	}
	
	public String getOption()
	{
		nslog("\n1) Withdraw\t\t2) Deposit\n3) Open Account\t\t4) Close Account\n5) View Last Transaction\n6) End of Line");
		return getInput();
	}
	
	public String getInput()
	{
		keyboard = new Scanner(System.in);
		String temp = keyboard.nextLine();
		return temp;
	}
	
	public void nslog(String a)
	{
		System.out.println(a);
	}
	
	public int getRandomDollar(int max)
	{
		Random rand = new Random();
		return rand.nextInt(max) + 1;
	}
	
	public void withdraw()
	{
		if(clients.get(getIndexOfName(name)) != null)
		{
			balance = clients.get(getIndexOfName(name)).getBalance();
			//Ask how much
			nslog("How much would you care to withdraw today?\nYour balance is: $" + balance);
			double amount = 0;
			while(amount == 0)
			{
				try{
					//For the simulation, we are going to get a random dollar value
					amount = getRandomDollar((int)balance);
					//amount = Double.parseDouble(getInput());
					if(amount > balance)
					{
						throw new Exception();
					}
				}
				catch(Exception e)
				{
					nslog("Please input a valid amount");
					amount = 0;
				}
			}
			//Update balance
			double newBalance = balance - amount;
			clients.get(getIndexOfName(name)).setBalance(newBalance);
			nslog("New Balance: $" + newBalance);
			generateReciept("Withdrawl", amount);
		}
		else
		{
			nslog("Please open an account first!");
			openAccount();
		}
	}
	
	public void deposit()
	{
		if(clients.get(getIndexOfName(name)) != null)
		{
			balance = clients.get(getIndexOfName(name)).getBalance();
			//Ask how much
			nslog("How much would you care to deposit today?\nYour balance is: $" + balance);
			double amount = 0;
			while(amount == 0)
			{
				try{
					//For the simulation, we are going to get a random dollar value
					amount = getRandomDollar((int)balance);
					//amount = Double.parseDouble(getInput());
				}
				catch(Exception e)
				{
					nslog("Please input a valid amount");
					amount = 0;
				}
			}
			//Update balance
			double newBalance = balance + amount;
			clients.get(getIndexOfName(name)).setBalance(newBalance);
			nslog("New Balance: $" + newBalance);
			generateReciept("Deposit", amount);
		}
		else
		{
			nslog("Please open an account first!");
			openAccount();
		}
	}
	
	public void openAccount()
	{
		//Adds to the arraylist
		nslog("Creating account for " + name);
		nslog("What is your initial balance? ");
		double initBalance = 1000;
		while(initBalance == 0)
		{
			try{
				//For the simulation, we are going to get a random dollar value
				nslog("Balance = " + initBalance);
				//initBalance = Double.parseDouble(getInput());
			}
			catch(Exception e)
			{
				nslog("Balance not valid. Please try again");
				initBalance = 0;
			}
		}
		
		clients.add(new Client(name, initBalance));
	}
	
	public void closeAccount()
	{
		//Close account by withdrawing all funds and show all reciepts
		nslog("Closing account for " + name);
		//Withdraw funds
		balance = clients.get(getIndexOfName(name)).getBalance();
		clients.get(getIndexOfName(name)).setBalance(0);
		generateReciept("Closed Acct", balance);
		
		//Show all history
		nslog("All Account History:\n");
		nslog(clients.get(getIndexOfName(name)).getAllTransactions());
		
		//Remove client
		clients.remove(getIndexOfName(name));
		
		//End client process
		key = "end";
	}
	
	public void viewHistory()
	{
		//This only shows last transaction
		if(clients.get(getIndexOfName(name)).getHistory() != null)
		{
			nslog("Last Transaction: " + clients.get(getIndexOfName(name)).getHistory().toString());
		}
		else
		{
			nslog("No history found!");
		}
	}
	
	public void generateReciept(String type, double amount)
	{
		//This method creates a new reciept and adds it to the customers transaction list.
		clients.get(getIndexOfName(name)).addTransaction(new Transaction(type, amount));
		nslog("\nTransaction " + clients.get(getIndexOfName(name)).getHistory().toString() + " saved!");
	}
	
	//Search for client
	public int getIndexOfName(String name)
	{
		int index = 0;
		boolean contains = false;
		for(Client i : clients)
		{
			if(i.getName().equalsIgnoreCase(name))
			{
				contains = true;
				break;
			}
			index++;
		}
		if(!contains)
		{
			//Create new account
			openAccount();
			
			//This index will be one higher because it wasnt found before
			return index;
		}
		else
		{
			return index;
		}
	}

}
