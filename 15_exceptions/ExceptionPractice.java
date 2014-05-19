import java.util.*;

public class ExceptionPractice {

public static void main(String[] args) {

	List<String> list; 
  list = null;
  //list = new ArrayList<String>();
	String newElement = "abc";
	
	try {
	  // more code here
	  list.add(newElement);
	  // more code here
	} catch (NullPointerException ex) {
    System.out.println("yoda");
	  ex.printStackTrace();
	} catch (Exception ex) {
	  ex.printStackTrace();
	}
	
}

}
