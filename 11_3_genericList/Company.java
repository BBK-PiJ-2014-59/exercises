/*
Generic list
Modify the doubly-linked list that you have created in past weeks to make it generic, i.e. to allow it to have values of its elements of any type. Use the TDD methodology (interface, test, production code, repeat. . . ).  Once you have it ready, create a class Company that keeps two linked lists, one with the names of the employees and one with their National Insurance Number.  
*/

public class Company {
  // List<EmployeeName> ... be nice to do it this way
  private List<String> employeeNames;
  private List<Integer> natInsNums;

  public Company() {
    employeeNames = new List<String>(); 
    natInsNums = new List<Integer>();
  }

  public static void main(String[] args) {
    Company co = new Company();
    co.launch();
  }

  public void launch() {
    employeeNames.addNode("Jesse"); 
    natInsNums.addNode(1);
    employeeNames.addNode("Sara"); 
    natInsNums.addNode(2);
    employeeNames.printList();
    natInsNums.printList();
    employeeNames.deleteNode("Sara");
    natInsNums.deleteNode(2);
    employeeNames.printList();
    natInsNums.printList();
    employeeNames.deleteNode("Jesse");
    natInsNums.deleteNode(1);
    employeeNames.printList();
    natInsNums.printList();
    natInsNums.deleteNode(1);
    employeeNames.printList();
    natInsNums.printList();
  }
}
