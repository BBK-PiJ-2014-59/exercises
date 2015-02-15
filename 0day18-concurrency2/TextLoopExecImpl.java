import java.util.concurrent.Executor;

public class TextLoopExecImpl implements Runnable { 
  public static final int COUNT = 10;
  private final String name;
  public TextLoopExecImpl(String name) { 

    this.name = name;
  }
  @Override
  public void run() { 

    for (int i = 0; i < COUNT; i++) { 

      System.out.println("Loop:" + name + ", iteration:" + i + ".");
    }
  }

  public static void main(String[] args) { 
    if (args.length < 1 || (!args[0].equals("0") && !args[0].equals("1"))) { 

      System.out.println("USAGE: java TextLoopExecImpl <mode>");
      System.out.println("mode 0: without threads");
      System.out.println("mode 1: with threads");
    } else if (args[0].equals("0")) { 

      for (int i = 0; i < 10; i++) { 

        Runnable r = new TextLoopExecImpl("Thread " + i);
        r.run();
      }
    } else { 

      //ExecutorService es = Executors.newFixedThreadPool(10);
      Executor ex = new ExecutorImpl();

      for (int i = 0; i < 11; i++) { 
        Runnable r = new TextLoopExecImpl("Thread " + i);
        ex.execute(r);
      }
      //ex.shutdown();
    }
  }
}
