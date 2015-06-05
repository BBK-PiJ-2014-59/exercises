/**
  * reads 10 numbers from the user and then prints the mean average. 
  * If the user inputs something that is not a number, 
  * the program should complain and ask for a number again until 10 numbers have
  * been introduced.
  */
public class Average {
  
  static final int numNums = 10;

  public double getNums() {
    int i = 1; 
    int total = 0; 
    while (i <= numNums) {
      System.out.print("Enter integer " + i + ": ");      
      try {
        total += Integer.parseInt(System.console().readLine());
        ++i;
      } catch (NumberFormatException ex) {
        System.out.println("That wasn't an integer.");
      }
    }
    return ((double)total / numNums); 
  }

  public static void main(String[] args) {
    Average av = new Average();
    System.out.println(av.getNums());
  }

}
