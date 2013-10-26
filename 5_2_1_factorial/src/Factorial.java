public class Factorial {
  int fac(int n) {
    if (n == 1) {
      return 1;
    } else {
      return n * fac(n - 1);
    }
  }

  int fac2(int n) {
    int t = 1;
    for (; n > 0; --n) 
      t = t * n;
    return t;
  }
  public static void main(String[] args) {
    Factorial f = new Factorial();
    System.out.println(f.fac2(5));
  }
}