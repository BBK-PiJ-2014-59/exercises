/** 1.1 First steps: add and seek. Complete the class IntegerTreeNode.  From the notes, you already know what the member fields are and you have seen a possible implementation of methods add(int) and contains(int). 

Implement as well two methods getMax() and getMin() that returns the maximum and the minimum values stored in the tree.  Compile the class and use it inside a script1 adding numbers in different orderings. 1 In Java, a script is a class that only contains a main() method, maybe a launch() method, and no member fields.  

1.2 Tree traversal Add a method toString() to the class. This methods must return a representation of your tree in String form, where every node is represented as a list in square brackets containing its value, the left branch, and the right branch; the left branch should be prefixed by “L” and the right branch by R, and an empty branch should be shown as an empty pair of square brackets. Some examples of outputs in Figure 1.  After you have commited this version of toString(), make another version that returns a simplified represen- tation, where every node is represented as a list in square brackets containing its value and its branches, but only if they are not empty; without using the “L” and “R” prefixes. Some examples of outputs in Figure 1.  Check that both versions of the method work by adding several elements and printing the String representation of the tree. 
eg 6 L[5 L[3 L[] R[]] R[]] R[9 L[8 L[] R[]] R[11 L[] R[12 L[] R[]]]]]
 
*/


public class IntegerTreeNode {
  int value;
  IntegerTreeNode left;
  IntegerTreeNode right;

  public IntegerTreeNode(int value) {
    this.value = value;
  }

  public void toString2() {
  // eg [6 L[5 L[3 L[] R[]] R[]] R[9 L[] R[]]]
  // eg [6 L[5 L[3 L[] R[]] R[]] R[9 L[8 L[] R[]] R[11 L[] R[12 L[] R[]]]]]
  // implement preorder traversal
    if (this != null) {
      System.out.print(value + " ");
      if (left !=null) {
        System.out.print("L[");
        left.toString2();
        System.out.print("] ");
      } else {
        System.out.print("L[] ");
      }
      if (right != null) {
        System.out.print("R[");
        right.toString2();
        System.out.print("] ");
      } else {
        System.out.print("R[] ");
      }
    }
  }

  public int getMax() {
    IntegerTreeNode temp = this;
    int max = temp.value;
    while (temp.right != null) {
      max = temp.right.value; 
      temp = temp.right;
    } 
    return max;
  }

  public int getMin() {
    IntegerTreeNode temp = this;
    int min = temp.value;
    while (temp.left != null) {
      min = temp.left.value; 
      temp = temp.left;
    } 
    return min;
  }

  public void add(int newNumber) {
    if (newNumber > this.value) {
      if (right == null) {
        right = new IntegerTreeNode(newNumber);
      } else {
        right.add(newNumber);
      }
    } else {
      if (left == null) {
        left = new IntegerTreeNode(newNumber);
      } else {
        left.add(newNumber);
      }
    }
  }
 
	public boolean contains(int n) {
	  if (n == this.value) {
	    return true;
	  } else if (n > this.value) {
	    if (right == null) {
	      return false;
	    } else {
	      return right.contains(n);
	    }
	  } else {
	    if (left == null) {
	      return false;
	    } else {
	      return left.contains(n);
	    }
	  }
	}
}
