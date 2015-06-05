import java.util.List;
import java.util.ArrayList;

/** Mergesort is a popular sorting algorithm that employs a divide-and-conquer strategy. 
  * You can implement a Merge- sort for lists by following the following steps:
  * Subproblem: If the list contains 0 or 1 element, it is sorted and you can return it. 
  * If not, then divide the list into two lists of the same length (± 1). Then sort the lists (i.e. apply mergesort to each sublist).
  */
public class MergeSort { 
  public static List<Integer> sort(List<Integer> list) { 
    List<Integer> result = null;
    if (list.size() <= 1)
      result = new ArrayList<Integer>(list);
    return list;
  }

  public static void main(String[] args) { 

    // test 0: []
    List<Integer> list0 = new ArrayList<Integer>();
    System.out.println("test 0: [] ... " + sort(list0));
    // test 1: [1]
    List<Integer> list1 = new ArrayList<Integer>();
    list1.add(1);
    System.out.println("test 1: [1] ... " + sort(list1));
  }
}
