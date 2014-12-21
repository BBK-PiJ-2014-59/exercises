class Palindrome { 
  static boolean p(String s) { 
    System.out.println(s.substring(0,1));
    System.out.println(s.substring(s.length()-1,s.length()));
    if (s.substring(0,1).equals(s.substring(s.length()-1,s.length())))  
      return true;
    else return false;
  }
  public static void main(String[] args) { 
    System.out.println(p("a"));
    System.out.println(p("aa"));
    System.out.println(p("ab"));
    System.out.println(p("aba"));
    System.out.println(p("abc"));
  }
}
