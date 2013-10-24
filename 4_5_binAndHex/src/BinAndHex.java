// 5 Binary and hexadecimal (*)
// Write a program that takes a String. The string can be a decimal or a hexadecimal number (starting by “0x”).
// Your program must recognise the number as what it is and convert it to the other base. Use two methods for
// conversion as in the former exercise.

import java.math.*;
import java.util.*;

public class BinAndHex {

  void launch() {
    BinAndHex.Number n = this.new Number();
    n.getString();
    n.setHexness();
    n.runConversion();
    // System.out.println(n.convertedToDec); 
    // System.out.println(n.convertedToHex); 
  }
 
  class Number {
    boolean isHex;
    String entered;
    int convertedToDec;
    String convertedToHex;

    // Number(String str) {
    //  entered = str;
    // }
    
    Number setIsHex(boolean h) {
      isHex = h;
      return this;
    }

    int toDecimal() {

      int total = 0;
      String hdig;
      entered = entered.substring(2);
      char[] chars = entered.toCharArray(); 
      System.out.println(chars);
      int ddig = 0;
      for (int i = chars.length - 1, j = 0; i >= 0; --i, ++j) { 
        if (Character.isDigit(chars[i])) {
          ddig = Character.getNumericValue(chars[i]); 
          System.out.println(ddig);
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
        }  
        total += ddig * Math.pow(16, j);
      }
      return total;
    }
    

    String toHex() {

      List<Character> hexCharList = new ArrayList<Character>();
      hexCharList.add('0');
      hexCharList.add('x');
      int top = Integer.parseInt(entered);
      int bottom, remainder, last, quotient; 
      bottom = remainder = last = quotient = 1; 
      while (top >= bottom) {
          last = bottom;
          bottom *= 16;
      } 
      if (bottom > top) {
        bottom = last;
      }
      // 2ab = 11 + 160 + 512 = 683 
      // 683 / 256 = 2 r 171
      // 171 /  16 = a r   b 
      //   b /   1 = b r   0

      while (bottom >= 1) {
        // System.out.println(top);
        // System.out.println(bottom);
	      quotient = top / bottom; 
        // System.out.println(quotient);
	      remainder = top % bottom;
	      top = remainder;
	      bottom /= 16;
	
	      char hexchar = 'P';
	
        hexchar = toHexChar(quotient);
        System.out.println("yoda " + hexchar);
	      hexCharList.add(hexchar);
	    }

      System.out.println("yoda " + hexCharList);
      // Character[] hexCharArr = new Character[hexCharList.size()];      
      // String ret = hexCharArr.toString();

      StringBuilder sb = new StringBuilder(hexCharList.size());
      for(Character c: hexCharList) {
        sb.append(c);
      }
      return sb.toString();
    }
    
    char toHexChar(Integer q)  {
        char hexchar = 'P';
	      if (q < 10) {
          String qstr = q.toString();
          qstr = qstr.substring(0);
          char[] tmpchars;
	        tmpchars = qstr.toCharArray();
          hexchar = tmpchars[0];
	      } else {
	          switch (q) {
	            case 10:
	              hexchar = 'a';
	              break;
	            case 11:
	              hexchar = 'b';
	              break;
	            case 12:
	              hexchar = 'c';
	              break;
	            case 13:
	              hexchar = 'd';
	              break;
	            case 14:
	              hexchar = 'e';
	              break;
	            case 15:
	              hexchar = 'f';
	              break;
	          }
        }
        return hexchar;
    }

    void setHexness() {
      boolean b = this.entered.startsWith("0x")? true : false;
      this.setIsHex(b);
    } 

	  void runConversion() {
	    if (this.isHex) {
	      System.out.println(this.toDecimal());  
	    } else {
	      System.out.println(this.toHex());  
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
