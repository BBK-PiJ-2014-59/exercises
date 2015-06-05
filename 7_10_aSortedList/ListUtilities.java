// 10 A sorted list
// Create a linked list of integers that is automatically sorted.
// Everytime you add an element, make sure you introduce it at the right place in the queue so that the queue is
// always sorted from lower to higher numbers.
// Create the list, insert several numbers into it (around 15 is fine) and then go through the list printing the value
// of each element. Check that the elements are correctly sorted.

public class ListUtilities {

  public static Node arrayToList(int[] a) {
    Node first = new Node(a[0]); 
    for (int i = 1; i < a.length; ++i) 
      first.addNode(new Node(a[i])); 
    return first;
  }

  public void traverse(Node n) {
    do {
      System.out.println(n.getData());
      n = n.getNext(); 
    } while (n != null);
    System.out.println();
  }

  public void insertInOrder(Node n, Node start) {
    Node temp = start;
    do { 
      if (n.getData() <= temp.getNext().getData()) {
        n.setNext(temp.getNext()); 
        temp.setNext(n);
        return;
      } else {
        temp = temp.getNext();
      }
    } while (temp.getNext() != null);
    temp.setNext(n); 
  }

  public void launch() {
    int[] a = { 1, 20, 30, 40 };
    Node listStart = arrayToList(a);
    traverse(listStart);
    insertInOrder(new Node(200), listStart);
    insertInOrder(new Node(250), listStart);
    insertInOrder(new Node(25), listStart);
    traverse(listStart);
  }

  public static void main(String[] args) {
    ListUtilities lu = new ListUtilities();
    lu.launch();  
  }
}
