import java.math.*;

public class Calculator {
  void launch(int int1, int int2) {
  add(int1, int2);
  subtract(int1, int2);
  multiply(int1, int2);
  divide(int1, int2);
  modulus(int1, int2); 
  }

  void add(int int1, int int2) {
    int sum = int1 + int2;
    System.out.println(int1 + " + " + int2 + " = " + sum);
  }

  void modulus(int int1, int int2) {
    int remainder = int1 % int2;
    System.out.println(int1 + " % " + int2 + " = " + remainder);
  }

  void multiply(int int1, int int2) {
    int product = int1 * int2;
    System.out.println(int1 + " * " + int2 + " = " + product);
  }

  void divide(int int1, int int2) {
    double dividend = (double) int1;
    double divisor = (double) int2;
    double quotient = dividend / divisor;
    System.out.println(int1 + " / " + int2 + " = " + quotient);
  }

  void subtract(int int1, int int2) {
    int difference = int1 - int2;
    System.out.println(int1 + " - " + int2 + " = " + difference);
  }

  // subtract(int, int)
  // multiply(int, int)
  // divide(int, int)
  // modulus(int, int) 

  public static void main(String[] args) {
    Calculator calc = new Calculator();
    calc.launch(5, 3);
  }
}