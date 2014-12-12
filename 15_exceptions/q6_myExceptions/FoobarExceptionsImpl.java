public class FoobarExceptionsImpl implements FoobarExceptions {
  
  public void fooThrower() throws FooException {
    throw new FooException();
  }

  public void nullThrower() throws NullPointerException {
    throw new NullPointerException();
  }

  public void checkedInTryIfNot1(int n) {
  }
  //void checkedOutsideTryIfNot1(int n);
  //void runtimeInTryIfNot1(int n);
  // public void runtimeOutsideTryIfNot1(int n) throws FooException {

  //public void checkedOutsideTryIfNot1(int n) throws FooException {
  public void checkedOutsideTryIfNot1(int n) throws Exception {
    //throw new FooException();
    throw new Exception();
  }

  public static void main(String[] args) {
    FoobarExceptions fe = new FoobarExceptionsImpl();
    try {
      fe.checkedOutsideTryIfNot1(2);
    } catch (Exception ex) {
      System.out.println("caught");
    }
  }
}
