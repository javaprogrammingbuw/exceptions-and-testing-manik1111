import TinyTestJ.Test;
import static TinyTestJ.Assert.*;

public class TestSuite {

  /*Initialize*/
  //Test owner
  @Test public static void InitTest1() {
    //define
    Person owner = new Person("John Doe");
    BankAccount account = new BankAccount(owner, 1000.00);
    //test
    assertEquals(owner.getName(),account.getOwner().getName(),0.001);
  }
  // Test1 : Checking the name of the Account Holder

  //Test Bank Account
  @Test public static void InitTest2() {
    //define
    Person owner = new Person("John Doe");
    BankAccount account = new BankAccount(owner, 1000.00);
    //test
    assertEquals(1000.00,account.getBalance(),0.001);
  }
  // Checking the balance of the account 

  @Test public static void InitTest3() {
    //define
    Person owner = new Person("John Doe");
    BankAccount account = new BankAccount(owner, 1000.00,500);
    account.deposit(1200.0, account.getSecurityNumber());
    //test
    assertEquals(2200.0,account.getBalance(),0.001);
  }
  // Checking the balance after deposit

  @Test public static void InitTest4() {
    //define
    Person owner = new Person("John Doe");
    BankAccount account = new BankAccount(owner, 1000.00,500);
    account.withdraw(600.0, account.getSecurityNumber());
    //test
    assertEquals(400.0,account.getBalance(),0.001);
  }
  // Checking the balance after withdrawal

  @Test public static void InitTest5() {
    //define
    Person owner = new Person("John Doe");
    BankAccount account = new BankAccount(owner, 1000.00);
    int length = Integer.toString(account.getSecurityNumber()).length();
    //test
    assertEquals(6,length,0.001);
  }
   // Checking the security number length

  @Test public static void InitTest6() {
    //define
    Person owner = new Person("John Doe");
    BankAccount account = new BankAccount(owner, 1000.00);

    //test
    assertEquals(22,account.getIban().length(),0.001);
  }
  // Checking the IBAN of the account

  @Test public static void InitTest7() {
    //define
    Person owner = new Person("John Doe");
    BankAccount account = new BankAccount(owner, 0.0,500);
    account.withdraw(400.0,account.getSecurityNumber());
    //test
    assertEquals(-400,account.getBalance(),0.001);
  }
  // Checking balance after withdrawal with 0.0 balance and limit 500.0

  @Test public static void InitTest8() {
    //define
    Person owner = new Person("John Doe");
    BankAccount account = new BankAccount(owner, 4000.00,1000);
    account.withdraw(2100,account.getSecurityNumber());
    account.deposit(1050, account.getSecurityNumber());
    //test
    assertEquals(2950.0,account.getBalance(),0.001);
  }
  // Checking balance after withdrawal and deposit

  @Test public static void InitTest9() {
    //define
    Person owner = new Person("John Doe");
    Person person = new Person("Manik");
    BankAccount account = new BankAccount(owner, 1000.00);
    BankAccount other = new BankAccount(person, 1500.0);
    account.transfer(other.getIban(),500.0, account.getSecurityNumber());
    
        //test
    assertEquals(500.0,account.getBalance(),0.001);
  }
  // Transfer amount from John Doe to Manik account and checking balance of John Doe Account

  @Test public static void InitTest10() {
    //define
    Person owner = new Person("John Doe");
    Person person = new Person("Manik");
    BankAccount account = new BankAccount(owner, 1000.00,100.0);
    BankAccount other = new BankAccount(person, 1500.0);
    other.transfer(account.getIban(),500.0, other.getSecurityNumber());

    //test
    assertEquals(1000.0,other.getBalance(),0.001);

  }
  // Transfer amount from Manik to John Doe account and checking balance of Manik

  @Test public static void InitTest11() {
    //define
    Person owner = new Person("John Doe");
    Person person = new Person("Manik");
    BankAccount account = new BankAccount(owner, 1000.00,100.0);
    BankAccount other = new BankAccount(person, 1500.0);
    account.transfer(other.getIban(),500.0, account.getSecurityNumber());
    account.withdraw(200.0,account.getSecurityNumber());
    //test
    assertEquals(300.0,account.getBalance(),0.001);
  }
  // Transfer and withdrawal from John Doe account and checking the balance

  @Test public static void InitTest12() {
    //define
    Person owner = new Person("John Doe");
    Person person = new Person("Manik");
    BankAccount account = new BankAccount(owner, 1000.00,100.0);
    BankAccount other = new BankAccount(person, 1500.0);
    account.transfer(other.getIban(),500.0, account.getSecurityNumber());
    account.withdraw(100.0,account.getSecurityNumber());
    account.deposit(5000.0,account.getSecurityNumber());
    //test
    assertEquals(5400.0,account.getBalance(),0.001);
  }
  // Checking balance after transfer, withdrawal and deposit of John Doe's Account

  @Test public static void InitTest13() {
    //define
    Person owner = new Person("John Doe");
    BankAccount account = new BankAccount(owner, 1000.00);
    account.withdraw(0.0,account.getSecurityNumber());
    //test
    assertEquals(1000.00,account.getBalance(),0.001);
  }
  // Checking balance with withdrawal as 0.0

  @Test public static void InitTest14() {
    //define
    Person owner = new Person("John Doe");
    Person person= new Person("Manik");
    BankAccount account = new BankAccount(owner, 1000.00, 100.0);
    BankAccount other = new BankAccount(person,1500);
    account.transfer(other.getIban(),0.0,account.getSecurityNumber());
    //test
    assertEquals(1500.00,other.getBalance(),0.001);
  }
  // Checking balance after transfer as 0.0

  @Test public static void InitTest15() {
    //define
    Person owner = new Person("John Doe");
    BankAccount account = new BankAccount(owner, 1000.00);
    //test
    assertEquals(0.0,account.getLimit(),0.001);
  }
  // Checking limit of the account

@Test public static void InitTest16() {
    //define
    Person owner = new Person("John Doe");
    Person person= new Person("Manik");
    BankAccount account = new BankAccount(owner, 1000.00, 100.0);
    BankAccount other = new BankAccount(person,1500);
    account.transfer(other.getIban(),1200,account.getSecurityNumber());
    //test
    assertEquals(1000,account.getBalance(),0.001);
  }
  // Tranfer amount exceeds balance+limit and checking the balance

  @Test public static void InitTest17() {
    //define
    Person owner = new Person("John Doe");
    BankAccount account = new BankAccount(owner, 1000.00,500);
    account.withdraw(1600.0, account.getSecurityNumber());
    //test
    assertEquals(1000.0,account.getBalance(),0.001);
  }
  // Checking balance after withdrawal exceeds balance + limit.

  @Test public static void InitTest18() {
    //define
    Person owner = new Person("John Doe");
    BankAccount account = new BankAccount(owner, 1000.00,500);
    account.withdraw(1600.0, 123456);
    //test
    assertEquals(1000.0,account.getBalance(),0.001);
  }
  // Checking if the security number is correct 

}