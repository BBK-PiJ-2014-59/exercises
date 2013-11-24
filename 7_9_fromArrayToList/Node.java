public class Node {
  private int data;
  private Node nextNode;

  public Node(int d) { data = d; } 
  public Node getNext() { return nextNode; }
  public void setNext(Node n) { nextNode = n; }
  public int getData() { return data; }

  public void addNode(Node n) {
    if (this.nextNode == null) {
      this.nextNode = n;
    } else {
      this.nextNode.addNode(n);
    }
  }
}
