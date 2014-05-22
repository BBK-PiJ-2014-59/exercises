import java.util.*;

public class PrimeDivisorListImpl implements PrimeDivisorList {

  List<Integer> li = new ArrayList<Integer>();

  public boolean add(Integer integer) throws NullPointerException {
    if (integer == null) {
      throw new NullPointerException();
    }
    if (!isPrime(integer)) {
      throw new IllegalArgumentException();
    }
    return li.add(integer);
  }

  private boolean isPrime(Integer integer) {
    boolean result = false;
    if (integer.intValue() == 1) {
      result = false;
    } else {
      int numDivisors = 1;
      for (int i=2; i < integer; i++) {
        numDivisors = (integer % i == 0) ? numDivisors + 1 : numDivisors; 
      }
      result = (numDivisors > 1) ? false : true;  
    }
    return result;
  }

  /**
    * remove Integer
    * @throws NullPointerException if passed null
    * @throws IllegalArgumentException if passed non-prime, non-Integer
    * or anything not in the list.
    */
  public void remove(Integer integer) {
  }

  /**
    * @returns String like [ 2 * 3^2 * 7 = 126 ] (for a list containing one 2, two 3, and one 7).  
    */
  @Override
  public String toString() {
    // return null;
    //String result = "[ " + li.get(0) + " * " + li.get(1) + " ]"; 
    String left = "[ ";
    String right = " ]";
    String middle = "";
    //for (Integer i : li) {

    int prev = -1;
    String curTerm = "";
    int numCur = 0;
    
    for (ListIterator<Integer> it = li.listIterator(); it.hasNext(); ) {
      System.out.println("LOOP");
      Integer cur = it.next();
      if (it.nextIndex() == 1 || cur == prev) { // 2 3 7
        ++numCur;
      } else {
        System.out.println("YODA numCur: " + numCur);
        curTerm = (numCur < 2) ? "" + prev : "" + prev + "^" + numCur;
        middle += curTerm;
        //if (it.hasNext()) {
          middle += " * "; 
        //}
        numCur = 1;
      }
      prev = cur;


      System.out.println("cur: " + cur);
      System.out.println("nextIndex: " + it.nextIndex());
      System.out.println("numCur: " + numCur);
      System.out.println("curTerm: " + curTerm);
    }
    curTerm = (numCur < 2) ? "" + prev : "" + prev + "^" + numCur;
    middle += curTerm;
  
    return left + middle + right;
  }

}
