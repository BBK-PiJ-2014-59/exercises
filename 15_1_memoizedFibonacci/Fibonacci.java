public class Fibonacci {
  
  private static int[] precalculated = null;

  private static void initPrecalculatedArray(int size) {
    precalculated = new int[size]; 
    for (int i=0; i < precalculated.length; i++) { 
      precalculated[i] = -1;
    }
    precalculated[0] = 1;
    precalculated[1] = 1;
  }

  public static int fibNormal(int n) {
    if ((n == 1) || (n == 2)) {
      return 1;
    } else {
      return fibNormal(n-1) + fibNormal(n-2);
    } 
  }

  public static int fibMemoized(int n) {
    if (precalculated == null) {
      initPrecalculatedArray(n);
    }
    if (precalculated[n-1] != -1) {
      return precalculated[n-1];    
    } else {
      int result = fibMemoized(n-1) + fibMemoized(n-2); 
      precalculated[n-1] = result;
      return result;
    } 
    
  } 
  
  public static void main(String[] args) {
    // System.out.println(fibNormal(41));
    System.out.println(fibMemoized(4500));
  }

}
