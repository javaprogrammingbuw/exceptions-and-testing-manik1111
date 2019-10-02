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

  //Test Bank Account
  @Test public static void InitTest1() {
    //define
    Person owner = new Person("John Doe");
    BankAccount account = new BankAccount(owner, 1000.00);
    //test
    assertEquals(1000.00,account.getBalance(),0.001);
  }
}
