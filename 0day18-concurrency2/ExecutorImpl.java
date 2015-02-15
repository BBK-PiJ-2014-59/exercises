/*
3 Responsive UI (that degrades gracefully)
3.1 Implement Executor
Create your own implementation of Executor. Look at the documentation of the API of Executor for ideas. Your
implementation must be able to execute one Runnable at a time (but you can make it run several tasks in paralel,
see also Exercise 6) and must have a queue of pending tasks.
Try your implementation by exchaning the class that you used in your solution for the former exercise by your
new implementation of Executor.
*/

import java.util.concurrent.Executor;
import java.util.Queue;
import java.util.ArrayDeque;

//class ExecutorImpl implements Executor {
//     public void execute(Runnable r) {
//         r.run();
//     }
//}

/*
class ExecutorThread implements Executor {
  public void execute(Runnable r) {
    new Thread(r).start();
  }
}
*/

class ExecutorImpl implements Executor {
  private Queue<Runnable> tasks = new ArrayDeque<Runnable>();
  public synchronized void execute(Runnable r) { 
    System.out.println("Offering...");
    tasks.offer(r);  
    //if ((Runnable queued = tasks.poll()) != null) { 
    System.out.println("Starting...");
    (new Thread(tasks.poll())).start(); 
  }
}
