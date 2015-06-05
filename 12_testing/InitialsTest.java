import org.junit.*;
import static org.junit.Assert.*;

public class InitialsTest {
  @Test
  public void testsGetInitialsWithMultipleSpaces() {
    String str = "Jesse  O";
    String actual = Initials.getInitials(str);
    String expected = "JO";
    assertEquals(expected, actual);
  }
}
