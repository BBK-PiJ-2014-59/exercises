/**
  * 6 Your first exceptions
  * Create two exceptions, one checked exception and one runtime exception. Then create a simple class that will throw
  * each of them in two different situations, according to user input:
  * 1. inside a try block.
  * 2. outside a try block.
  * Note: Two exceptions times two situations means four different inputs from users. Create the new exceptions
  * with four different messages (using the appropriate constructor), e.g. ”I am a checked exception and I have been
  * thown out of a try block”.
  * Assuming you do all of the above inside the launch() method of your class, did you have to make any changes
  * to the method’s declaration?
  */
public interface FoobarExceptions {
  void fooThrower() throws FooException;

  void nullThrower();
  /**
    * @throws FooException if n != 1.  
    */
  void checkedInTryIfNot1(int n);

  /**
    * @throws FooException if n != 1.  
    */
  //void checkedOutsideTryIfNot1(int n) throws FooException;
  void checkedOutsideTryIfNot1(int n) throws Exception;
  //void checkedOutsideTryIfNot1(int n);
//  /**
//    * @throws BarException if n != 1.  
//    */
//  void runtimeInTryIfNot1(int n);
//  /**
//    * @throws BarException if n != 1. 
//    */
//  void runtimeOutsideTryIfNot1(int n);
}
