import org.junit.*;

public class FoobarExceptionsTests {

  FoobarExceptions fe;

  @Before
  public void beforeTests() {
    fe = new FoobarExceptionsImpl();
  }
    
  //@Test (expected=FooException.class) 
  public void test_checked_inTryBlock_throws_FooException() {
    fe.checkedInTryIfNot1(2);
  }

  //@Test (expected=FooException.class) 
  //@Test (expected=Exception.class) 
  /*
  public void test_checked_outsideTryBlock_throws_FooException() {
    fe.checkedOutsideTryIfNot1(2);
  }
  */

  @Test (expected=NullPointerException.class) 
  public void test_nullThrower() {
    fe.nullThrower();
  }

  @Test (expected=FooException.class) 
  public void test_fooThrower() {
    try {
      fe.fooThrower();
    } catch (FooException ex) { 
    }
  }

}
