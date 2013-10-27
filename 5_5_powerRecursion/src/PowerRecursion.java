// 5 Power
// Create a class with a static method pow that takes to integers (base 
// and exponent) and calculates the power, e.g. pow(2,3) calculates 2 to the 3rd.
// Is it easy to do this both iteratively and recursively?

public class PowerRecursion {
  public static int pow(int a, int b) {
    if (b == 1) {
     return a; 
    } else {
      return a * pow(a, b - 1);
    }
  } 

  public static void main (String[] args) {
    System.out.println(pow(500,5)); 
  }
}