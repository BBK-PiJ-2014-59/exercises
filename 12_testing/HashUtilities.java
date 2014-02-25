public class HashUtilities {

  public static int shortHash(int n) {
    int result = Math.abs(n) % 1000;
    return result;    
  } 

  public static void main(String[] args) {
    /* System.out.println("Give me a string and I will calculate its hashcode."); 
    String str = System.console().readLine();
    int hash = str.hashCode();
    int smallHash = shortHash(hash);
    System.out.println("0 < " + smallHash + " < 1000");
    */
    System.out.println(shortHash(1001));  
  }
}
