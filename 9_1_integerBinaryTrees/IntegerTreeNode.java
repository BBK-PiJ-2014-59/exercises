/** 1.1 First steps: add and seek. Complete the class IntegerTreeNode.  From the notes, you already know what the member fields are and you have seen a possible implementation of methods add(int) and contains(int). 

Implement as well two methods getMax() and getMin() that returns the maximum and the minimum values stored in the tree.  Compile the class and use it inside a script1 adding numbers in different orderings. 1 In Java, a script is a class that only contains a main() method, maybe a launch() method, and no member fields.  */

public class IntegerTreeNode {
  int value;
  IntegerTreeNode left;
  IntegerTreeNode right;

  public IntegerTreeNode(int value) {
    this.value = value;
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
