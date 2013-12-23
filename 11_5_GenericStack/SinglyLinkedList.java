//public class SinglyLinkedList<T> implements List<T> {
public class SinglyLinkedList<T> {
  Node<T> headNode;

  public SinglyLinkedList() {
    headNode = null;
  }

  public void putHead(T data) {
    Node<T> newNode = new Node<T>(data);
    if (headNode != null)
      newNode.setNextNode(headNode);
    headNode = newNode; 
  }

  public Node<T> getHead() {
    if (headNode != null) 
      return headNode;
    return null;
  }

  public boolean deleteHead() {
    if (headNode != null) {  // not none
      if (headNode.getNextNode() == null) {  // singleton 
        headNode = null;
      } else { // 2+
        Node<T> tmp = headNode;
        headNode = headNode.getNextNode();
        tmp = null;
      }
      return true;
    }
    return false;
  }

  public void printList() {
    Node<T> cur = headNode;
    while (cur != null) {
      System.out.println(cur.getData());
      cur = cur.getNextNode();
    }
  }

}
