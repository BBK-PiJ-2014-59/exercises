public class ListScript {
  
  public static void main(String[] args) {
    ListScript script = new ListScript();
    script.launch();
  }

  public void launch() {
    List<Integer> integerList = new List<Integer>(); 
    integerList.addNode(100);
    integerList.addNode(200);
    integerList.addNode(300);
    integerList.printList();
    integerList.deleteNode(300);
    integerList.addNode(100);
    integerList.addNode(100);
    integerList.printList();
    integerList.deleteNode(100);
    integerList.printList();
    integerList.deleteNode(200);
    integerList.printList();
    integerList.deleteNode(100);
    integerList.printList();
    integerList.deleteNode(100);
    integerList.printList();
  }
}
