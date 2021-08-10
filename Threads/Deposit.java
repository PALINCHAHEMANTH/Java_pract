import java.io.*;

public class Deposit
{
	static int balance = 1000;

	public static void main(String[] args) 
	{
		PrintWriter out = new PrintWriter(System.out, true);
		
		Account account = new Account(out);
		
		DepositThread first;
		DepositThread second;

		first  = new DepositThread(account, 1000, "ANJALI");
		second = new DepositThread(account, 1000, "\t\t\t\t\t SHRUTHI");

		first.start();
		second.start();

		//Wait for the both the threads to finish
		try
		{
			first.join();
			second.join();
		}
		catch(InterruptedException ie){}

		out.println("Final Balance is............ : "+balance);
	}
}

class Account
{
	PrintWriter out;

	public Account(PrintWriter out)
	{
		this.out = out;
	}

	public void deposit(int amount, String name)
	{
		int balance;

		out.println(name +" trying to deposit "+amount);

		out.println(name +" getting Balance......");

		balance = getBalance();

		out.println("Balance got is......"+ balance);

		balance += amount;

		out.println(name +" setting Balance......");

		setBalance(balance);

		out.println(name +" new Balance set to "+Deposit.balance);
	}

	public int getBalance()
	{
		try
		{
			Thread.sleep(5000);
		}
		catch(InterruptedException ie){}

		return Deposit.balance;
	}

	public void setBalance(int balance)
	{
		try
		{
			Thread.sleep(5000);
		}
		catch(InterruptedException ie){}

		Deposit.balance = balance;
	}
}

class DepositThread extends Thread
{
	Account account;
	int amount;
	String name;

	public DepositThread(Account account, int amount, String name)
	{
		this.account = account;
		this.amount  = amount;
		this.name	 = name;
	}

	public void run()
	{
		account.deposit(amount, name);
	}
}