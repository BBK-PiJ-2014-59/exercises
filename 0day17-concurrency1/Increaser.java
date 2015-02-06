public class Increaser implements Runnable { 

  private Counter c;


  private static final int maxi = 10000;
  private static final int maxj = 10000;

  public Increaser(Counter counter) { 
    this.c = counter;
  }

  public static void main(String args[]) { 

    Counter counter = new Counter();
    //for (int i = 0; i < 100; i++) { 
    for (int i = 0; i < maxi; i++) { 

      Increaser increaserTask = new Increaser(counter);
      Thread t = new Thread(increaserTask);
      System.out.println("Starting thread " + i);
      t.start();
    }
  }
  public void run() { 

    System.out.println("Starting at " + c.getCount());
    //for (int j = 0; j < 1000; j++) { 
    for (int j = 0; j < maxj; j++) { 

      c.increase();
    }
    System.out.println("Stopping at " + c.getCount());
  }
}
class Counter { 

  private Object lock = new Object();

  private int n = 0;
  public void increase() { 
    synchronized(lock) { 
      n++;
    }
  }
  public int getCount() { 
    return n;
  }
}
