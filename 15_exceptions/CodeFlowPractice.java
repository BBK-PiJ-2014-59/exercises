import java.util.*;

public class CodeFlowPractice {

  public static void main(String[] args) {
    System.out.print("Enter num: ");
    int n = Integer.parseInt(System.console().readLine());
    CodeFlowPractice cfp = new CodeFlowPractice();
    cfp.launch(n); 
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
