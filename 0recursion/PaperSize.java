class PaperSize { 
  static int mkint(String s) { 
    int result = 0;
    s = s.substring(1); 
    Integer n = Integer.parseInt(s);
    if (n > 0)
      result = n;
    else
      for (int i=1; i < s.length(); i++)
        result--;
    return result;

  }
  static double len(int a) { 
    double result = 1189.0;
    if (a < 0)
      result = 2 * wid(a + 1);
    if (a > 0)
      result = wid(a - 1);
    return result;
  }

  static double wid(int a) { 
    double result = 841;
    if (a < 0)
      result = len(a + 1);
    if (a > 0)
      result = 0.5 * len(a - 1);
    return result;
  }
  static void size(String s) { 
    int n = mkint(s);
    System.out.println("Size of " + s + " = " + len(n) + " x " + wid(n));
  }
  public static void main(String[] args) { 
    size("A4");
    size("A2");
    size("A1");
    System.out.println(mkint("A0"));
    size("A0");
    size("A00");
    size("A000");
    size("A0000");

  }


}
