class Fibonacci { 
  private long[] pre = null;

  private long f1(int n) { 
    if (n < 3) { 
      //System.out.println("n: " + n);
      return 1;
    }
    else
      return f1(n - 1) + f1(n - 2);
  }


  private long f2(int n) { 
    long result;
    if (pre == null) 
      initPre(n);
    if (pre[n-1] != -1) { 
      result = pre[n-1];  
    } else { 
      result = f2(n-1) + f2(n-2);
      pre[n-1] = result;
    }
    return result;
  }

  private void initPre(int size) { 
    pre = new long[size];
    for (int i=0; i<size; i++) pre[i] = -1; 
    pre[0] = 1;
    pre[1] = 1;
  }

  public static void main(String[] args) { 
    Fibonacci fib = new Fibonacci();
    if (args[1].equals("f1"))
      System.out.println("f1: " + fib.f1(Integer.parseInt(args[0])));
    else if (args[1].equals("f2"))
      System.out.println("f2: " + fib.f2(Integer.parseInt(args[0])));
  }
}
