// 9 From array to list 
// Create a static method that takes an array of integers and returns a linked list of integers in the same order as the original array. You can put this method in a class called ListUtilities so that you can easily use it for the following exercises.  Initialising an array with 15-20 elements is very easy with curly-brackets-notation, so it is common to create an array and then convert it into a dynamic structure automatically.

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
  }

  public void launch() {
    int[] a = { 1, 2, 3, 4 };
    Node listStart = arrayToList(a);
    traverse(listStart);
  }


  public static void main(String[] args) {
    ListUtilities lu = new ListUtilities();
    lu.launch();  
  }
}
