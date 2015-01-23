import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PrimeDivisorListTests { 
  private PrimeDivisorList pdl1;
  private Integer int1;
  private Integer int2;
  private Integer int3;

  @Before
  public void buildUp() { 
    pdl1 = new PrimeDivisorListImpl(); 
    int1 = 1;
    int2 = 2;
    int3 = 3;
  }

  @Test (expected = NullPointerException.class) 
  public void addNullNumber() { 
    System.out.println("TEST 1");
    pdl1.addInt(null); 
  }

  @Test
  public void addNonNullNumber() { 
    System.out.println("TEST 2");
    pdl1.addInt(int1); 
    assertEquals(int1, pdl1.removeLast()); 
  }
}
