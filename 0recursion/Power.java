class Power { 
  static int pow(int b, int p) { 
    if (p <= 1) 
      return b;
    else
      return b*pow(b, p-1);
  }
  public static void main(String[] args) { 
    System.out.println(pow(1,1));

  }
}
