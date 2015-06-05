/*
5 Generic stack
Create a generic stack (with methods for pushing, poping, and checking emptiness) that only works with classes that extend Number (e.g. Integer and Double, but not String). Use the TDD methodology (interface, test, production code, repeat. . . ).

Plan:

public interface Stack<N extends Number>
public class SinglyLinkedListStack<T> implements Stack<T> 
public class SinglyLinkedList<T> implements List<T> 
public interface List<T>
public class Node<T>

*/
public interface Stack<N extends Number> {
  public void push(N number);
  public N pop();
  public boolean isEmpty();
}
