// 4 Palindrome
// Create a program with a (recursive) method that takes a String paremeter 
// and returns true if the String is a palindrome and false otherwise. 
// Compare this recursive version with the iterative version you wrote in 
// past weeks.  Which one seems clearer to you?

public class Palindrome {

  public void launch() {
    // String s1 = "abca";
    // System.out.println((s1.substring(0,1) == s1.substring(1,2))? true : false);
    // System.out.println(s1.substring(1, s1.length() - 1));
    System.out.println("Enter string: ");
    System.out.println(isPal(System.console().readLine()));
   
  }
  
  boolean isPal(String str) {
    // A B C D (E) D C B A
    if (str.substring(0).length() == 1 ) {
      System.out.println("yoda1");
      return true; 
    } else if (str.substring(0).length() == 2) {
      String str1 = str.substring(0,1);
      String str2 = str.substring(1,2);
      System.out.println("str1: " + str1 + " str2: " + str2);
      if (str1.matches(str2)) {
        return true;
      } else {
        return false;
      }
    } else {
      System.out.println("hamish");
      String str1 = str.substring(0,1);
      String str2 = str.substring(str.length() - 1,str.length());
      System.out.println("str1: " + str1 + " str2: " + str2);
      if (str1.matches(str2) && isPal(str.substring(1, str.length() - 1))) {
        return true;
      } else {
        return false;
      }
    } 
  }
  
  public static void main(String[] args) {
    Palindrome p = new Palindrome();
    p.launch();
  }
}