public class LinkedList {

  public String getThird(Node list) {
    return list.getNext().getNext().getData();  
  }

  public void insertSecond(Node list, String s) {
    // * -> * -> *  
    //   -> *
    list.setNext(new Node(s, list.getNext()));
  }

  public int size(Node list) {
    int count = 0;
    while (list != null) {
      list = list.getNext();
      ++count;
    } 
    return count; 
  }

  public void addLast(Node list, String s) {
    // nodeA -> nodeB -> nodeC
    // list: null  
    while (list.getNext() != null) {
      list = list.getNext();
    }
    list.setNext(new Node(s, null));
    System.out.println(list.getNext().getData());
  }


  public void addLast2(Node list, String s) {
    Node prev = null;
    Node curr = list;
    while (curr != null) {
      prev = curr;
      curr = curr.getNext();
    }
    prev.setNext(null);
  }

  private void launch() {
    Node nodeA = new Node("a", new Node("b", new Node("c", null))); 
    // Node nodeA = null; 
    // System.out.println(nodeA.getNext().getNext().getData());
    // System.out.println(getThird(nodeA));
    // insertSecond(nodeA, "g");
    // System.out.println(nodeA.getNext().getData());
    System.out.println(size(nodeA));
    addLast(nodeA, "end?");
    addLast(nodeA, "the end!");
  }

  public static void main(String[] args) {
    LinkedList k = new LinkedList(); 
    k.launch();
  }
} 
