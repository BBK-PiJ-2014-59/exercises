/* 3.2 Extend Executor
Create a class TimedTask that implements Runnable where the run() method is only a call to Thread.sleep() for
a number of milliseconds set at creation time. This number must be at most 1000 (if a higher number is given at
construction time, it must be capped at 1000).
Now extend your implementation of Executor so that it has a public method getMaxPendingTime() that returns
the maximum theoretical time needed to run all tasks in the queue (i.e assuming all of them last 1000ms).
*/

import java.util.concurrent.Executor;
import java.util.Random;

public class TimedTask implements Runnable { 
  private int length;
  public TimedTask(int length) { 
    this.length = length > 1000 ? 1000 : length; 
  }
  public void run() { 
    try { 
      Thread.sleep(length);
    } catch (InterruptedException e) { 
      e.printStackTrace();
    }
  }
  public static void main(String args[]) { 
    Executor ex = new ExecutorImpl();
    Random rand = new Random();
    for (int i = 0; i < 10; i++) { 
      Runnable r = new TimedTask(rand.nextInt(1000) + 1);
      ex.execute(r);
    }
  }
}
