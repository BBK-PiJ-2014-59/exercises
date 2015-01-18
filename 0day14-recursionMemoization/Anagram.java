import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;

/** An anagram is a word created by recombination of the letters in another words.
  * Some anagrams make sense (“silent”, “listen”) and some do not (“nietsl”).
  * Some people only accepts “real” anagrams, but in this exercise we
  * will accept them all, even if they do not exist as real words.
  * Write a class with a static method that takes a String as a parameter and returns a list (hint: you can use
  * List<String> and ArrayList<String>) of strings with all the anagrams that can be made with it.
  * Is it easy to do this both iteratively and recursively? Is this similar to a former exercise?
  */
public class Anagram { 
  public static List<String> a(String s) { 
    List result = new ArrayList<String>();
    if (s.length() == 1)
      result.add(s);
    else { 
      for (int i=0; i<s.length(); ++i) { 
        String firstChar = s.substring(i,i+1);
        String otherChars = s.replaceAll(firstChar, "");
        for (String str : a(otherChars)) { 
          result.add("" + firstChar + str);
        }
      }
    }
    return result;
  }

  public static void main(String args[]) { 
    String s1 = "a";
    String s2 = "at";
    String s3 = "cat";
    System.out.println(s1 + " : " + Anagram.a(s1));
    System.out.println(s2 + " : " + Anagram.a(s2));
    System.out.println(s3 + " : " + Anagram.a(s3));
  }
}
