public class HashUtilities { 
  static int shortHash(int n) { 
    return Math.abs(n % 1000);
  }

  public static void main(String[] args) { 
    System.out.println("Give me a string and I will calculate its hash code");
    String str = System.console().readLine();
    int hash = str.hashCode();
    int smallHash = HashUtilities.shortHash(hash);
    System.out.println("hashCode: " + hash + " ---- 0 < " + smallHash + " < 1000");

    // Tests:
    
  }
}
