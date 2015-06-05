class Factorial { 
  static int fac(int n) { 
    return (n <= 1) ? 1 : n * fac(n - 1);
  }
  static int facit(int n) { 
    if (n == 1|| n == 0) return 1;
    int t = 1;
    while (n>1) t *= n--;
    return t;
  }
  public static void main(String[] args) { 
    int n = 4;
    System.out.println(fac(n));
    System.out.println(facit(n));
  }
}
