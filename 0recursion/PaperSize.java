class PaperSize { 
  static int mkint(String s) { 
    int result = 0;
    s = s.substring(1); 
    Integer n = Integer.parseInt(s);
    if (n > 0)
      result = n;
    else
      for (int i=0; i < s.length(); i++)
        result--;
    return result;

  }
  static double len(int a) { 
    return (a == 0) ? 1189.0 : 0.5 * wid(a-1);
  }
  static double wid(int a) { 
    return (a == 0) ? 841 : len(a-1);
  }
  static void size(String s) { 
    int n = mkint(s);
    System.out.println("Size of " + s + " = " + len(n) + " x " + wid(n));
  }
  public static void main(String[] args) { 
    String s = "A0000";
    System.out.println(mkint(s));
    size(s);

  }
}
