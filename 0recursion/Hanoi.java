class Hanoi { 
  static int h(int n) { 
    return n < 2 ? 1 : 2 * h(n - 1) + 1;
  }
  public static void main(String[] args) { 
    int n = 4;
    System.out.println(h(n));
  }
}
