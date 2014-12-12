public class List<T> implements GenList<T> {
  
  // head
  private Node<T> headNode;

  // constructor: head is null
  public List() {
    headNode = null;
  }

  // addNode
  public void addNode(T data) {
    Node<T> newNode = new Node<T>(data);
    if (headNode == null) {
      headNode = newNode;
    } else {
      Node<T> curNode = headNode;
      while (curNode.getNextNode() != null) {
        curNode = curNode.getNextNode(); 
      }
      curNode.setNextNode(newNode); 
      newNode.setPreviousNode(curNode);
    }
  }  

  // printList
  public void printList() {
    if (headNode == null) {
      System.out.println("empty list");
    } else {
      Node<T> curNode = headNode;
      while (curNode != null) {
        System.out.println(curNode.getData());
        curNode = curNode.getNextNode();  
      }
    }
    System.out.println();
  }

  // deleteNode
  public boolean deleteNode(T data) {
    if (headNode == null) {
      return false;
    }

    Node<T> curNode = headNode;
    while (curNode != null) {
      if (curNode.getData().equals(data)) { // I'm it 
        if (curNode.getNextNode() != null && curNode.getPreviousNode() != null) { // I'm surrounded 
          curNode.getNextNode().setPreviousNode(curNode.getPreviousNode()); 
          curNode.getPreviousNode().setNextNode(curNode.getNextNode());
        } else if (curNode.getNextNode() == null && curNode.getPreviousNode() == null) { // I'm alone 
          headNode = null;
        } else if (curNode.getPreviousNode() != null) { // I'm last
          curNode.getPreviousNode().setNextNode(null);  
          curNode.setPreviousNode(null);
        } else if (curNode.getNextNode() != null) { // I'm first
          headNode = curNode.getNextNode();
          curNode.getNextNode().setPreviousNode(null);
          curNode.setNextNode(null);
        } 
        return true;  
      } else { // I'm not it 
        curNode = curNode.getNextNode(); 
      } 
    }
    return false;
  } 

}
