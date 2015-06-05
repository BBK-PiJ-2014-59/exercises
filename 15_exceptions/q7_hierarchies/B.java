public class B extends A {
  @Override
  public void thrower() {
    throw new BException();
  }
}
