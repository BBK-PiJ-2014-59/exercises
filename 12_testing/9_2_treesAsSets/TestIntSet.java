import org.junit.*;
import static org.junit.Assert.*;

public class TestIntSet {

  int nint = 100;
  IntSet set;
  int[] inta = new int[nint];

  @Before
  public void buildUp() {
    set = new TreeIntSet(2);
    for (int i=0; i<nint; i++) {
      int hi = nint * 100;
      int lo = -1 * hi; 
      int r = lo + (int)(Math.random() * ((hi - lo) + 1));
      inta[i] = r;
      set.add(r);
    }
  }

  @Test
  public void test1Add() { 
    System.out.println("TEST 1");
    boolean allFound = true;
    for (int i=0; i<nint; i++) {
      System.out.print("checking " + inta[i] + ": ");
      if (!set.contains(inta[i])) {
        allFound = false;
        System.out.println("not found");
      } else {
        System.out.println("found");
      }
    }
    assertTrue(allFound);
  }

  @Test
  public void test2ContainsVerbose() { 
    // how do you test this? Make true gets true for every contains() along the way and false gets all falses along the way.
    System.out.println("TEST 2");
    System.out.println(inta[50]);
    System.out.println(set.containsVerbose(inta[50]));
  }

  @Test
  public void testsToString() {
  }

}
