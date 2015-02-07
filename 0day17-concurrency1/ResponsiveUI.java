/* 4
Responsive UI
Write a program that asks from the user the timegth in milliseconds of ten tasks. As the user enters the timegth, the
tasks start running in the background while the user enters the timegth of the other tasks. When the tasks end, the
program must register it and say it unless it is waiting for the user to enter data. 
Note that several tasks may end in between two user inputs.
*/

import java.util.ArrayList;
import java.util.List;

public class ResponsiveUI { 

  public void launch() { 
    for (int i=0; i<10; ++i) { 
      System.out.println("Input time in ms: ");
      int time = Integer.parseInt(System.console().readLine());
      Thread t = new Thread(new Task(time));
      t.start();
      Task.printReturned();
    }
  }

  public static void main(String[] args) { 
    ResponsiveUI rui = new ResponsiveUI(); 
    rui.launch();
  }
}

class Task implements Runnable { 
  int time;
  private static List<String> returned = new ArrayList<>();
  private Object lock = new Object();

  public static void printReturned() { 
    System.out.println("Finished: " + returned); 
  }

  public void addToReturned(String threadNo) { 
    returned.add(threadNo);
  }

  public Task(int time) { 
    this.time = time;
  }
  public void run() { 
    try { 
      String me = Thread.currentThread().getName();
      //System.out.println("Starting " + me);
      Thread.sleep(time);
      //System.out.println("Finishing " + me);
      addToReturned(me);
    } catch (InterruptedException e) { 
      e.printStackTrace();
    }
  }
}
