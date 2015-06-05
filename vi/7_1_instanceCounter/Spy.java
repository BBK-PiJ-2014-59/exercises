public class Spy {
  private int ID;
  private static int SpyCount = 0;

  private Spy (int ID) {
    this.ID = ID;
    ++Spy.SpyCount;
    System.out.println("ID: " + this.ID);
    System.out.println("SpyCount: " + Spy.SpyCount);
  }

  private static void die(int ID) {
    System.out.println("Eliminated: " + ID);
    --Spy.SpyCount;
    System.out.println("SpyCount: " + Spy.SpyCount);
  }

  public static void main(String[] args) {
    Spy s1 = new Spy(1);
    Spy s2 = new Spy(2);
    Spy s3 = new Spy(3);
    Spy s4 = new Spy(4);
    die(1);
    die(2); 
  }


}
