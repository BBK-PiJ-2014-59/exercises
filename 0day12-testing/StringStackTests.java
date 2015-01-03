import org.junit.*;
import static org.junit.Assert.*;

public class StringStackTests { 
  private StringStack myStringStack;
  String myString;
  String myString2;

  @Before
  public void initObjects() { 
    //myStringStack = new ArrayStringStack();
    myStringStack = new ListStringStack();
    myString = "abc";
    myString2 = "def";
  }

  @Test
  public void isEmptyReturnsTrueForNewEmptyStack() { 
    assertTrue(myStringStack.isEmpty());
  }

  @Test
  public void isEmptyReturnsFalseForStackOfOne() { 
    myStringStack.push(myString);
    assertFalse(myStringStack.isEmpty());
  }

  @Test
  public void isEmptyReturnsTrueForPoppedEmptyStack() { 
    myStringStack.push(myString);
    myStringStack.pop();
    assertTrue(myStringStack.isEmpty());
  }

  @Test
  public void popReturnsCorrectString() { 
    myStringStack.push(myString);
    assertEquals(myString, myStringStack.pop());
  }

  @Test
  public void morePushesThanSizeDoesntThrow() { 
    myStringStack.push(myString);
    myStringStack.push(myString);
  }

  @Test
  public void morePushesThan2xSizeDoesntThrow() { 
    myStringStack.push(myString);
    myStringStack.push(myString);
    myStringStack.push(myString);
    myStringStack.push(myString);
  }

  @Test
  public void peekOnNewStackReturnsNull() { 
    assertNull(myStringStack.peek());
  }

  @Test
  public void peekOnStackOf1ReturnsPushed() { 
    myStringStack.push(myString);
    assertEquals(myString, myStringStack.peek());
  }

  @Test
  public void peekReturnsLastPush() { 
    myStringStack.push(myString2);
    myStringStack.push(myString);
    assertEquals(myString, myStringStack.peek());
  }

  @Test
  public void popReturnsInCorrectOrder() { 
    myStringStack.push(myString2);
    myStringStack.push(myString);
    assertEquals(myString, myStringStack.pop());
    assertEquals(myString2, myStringStack.pop());
    assertTrue(myStringStack.isEmpty());
  }
}
