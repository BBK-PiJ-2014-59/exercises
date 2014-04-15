import org.junit.*;
import static org.junit.Assert.*;

public class TestTreeIntSet {

  TreeIntSet set;

  @Before
  public void buildUp() {
    set = new TreeIntSet(2);
  }

  @Test
  public void testsAdd() {
    set.add(5); 
    assertTrue(set.contains(5));
  }

  @Test
  public void testsContains() {
  }

  @Test
  public void testsContainsVerbose() {
  }

  @Test
  public void testsToString() {
  }

}
