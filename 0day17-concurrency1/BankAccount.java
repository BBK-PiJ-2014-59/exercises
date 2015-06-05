public class BankAccount {
  private int balance = 0;
  private Object lock;
  lock = new Object();

  public int getBalance() {
    return balance;
  }
  public void deposit(int money) {
    balance = balance + money;
  }
  public int retrieve(int money) {
    int result = 0;
    if (balance > money) {
      result = money;
    } else {
      result = balance;
    }
    balance = balance - result;
    return result;
  }
}

public class Increaser implements Runnable { 

  private Counter c;
  public Increaser(Counter counter) { 

    this.c = counter;
  }
  public static void main(String args[]) { 

    Counter counter = new Counter();
    for (int i = 0; i < 100; i++) { 

      Increaser increaserTask = new Increaser(counter);
      Thread t = new Thread(increaserTask);
      t.start();
    }
  }
  public void run() { 

    System.out.println("Starting at " + c.getCount());
    for (int i = 0; i < 1000; i++) { 

      c.increase();
    }
    System.out.println("Stopping at " + c.getCount());
  }
}
public class Counter { 

  private int n = 0;
  public void increase() { 

    n++;
  }
  public int getCount() { 

    return n;
  }
}
