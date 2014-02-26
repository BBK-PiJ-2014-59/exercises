import org.junit.*;
import static org.junit.Assert.*;

public class StringStackTest {
  
  String str1 = "foo1";
  String str2 = "foo2";
  String str3 = "foo3";

  StringStack stack;

  @Before
  public void initialize() {
    stack = new PointerStringStack();
  }  

  @Test
  public void testsPushTwoOntoEmptyStackThenPopThem() {
    stack.push(str1);
    stack.push(str2);
    assertSame(str2, stack.pop()); 
    assertSame(str1, stack.pop()); 
    assertNull(stack.pop()); 
  }

  @Test
  public void testsPeekEmptyStack() {
    assertNull(stack.peek()); 
  }


  @Test
  public void testsPeekStackOfOne() {
    stack.push(str1);
    assertSame(str1, stack.peek()); 
    assertSame(str1, stack.pop()); 
  }

  @Test
  public void testsPeekStackOfMany() {
    stack.push(str1);
    stack.push(str2);
    assertSame(str2, stack.peek()); 
    assertSame(str2, stack.pop()); 
    assertSame(str1, stack.peek()); 
    assertSame(str1, stack.pop()); 
  }


  @Test
  public void testsIsEmptyEmptyStack() {
    assertTrue(stack.isEmpty()); 
  }


  @Test
  public void testsIsEmptyStackOfOne() {
    stack.push(str1);
    assertFalse(stack.isEmpty()); 
  }

} 
