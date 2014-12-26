class Palindrome { 
  static boolean p(String s) { 
    //System.out.println(s.substring(0,1));
    //System.out.println(s.substring(s.length()-1,s.length()));

    if (s.length() <= 1) return true;
    if (!s.substring(0,1).equals(s.substring(s.length()-1,s.length())))  
      return false;
    else return p(s.substring(1,s.length()-1));
  }
  public static void main(String[] args) { 
    System.out.println(p("abcccbba"));
    /*
    System.out.println(p("aa"));
    System.out.println(p("ab"));
    System.out.println(p("aba"));
    System.out.println(p("abc"));
    */
  }
}
