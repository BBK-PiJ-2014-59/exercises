public class StackScript {

  public static void main(String[] args) {
    StackScript ss = new StackScript();
    ss.launch();
  }

  public void launch() {
    //Stack<Integer> stack = new SinglyLinkedListStack<Integer>();
    SinglyLinkedListStack<Integer> stack = new SinglyLinkedListStack<Integer>();
    stack.push(5);
    stack.push(4);
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }
   
}
