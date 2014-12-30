public class ArrayStringStack implements StringStack { 

  private int size;
  private int top;
  private String[] stringArray;

  public ArrayStringStack() { 
    size = 2;
    top = 0;
    stringArray = new String[size];
  }

  public boolean isEmpty() { 
    return top == 0 ? true : false;
  }
  public String peek() { 
    return stringArray[top];
  }
  public String pop() { 
    return stringArray[top--];
  }
  public void push(String newText) { 
    if (top >= size - 1) { 
      size = 2 * size;
      String[] tmpArray = new String[size];
      System.arraycopy(stringArray, 0, tmpArray, 0, stringArray.length);
      stringArray = tmpArray;
    } else { 
      stringArray[++top] = newText;
    }
  }



}
