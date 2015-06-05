class Fibonacci { 
  static int f(int n) { 
    if (n < 3) 
      return 1;
    else
      return f(n - 1) + f(n - 2);
  }
  public static void main(String[] args) { 
    for (int n = 1; n < 10; n++)
      System.out.println(f(n) + " ");
  }
}
