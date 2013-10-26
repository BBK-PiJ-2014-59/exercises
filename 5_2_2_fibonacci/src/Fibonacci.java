import java.util.*;

public class Fibonacci {
  int fib(int n) {
    if (n == 1 || n == 2) {
      return 1;
    } else {
      return fib(n - 2) + fib(n - 1); 
    }
  }
  int fib2(int n) {
    // 1, 1, 1 + 1, 1 + (1 + 1), 1 + (1 + (1 + 1)), 1 + (1 + (1 + (1 + 1))) 
    List<Integer> fibs = new ArrayList<Integer>();
    fibs.add(1); 
    int penultimate = fibs.get(fibs.size() - 1);
    fibs.add(1); 
    int last = fibs.get(fibs.size() - 1);
    for (; n > 2; --n) {
      fibs.add(penultimate + last);
      penultimate = fibs.get(fibs.size() - 2);
      last = fibs.get(fibs.size() - 1);
    }
    return fibs.get(fibs.size() - 1);
  }

  public static void main(String[] args) {
    Fibonacci f = new Fibonacci();
    System.out.println(f.fib2(45));
  }
}