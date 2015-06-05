/* 2 Testing mathematical functions
On Day 7 you implemented a simple hash. Write a battery of tests to verify its behaviour, paying special attention to border cases.  Hint: Implement a loop that tries a fair amount of random numbers (around two thousand, for the purposes of this exercise) and verify that the output is within the range.  
*/
import org.junit.*;
import static org.junit.Assert.*;

public class HashUtilitiesTest {
  @Test
  public void testsRandomNumber() {
    System.out.println();
    // int n = -4000;
    
    for (int i = 0; i < 10000; ++i) {
      int n = getRandomInt(-20000, 20000);
      int h = HashUtilities.shortHash(n);
      System.out.println("n=" + n + " h=" + h);
      assertTrue(h >= 0 && h <= 1000);
    }
  }
  
  public int getRandomInt(int Min, int Max) {
    return Min + (int)(Math.random() * ((Max - Min) + 1));
  }
}
