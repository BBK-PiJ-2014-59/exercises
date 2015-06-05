import java.util.List;
import java.util.ArrayList;

/** The sequence hailstone numbers is defined as follows:
  * * If the number n is even, the next number is n/2
  * * If the number is odd, the next number is 3n + 1
  * It is thought that this sequence always converges to 1 (this is the Collatz conjecture, not demonstrated yet).  Write a method that returns a list of integers (hint: you can use List<Integer> and ArrayList<Integer>) with the sequence of hailstone numbers that starts at some given natural number provided by the user.
  */
public class Hailstone { 

  private static List<Integer> result = new ArrayList<Integer>();

  public static List<Integer> hail(int n) { 
    //List<Integer> result = new ArrayList<Integer>();
    if (n == 1) { 
      //System.out.println("yoda 1");
      result.add(1);
      //System.out.println("result 1: " + result);
    }
    else if (n % 2 == 0) { 
      int next = n/2;
      //System.out.println("yoda even: " + next);
      result.add(next);
      hail(next);
      //System.out.println("result E: " + result);
    } else { 
      int next = 3*n + 1;
      //System.out.println("yoda odd: " + next);
      result.add(next);
      hail(next);
      //System.out.println("result O: " + result);
    }
    return result;
  }
  public static List<Integer> hail2(int n) { 
    //System.out.println("--HAIL2--");
    List<Integer> result = new ArrayList<Integer>();
    int next;
    if (n == 1) { 
      next = 1;
      result.add(next);
      return result;
    } else if (n % 2 == 0) { 
      next = n/2;
    } else { 
      next = 3*n + 1;
    }
    result.add(next);
    System.out.println("next: " + next);
    hail2(next);
    return result;
  }

  public static void main(String[] args) { 
    int start = Integer.parseInt(System.console().readLine("Enter a number: "));
    System.out.println("hail " + start + ": " + Hailstone.hail(start));
    //System.out.println("");
    //System.out.println("hail2 " + start + ": " + Hailstone.hail2(start));
  }
}
