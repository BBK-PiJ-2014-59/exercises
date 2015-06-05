import org.junit.*;
import static org.junit.Assert.*;

public class TestHashUtilities { 
  @Test
  public void zeroReturnsPositive() { 
    int result = HashUtilities.shortHash(0);
    assertTrue(result > 0 && result < 1000);
  }

  @Test
  public void minusOneReturnsPositive() { 
    int result = HashUtilities.shortHash(-1);
    assertTrue(result > 0 && result < 1000);
  }

  @Test
  public void OneReturnsPositive() { 
    int myInt = 1;
    int result = HashUtilities.shortHash(myInt);
    assertTrue(result > 0 && result < 1000);
  }

  @Test
  public void OneThousandReturnsPositive() { 
    int result = HashUtilities.shortHash(1000);
    assertTrue(result > 0 && result < 1000);
  }
}
