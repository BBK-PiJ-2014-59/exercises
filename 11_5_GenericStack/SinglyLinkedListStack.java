// public class SinglyLinkedListStack<N> implements Stack<N> {
public class SinglyLinkedListStack<N> {

  private Node<N> topNode;
  private SinglyLinkedList<N> list;

  // contructor - sets topNode to null
  public SinglyLinkedListStack() {
    topNode = null;
    list = new SinglyLinkedList<N>();
  }

  // push
  public void push(N number) { 
    System.out.println("pushing...");
    list.putHead(number);
  }

  // pop 
  public N pop() {
    System.out.println("popping...");
    if (isEmpty()) {
      System.out.println("stack is empty");
      return null; 
    }
    Node<N> top = list.getHead();
    list.deleteHead(); 
    return top.getData(); 
  }

  // isEmpty
  public boolean isEmpty() {
    return list.getHead() == null ? true : false;
  }
}
