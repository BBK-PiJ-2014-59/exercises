import java.util.ArrayList;
import java.util.List;

public class Test { 
  public static void main(String[] args) { 
    Test t = new Test();
    //System.out.print("Enter num: ");
    //t.launch(n);
    t.launch3a();
  }

  public void launch3a() { 
    int n = requestNum("Enter num of nums: ");
    int i = 0;
    while (i < n) { 
	    try { 
        requestNum("Enter num: ");
        ++i;
	    } catch (NumberFormatException ex) { 
        System.out.println("Try again");
	      //ex.printStackTrace();
	    }
    }
  }

  private int requestNum(String s) { 
	      System.out.print(s);
        return Integer.parseInt(System.console().readLine());
  }


  public void launch2() { 
		// Some code here
    List<Integer> list = new ArrayList<Integer>();
    int newElement = 5;
		try { 
		  // more code here
		  list.add(newElement);
		  // more code here
		} catch (NullPointerException ex) { 
		  ex.printStackTrace();
		} catch (Exception ex) {
		  ex.printStackTrace();
		}
  }

  public void launch(int userInput) { 

    List<Integer> intList = new ArrayList<Integer>();
    intList.add(1);
    intList.add(2);
    intList.add(3);
    intList.add(4);
    intList.add(5);
    intList.add(6);
    try { 

      intList.remove(0);
      System.out.println(intList.get(userInput));
      intList.remove(0);
      System.out.println(intList.get(userInput));
      intList.remove(0);
      System.out.println(intList.get(userInput));
      intList.remove(0);
      System.out.println(intList.get(userInput));
      intList.remove(0);
      System.out.println(intList.get(userInput));
      intList.remove(0);
      System.out.println(intList.get(userInput));
      intList.remove(0);
      System.out.println(intList.get(userInput));
    } catch (IndexOutOfBoundsException ex) { 
      ex.printStackTrace();
    }
  }


}
