/**
  * reads 10 numbers from the user and then prints the mean average. 
  * If the user inputs something that is not a number, 
  * the program should complain and ask for a number again until 10 numbers have
  * been introduced.
  *
  * modification: asks how many numbers the user wants to enter, and then asks for the numbers.
  * The computer should complain if the user enters something that is not a number in both cases. 
  * Use methods to prevent code repetitions.
  */
public class Average2 {
  
  public int getNum(String prompt) {
    boolean valid = false;
    int result = 0;
    while (!valid) {
      try {
        System.out.print(prompt); 
        result = Integer.parseInt(System.console().readLine());
        valid = true;
      } catch (NumberFormatException ex) {
        System.out.println("That wasn't an integer."); 
      }
    }
    return result;
  } 

  public int getNumNums() {
    String prompt = "How many numbers do you want to enter: ";
    int numNums = getNum(prompt);
    return numNums;
  }
  

  public double getNums(int numNums) {
    int i = 1; 
    int total = 0; 

    while (i <= numNums) {
      total += getNum("Enter number " + i + ": ");
      i++;
    }

    return ((double)total / numNums); 
  }

  public static void main(String[] args) {
    Average2 av = new Average2();
    System.out.println("Average: " + av.getNums(av.getNumNums()));
  }

}
