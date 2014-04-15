import org.junit.*;
import static org.junit.Assert.*;

public class TestIntSet {

  IntSet set;

  @Before
  public void buildUp() {
    set = new TreeIntSet(2);
  }

  @Test
  public void testsAdd() {
    set.add(5); 
    assertTrue(set.contains(6));
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
