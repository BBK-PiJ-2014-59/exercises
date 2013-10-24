// 5 Binary and hexadecimal (*)
// Write a program that takes a String. The string can be a decimal or a hexadecimal number (starting by “0x”).
// Your program must recognise the number as what it is and convert it to the other base. Use two methods for
// conversion as in the former exercise.

import java.math.*;

public class BinAndHex {

  void launch() {
    BinAndHex.Number n = this.new Number(System.console().readLine());
    n.getString();
    n.setHexness();
    n.runConversion();
  }
 
  class Number {
    boolean isHex;
    String entered;
    int convertedToDec;

    Number(String str) {
      entered = str;
    }
    
    Number setIsHex(boolean h) {
      isHex = h;
      return this;
    }

    int toDecimal() {
      // 2ab = 11 + 160 + 512 = 683 
      // 683 / 256 = 2 r 171
      // 171 /  16 = a r   b 
      //   b /   1 = b r   0

      int total = 0;
      String hdig;
      entered = entered.substring(2);
      char[] chars = entered.toCharArray(); 
      int ddig = 0;
      for (int i = chars.length - 1, j = 0; i >= 0; --i, ++j) { 
        if (Character.isDigit(chars[i])) {
          ddig = Character.valueOf(chars[i]); 
        } else {
          switch (chars[i]) {
            case 'a':
              ddig = 10;
              break;
            case 'b':
              ddig = 11;
              break;
            case 'c':
              ddig = 12;
              break;
            case 'd':
              ddig = 13;
              break;
            case 'e':
              ddig = 14;
              break;
            case 'f':
              ddig = 15;
              break;
          }      
          total += ddig * Math.pow(16, j);
        }  
      }
      return total;
    }
    

    void toHex() {

    }
        
    void setHexness() {
      boolean b = this.entered.startsWith("0x")? true : false;
      this.setIsHex(b);
    } 

	  void runConversion() {
	    if (this.isHex) {
	      this.convertedToDec = this.toDecimal();  
	    } else {
	      // num.convertedToDec = num.toHex();
	    }  
	  } 

    void getString() {
      System.out.println("Enter a hex or decimal number: ");
      // BinAndHex.Number n = this.new Number(System.console().readLine());
      entered = System.console().readLine();
    }
	}




  public static void main(String[] args) {
    BinAndHex session = new BinAndHex();
    // BinAndHex.Number n = session.new Number(System.console().readLine());
    session.launch();
  }  
}
