// Write a program that asks the user for the total amount borrowed for a 
// mortgage, the number of years to pay it back, and the interest rate (in 
// this exercise, we assume it is a fixed rate). The program can then calculate 
// how much must be paid at the end
// t = c * ((1+r) / 100 )
// where t is the total, c is the cost, and r is the rate as a percentage. 
// * The program should print:
// * The total amount to be paid
// * The money to be paid every year
// * The number of years before the interest is paid and only the initial capital remains

// Write a method to calculate each piece of data.

public class MortgageCalc {
      Double amountBorrowed;
      Double yearsToPayBack;
      Double interestRate;
      
      public void setAmountBorrowed(Double a) {
          amountBorrowed = a;
      }
      
      public void setYearsToPayBack(Double y) {
          yearsToPayBack = y;
      }
      
      public void setInterestRate(Double r) {
          interestRate = r;
      }
      
      public void printSummary() {
          System.out.println("Total to be paid: " + totalPaid());
          System.out.println("Total to be paid each year: " + totalPaidEachYear());
          System.out.println("Interest paid off after this many years: " + interestFinished());
      }
      
      Double totalPaid() {
          // t = c * ((1+r) / 100 )
          return amountBorrowed * ( (1.0 + interestRate) /  100.0 );
      }
      
      Double totalPaidEachYear() {
          return totalPaid() / yearsToPayBack;
      }
      
      Double interestFinished() {
          return (interestRate * totalPaid()) / totalPaidEachYear();
      }
      
    public static void main(String[] args) {
        MortgageCalc calc = new MortgageCalc();
        System.out.println("Enter amount borrowed: ");
        calc.setAmountBorrowed(Double.parseDouble(System.console().readLine()));
        System.out.println("Enter number of years to pay it back: ");
        calc.setYearsToPayBack(Double.parseDouble(System.console().readLine()));
        System.out.println("Enter interest rate: ");
        calc.setInterestRate(Double.parseDouble(System.console().readLine()));
        calc.printSummary();
    }
}
