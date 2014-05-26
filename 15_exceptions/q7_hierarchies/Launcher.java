public class Launcher {
  public void launch() {
    C c = new C();
    ((A) c).thrower();
    //A a = new A();
    //a.thrower();
  }
  
  public static void main(String[] args) {
    Launcher l = new Launcher();
    l.launch();
  }
}
