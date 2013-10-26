import java.util.*;

public class Fibonacci {
    static Map<Integer, Integer> calculated = new HashMap<Integer, Integer>();

  int fib3(int n) {
          Fibonacci.calculated.put(1, 1); 
          Fibonacci.calculated.put(2, 1); 
          int fibn2, fibn1;
          if (n == 1 || n == 2) {
            return 1;
          } else {
            // int curfib = Fibonacci.fibs.get(n - 2) + Fibonacci.fibs.get(n - 1);
            if (Fibonacci.calculated.containsKey(n - 2)) {
              fibn2 = Fibonacci.calculated.get(n - 2);
            } else {
              fibn2 = fib3(n - 2);
              Fibonacci.calculated.put(n - 2, fibn2);
            }
            if (Fibonacci.calculated.containsKey(n - 1)) {
              fibn1 = Fibonacci.calculated.get(n - 1);
            } else {
              fibn1 = fib3(n - 1);
              Fibonacci.calculated.put(n - 1, fibn1);
            }
            return fibn2 + fibn1; 
          } 
  }

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
    System.out.println(f.fib3(45));
  }
}