import org.junit.*;
import static org.junit.Assert.*;

public class PrimeDivisorListTests {

  PrimeDivisorList pdl;

  @Before 
  public void before() {
    pdl = new PrimeDivisorListImpl();
  }

  @Test (expected=NullPointerException.class)
  public void test_add_null() {
  System.out.println("TEST-1");
    pdl.add(null);
  }

  @Test (expected=IllegalArgumentException.class)
  public void test_add_1() {
  System.out.println("TEST-2");
    pdl.add(1);
  }

  @Test
  public void test_add_2() {
  System.out.println("TEST-3");
    assertTrue(pdl.add(2));
  }

  @Test
  public void test_add_3_5() {
  System.out.println("TEST-4");
    assertTrue(pdl.add(3));
    assertTrue(pdl.add(5));
  }

  @Test (expected=IllegalArgumentException.class)
  public void test_add_4() {
  System.out.println("TEST-5");
    pdl.add(4);
  }

  @Test 
  public void test_toString_2() {
  System.out.println("TEST-6");
    pdl.add(2);
    assertEquals("[ 2 ]", pdl.toString());
  }

  @Test 
  public void test_toString_2_3_7() {
  System.out.println("TEST-7");
    pdl.add(2);
    pdl.add(3);
    pdl.add(7);
    assertEquals("[ 2 * 3 * 7 ]", pdl.toString());
  }

  @Test 
  public void test_toString_2_2() {
  System.out.println("TEST-8");
    pdl.add(2);
    pdl.add(2);
    assertEquals("[ 2^2 ]", pdl.toString());
  }

  @Test 
  public void test_toString_2_2_3_3() {
  System.out.println("TEST-9");
    pdl.add(2);
    pdl.add(2);
    pdl.add(3);
    pdl.add(3);
    assertEquals("[ 2^2 * 3^2 ]", pdl.toString());
  }

  @Test 
  public void test_toString_2_2_3_3_5_5() {
  System.out.println("TEST-10");
    pdl.add(2);
    pdl.add(2);
    pdl.add(3);
    pdl.add(3);
    pdl.add(5);
    pdl.add(5);
    assertEquals("[ 2^2 * 3^2 * 5^2 ]", pdl.toString());
  }

  @Test 
  public void test_toString_7_7_7_2_5_5_3() {
  System.out.println("TEST-11");
    pdl.add(7);
    pdl.add(7);
    pdl.add(7);
    pdl.add(2);
    pdl.add(5);
    pdl.add(5);
    pdl.add(3);
    assertEquals("[ 2 * 3 * 5^2 * 7^3 ]", pdl.toString());
  }

}
