import java.util.Random;

public class BankAccount{

	private String iban = "DE00123456780000000000";
	private Person owner;
	private double balance;
	private double limit;
	private int securityNumber;


	public BankAccount(Person owner, double balance, double limit){
		this.owner=owner;
		this.balance=balance;
		this.limit=limit;
		iban=generateIBAN();
		securityNumber=generateSecurityNumber();


	}
	public BankAccount(Person owner, double balance){
		this.owner=owner;
		this.balance=balance;
		iban=generateIBAN();
		securityNumber=generateSecurityNumber();
		this.limit=0.0;
	}

	public String generateIBAN(){
		Random r = new Random();
		String result = iban.substring(0 , iban.length()-10);
		for(int i=0 ; i<10 ; i++){
			int num=r.nextInt(10);
			result+=num;
		}
		return result;
	}
	public int generateSecurityNumber(){
		Random r= new Random();
		String temp = "";
		for (int i=0 ; i<6 ; i++){
			temp+=(r.nextInt(9)+1);
		}
		securityNumber = Integer.parseInt(temp);
		return securityNumber;
	}
	public int getSecurityNumber(){
		return securityNumber;
	}
	public void setSecurityNumber(int securityNumber){
		this.securityNumber=securityNumber;
	}
	public double getBalance(){
		return balance;
	}
	public void setBalance(double balance){
		this.balance=balance;
	}
	public String getIban(){
		return iban;
	}
	public void setIban(String iban){
		this.iban=iban;
	}
	public Person getOwner(){
		return owner;
	}
	public void setOwner(Person owner){
		this.owner=owner;
	}
	public double getLimit(){
		return limit;
	}
	public void setLimit(double limit){
		this.limit=limit;
	}
	public void deposit(double amount, int securityNumber){
		if(getSecurityNumber() == securityNumber){
		balance=balance+amount;
	}
	}
	public void withdraw(double amount, int securityNumber){
		if(getSecurityNumber() == securityNumber && amount<=balance+limit){
				balance = balance-amount;
		}
		else if(getSecurityNumber() == securityNumber && amount>=balance+limit){
			System.out.println("Sorry, insufficient balance.\nBalance: " + balance +"\nlimit: " + limit);
		}
		else{
			System.out.println("Error! withdraw not possible!");
		}
	}
	public void transfer(String remoteIban, double amount, int securityNumber){
		if(getSecurityNumber() == securityNumber && amount<=balance+limit){
			balance=balance-amount;
			System.out.println("Transfer Successful");
		}else if(getSecurityNumber() == securityNumber && amount>=balance+limit){
			System.out.println("Sorry,insufficient balance.\nBalance: " + balance +"\nlimit: " + limit);
		}else{
			System.out.println("Error! Transfer not possible!");
		}
	}
}