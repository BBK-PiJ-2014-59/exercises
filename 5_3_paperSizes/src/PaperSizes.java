// 3 Paper sizes (*)
// A Din-A0 sheet of paper is 841mm × 1189mm (its surface is one square
// meter). Successive measurements of paper are defined recursively as 
// “half” or “double” the preceding size. Therefore, a Din-A1 sheet of 
// paper is half of Din-A0, or 594mm × 841mm; while a Din-A00 is double of 
// Din-A0, or 1189mm× 1682mm.  Create a method that takes a String parameter 
// representing a size (e.g. ”A4”, “A00000”) and prints on screen the size 
// of the corresponding sheet of paper. For simplicity, you can ignore rounding
// errors when calculating smaller sizes.  Hint: note that two consecutive 
// sizes always share one side and only the other one is multiplied or divided
// by two, e.g. the short side of Din-A2 is as long as the long side of 
// Din-A3, while the long side of Din-A2 is twice as long as the short side 
// of Din-A3.

// or instead of as follows do it so you just return one dimension instead of
// an object with two, and then calculate the other from it.

public class PaperSizes {
  static double a4long = 1189.0;
  static double a4short = 841.0;
  public double getShortSide(int n) {
    if (n == 4) {
      return a4short;
    } else if (n > 4) {
      System.out.println(n + " > 4");
      return (a4long / (2 * a4short)) * getShortSide(n - 1);
    } else if (n < 4) {
      System.out.println(n + " < 4");
      return ((2 * a4short) / a4long) * getShortSide(n + 1);
    } else {
      return -1;
    }
  } 
  public static void main(String[] args) {
    PaperSizes p = new PaperSizes();
    System.out.println(p.getShortSide(4));
  }
}