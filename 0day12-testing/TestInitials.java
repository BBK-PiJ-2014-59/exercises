import org.junit.*;
import static org.junit.Assert.*;
public class TestInitials { 

  @Test
  public void testsNormalName() { 

    Initials p = new Initials();
    String input = "Dereck Robert Yssirt";
    String output = p.getInitials(input);
    String expected = "DRY";
    assertEquals(output, expected);
  }

  @Test
  public void multipleSpacesOK() { 
    Initials p = new Initials();
    String input = "Dereck  Robert   Yssirt";
    String output = p.getInitials(input);
    String expected = "DRY";
    assertEquals(output, expected);

  }
}
