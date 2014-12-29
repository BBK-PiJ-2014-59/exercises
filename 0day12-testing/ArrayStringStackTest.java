import org.junit.*;
import static org.junit.Assert.*;

public class ArrayStringStackTest { 
  private StringStack myArrayStringStack;
  String myString;

  @Before
  public void initObjects() { 
    myArrayStringStack = new ArrayStringStack();
    myString = "abc";
  }

  @Test
  public void isEmptyReturnsTrueForNewEmptyStack() { 
    assertTrue(myArrayStringStack.isEmpty());
  }

  @Test
  public void isEmptyReturnsFalseForStackOfOne() { 
    myArrayStringStack.push(myString);
    assertFalse(myArrayStringStack.isEmpty());
  }

  @Test
  public void isEmptyReturnsTrueForPoppedEmptyStack() { 
    myArrayStringStack.push(myString);
    myArrayStringStack.pop();
    assertTrue(myArrayStringStack.isEmpty());
  }

  @Test
  public void popReturnsCorrectString() { 
    myArrayStringStack.push(myString);
    myArrayStringStack.pop();
    assertEquals();

}
