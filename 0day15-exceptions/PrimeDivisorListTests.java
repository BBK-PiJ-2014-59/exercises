import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PrimeDivisorListTests { 
  private PrimeDivisorList pdl1;
  private Integer int5;
  private Integer int2;
  private Integer int3;

  @Before
  public void buildUp() { 
    pdl1 = new PrimeDivisorListImpl(); 
    int5 = 5;
    int2 = 2;
    int3 = 3;
  }

  @Test (expected = NullPointerException.class) 
  public void addNullNumber() { 
    System.out.println("TEST 1");
    pdl1.addInt(null); 
  }

  @Test (expected = IllegalArgumentException.class) 
  public void addNonPrimeNumber() { 
    System.out.println("TEST 1-1");
    pdl1.addInt(1); 
  }

  @Test
  public void addNonNullNumber() { 
    System.out.println("TEST 2");
    pdl1.addInt(int5); 
    assertTrue(pdl1.remove(int5)); 
  }

  @Test
  public void toString_oneInt() { 
    System.out.println("TEST 3");
    pdl1.addInt(int5); 
    pdl1.addInt(int3); 
    pdl1.addInt(int3); 
    assertTrue(pdl1.remove(int5)); 
    assertTrue(pdl1.remove(int3)); 
    String s = "[ " + int3 + " = " + int3 + " ]";
    assertEquals(s, pdl1.toString()); 
  }

  @Test
  public void toString_twoDifferentInt() { 
    System.out.println("TEST 4");
    pdl1.addInt(int2); 
    pdl1.addInt(int3); 
    pdl1.addInt(int3); 
    assertTrue(pdl1.remove(int3)); 
    String s = "[ " + int2 + " * " + int3 + " = " + int2*int3 + " ]";
    assertEquals(s, pdl1.toString()); 
  }

  @Test
  public void toString_twoTimesTwoDifferentInt() { 
    System.out.println("TEST 5");
    pdl1.addInt(int2); 
    pdl1.addInt(int2); 
    pdl1.addInt(int3); 
    pdl1.addInt(int3); 
    String s = "[ " + int2 + "^2 * " + int3 + "^2 = " + int2*int2*int3*int3 + " ]";
    assertEquals(s, pdl1.toString()); 
  }
}
