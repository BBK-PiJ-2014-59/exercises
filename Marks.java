// Make a class that implements a method that reads a list of marks between 0 and 100 from the user, one per line, and stops when the user introduces a -1. The program should output at the end (and only at the end) how many marks there were in total, how many were distinctions (70–100), how many were passes (50–69), how many failed (0–49), and how many were invalid (e.g. 150 or -3).  Use readLine() exactly once.

public class Marks {
  
  private void ask() {
    int d = 0;
    int p = 0;
    int f = 0; 
    int mark;
    do {
      System.out.println("enter a mark: ");
      mark = Integer.parseInt(System.console().readLine()); 
      if (mark >= 70 && mark <= 100) {
        ++d; 
      } else if (mark < 70 && mark >= 50) {
        ++p;
      } else if (mark < 50 && mark != -1) {
        ++f;
      }
    } while (mark != -1);

    System.out.println("Distinctions: " + d);
    System.out.println("Passes: " + p);
    System.out.println("Fails: " + f);
  }

  public static void main(String[] args) {
    Marks m = new Marks();
    m.ask();
  }
}
