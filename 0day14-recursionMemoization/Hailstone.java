import java.util.List;
import java.util.ArrayList;

/** The sequence hailstone numbers is defined as follows:
  * * If the number n is even, the next number is n/2
  * * If the number is odd, the next number is 3n + 1
  * It is thought that this sequence always converges to 1 (this is the Collatz conjecture, not demonstrated yet).  Write a method that returns a list of integers (hint: you can use List<Integer> and ArrayList<Integer>) with the sequence of hailstone numbers that starts at some given natural number provided by the user.
  */
public class Hailstone { 
  public static List<Integer> hail(int n) { 
    List result = new ArrayList();
    if (n == 1) { 
      System.out.println("yoda 1");
      result.add(1);
    }
    else if (n % 2 == 0) { 
      int next = n/2;
      System.out.println("yoda even: " + next);
      for (int i : hail(next))
        result.add(i);
    } else { 
      int next = 3*n + 1;
      System.out.println("yoda odd: " + next);
      for (int i : hail(next))
        result.add(i);
    }
    return result;
  }
  public static List<Integer> hail2(int n) { 
    List result = new ArrayList();
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
    System.out.println("hail2 " + start + ": " + Hailstone.hail2(start));
  }
}
