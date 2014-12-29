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
    return null;
  }
  public String pop() { 
    return stringArray[top--];
  }
  public void push(String newText) { 
    stringArray[++top] = newText;
  }



}
