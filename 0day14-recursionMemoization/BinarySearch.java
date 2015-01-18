import java.util.List;
import java.util.ArrayList;

/** 4 Binary search
  * The most basic example of divide-and-conquer strategies is the binary search. This is used to look for an element in a sorted list.  We can find an element in a list by traversing through the whole list and checking whether each element is the one we are looking for. The number of comparisons that we need by using this algorithm is proportional to the length of the list. If we know that the list is sorted, we can do better with a divide-and-conquer strategy, like the one defined by repeating these steps: 
  * Initial action: If the list is empty, it does not contain the element and we have finished.
  * If it is not empty, check the middle element, i.e. the element at list.size()/2. If it is the element we are looking for, we have finished.
  * Subproblem: If the element we are looking for is before the middle element, the next list to search into is the first half of the original list; otherwise, it is the second half.  Integration: No need for integration in this case. Just repeat looking into half-lists until the sublist is only one element long At that point, either the element is the one we are looking for or the list does not contain it.
  */
public class BinarySearch { 
  public static boolean search(int n, List<Integer> list) { 
    boolean result = false;
    if (list.size() == 0) 
      result = false;
    else { 
      int midInd = list.size()/2;
      //System.out.println(midInd);
      int mid = list.get(midInd);
      //int mid = list.get(list.size()/2);
      if (n == mid)
        result = true;
      else if (n < mid)
        result = search(n, list.subList(0, midInd)); 
      else  
        result = search(n, list.subList(midInd+1, list.size())); 
    }
    return result;
  }
  public static void main(String[] args) { 
    int d1 = 1;

    // test 0: false
    List<Integer> list0 = new ArrayList<Integer>();
    //int d2 = 2;
    System.out.println("test 0: " + search(d1, list0));

    // test 1: true
    List<Integer> list1 = new ArrayList<Integer>();
    list1.add(1);
    System.out.println("test 1: " + search(d1, list1));

    // test 2: true
    List<Integer> list2 = new ArrayList<Integer>();
    list2.add(1);
    list2.add(2);
    list2.add(5);
    list2.add(6);
    list2.add(10);
    System.out.println("test 2: " + search(d1, list2));

    // test 3: false
    System.out.println("test 3: " + search(100, list2));

    // test 4: true
    System.out.println("test 3: " + search(5, list2));
  }
}

