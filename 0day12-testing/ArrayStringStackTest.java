import org.junit.*;
import static org.junit.Assert.*;

public class ArrayStringStackTest { 
  private StringStack myArrayStringStack;
  String myString;
  String myString2;

  @Before
  public void initObjects() { 
    myArrayStringStack = new ArrayStringStack();
    myString = "abc";
    myString2 = "def";
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
    assertEquals(myString, myArrayStringStack.pop());
  }

  @Test
  public void morePushesThanSizeDoesntThrow() { 
    myArrayStringStack.push(myString);
    myArrayStringStack.push(myString);
  }

  @Test
  public void morePushesThan2xSizeDoesntThrow() { 
    myArrayStringStack.push(myString);
    myArrayStringStack.push(myString);
    myArrayStringStack.push(myString);
    myArrayStringStack.push(myString);
  }

  @Test
  public void peekOnNewStackReturnsNull() { 
    assertNull(myArrayStringStack.peek());
  }

  @Test
  public void peekOnStackOf1ReturnsPushed() { 
    myArrayStringStack.push(myString);
    assertEquals(myString, myArrayStringStack.peek());
  }

  @Test
  public void peekReturnsLastPush() { 
    myArrayStringStack.push(myString2);
    myArrayStringStack.push(myString);
    assertEquals(myString, myArrayStringStack.peek());
  }

  @Test
  public void popReturnsInCorrectOrder() { 
    myArrayStringStack.push(myString2);
    myArrayStringStack.push(myString);
    assertEquals(myString, myArrayStringStack.pop());
  }
}
