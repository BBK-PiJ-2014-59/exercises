import org.junit.*;
import static org.junit.Assert.*;
import static java.lang.Math.*;

public class HashUtilitiesTest {
  @Test
  public void testsShortHashOfRandomNumbers() {
    System.out.println();
    int maxInt = 2147483647; // 2^31 - 1
    int minInt = -2147483648; // -1 * 2^31
    int times = (int)pow(2, 26);
    for (int i = 0; i < times; i++) {
      int randy = getRandomInt(minInt, maxInt);
      // System.out.println(randy);
      int hash = HashUtilities.shortHash(randy);
      // System.out.println("randy: " + randy);
      // System.out.println("hash: " + hash);
      // assertEquals(HashUtilities.shortHash(randy), 0);
      boolean inRange = (0 <= hash && hash <= 1000);
      assertTrue("0 <= randy <= 1000", inRange);
    }
  }

  public int getRandomInt(int Min, int Max) {
    double range = (double)Max - (double)Min;
    int result = (int)(Min + (Math.random() * (range + 1)));
    return result;
  }

}
