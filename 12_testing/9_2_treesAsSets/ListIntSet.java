/**
2.3
Implementation as list
Create a class ListIntSet that implements this interface based on a linked list structure
*/

public class ListIntSet implements IntSet {
  int value;
  ListIntSet next;
  private static boolean verbose = false; 

  public ListIntSet(int value) {
    this.value = value;
  }

  /**
  * adds a new int to the set; if it is there already, nothing happens.
  */

  public void add(int n) {
    if (!this.contains(n)) {
      ListIntSet newMember = new ListIntSet(n);
      addOverwrite(newMember);
    } 
  } 

  public void addOverwrite(ListIntSet newMember) {
    if (this.next == null) {
      this.next = newMember;
    } else {
      this.next.addOverwrite(newMember);
    }
  }


  public boolean containsVerbose(int n) {
    verbose = true;
    boolean ret = contains(n);
    verbose = false;
    return ret; 
  }

  public boolean contains(int n) {
    if (verbose)
      System.out.println(value);
    if (n == this.value) {
      return true;
    } else if (this.next != null) { 
      return this.next.contains(n);
    } else {
      return false;
    }
  }

  public void toString2() {
    System.out.print(value + ",");
    if (next != null) {
      next.toString2();
    }
  }

}
