/* Day 12 - 4.1 Stack
 *
 * The notes from Day 8 implemented a Stack interface in two different ways.
 * Create a battery of tests that verify
 * that the classes implementing the interface is working as expected.
 * Use it to test both implementations.
 */

import org.junit.*;
import static org.junit.Assert.*;

public class StackTest {
  @Test
  public void testsImplementation() {
    StringStack aStack = new ArrayStringStack();
    String testString1 = "string1";
    aStack.push(testString1);
    assertEquals(aStack.pop(),testString1);
  }
}
