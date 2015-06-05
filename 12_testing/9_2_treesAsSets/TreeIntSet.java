/**
2.2
Implementation as tree
Create a class TreeIntSet that implements this interface based on a tree structure.

2.3
Implementation as list
Create a class ListIntSet that implements this interface based on a linked list structure
*/

public class TreeIntSet implements IntSet {
  int value;
  TreeIntSet left;
  TreeIntSet right;

  public TreeIntSet(int value) {
    this.value = value;
  }

  /**
  * adds a new int to the set; if it is there already, nothing happens.
  */

  public void add(int n) {
    if (!this.contains(n)) {
      addOverwrite(n);
    } 
  } 

  public void addOverwrite(int newNumber) {
    if (newNumber > this.value) {
      if (right == null) {
        right = new TreeIntSet(newNumber);
      } else {
        right.add(newNumber);
      }
    } else {
      if (left == null) {
        left = new TreeIntSet(newNumber);
      } else {
        left.add(newNumber);
      }
    }
  }

  public boolean containsVerbose(int n) {
    System.out.println("contains: " + contains(n));
    System.out.println(this.value);
    if (n == this.value) {
      return true;
    } else if (n > this.value) {
      if (right == null) {
        return false;
      } else {
        return right.containsVerbose(n);
      }
    } else {
      if (left == null) {
        return false;
      } else {
        return left.containsVerbose(n);
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

  public String toString2() {
  // eg [6 L[5 L[3 L[] R[]] R[]] R[9 L[] R[]]]
  // eg [6 L[5 L[3 L[] R[]] R[]] R[9 L[8 L[] R[]] R[11 L[] R[12 L[] R[]]]]]
  // implement preorder traversal
    if (this != null) {
      System.out.print(value + ",");
      if (left != null) {
        left.toString2();
      } 
      if (right != null) {
        right.toString2();
      } 
    }
    return null; // SMELL
  }

}
