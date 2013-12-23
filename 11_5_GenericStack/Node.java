// generic Node for a singly-linked list

// public class Node<T> {
public class Node<T extends Number> {

  // prev, next, data
  private Node<T> nextNode; 
  private T data;

  // constructor (sets data)
  public Node(T data) {
    this.data = data;
    nextNode = null; 
  }  
  
  // getters
  public Node<T> getNextNode() { return nextNode; }
  public T getData() { return data; }

  // setters
  public void setNextNode(Node<T> n) { nextNode = n; }
  // public void setData(T t) { data = t; }
    
}
