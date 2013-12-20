public class Node<T> {

  // prev, next, data
  private Node<T> previousNode; 
  private Node<T> nextNode; 
  private T data;

  // constructor (sets data)
  public Node(T data) {
    this.data = data;
    previousNode = null; 
    nextNode = null; 
  }  
  
  // getters
  public Node<T> getPreviousNode() { return previousNode; }
  public Node<T> getNextNode() { return nextNode; }
  public T getData() { return data; }

  // setters
  public void setPreviousNode(Node<T> n) { previousNode = n; }
  public void setNextNode(Node<T> n) { nextNode = n; }
  public void setData(T t) { data = t; }
    
}
