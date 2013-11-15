import java.math.*;
import java.util.*;

public class BinaryAndDecimal {
    
    public void launch() {
        // printMenu();
        // getSelectionFromUser();
        // runSelectedConversion();
        System.out.println(binary2decimal("100111"));
        System.out.println(decimal2binary("39"));

    }
    
    void printMenu() {
        
    }
    
    void getSelectionFromUser() {
        
    }
    
    void runSelectedConversion() {
        
    }
    
    int binary2decimal(String b) {
        // 100111 
        // (1 * 2^0) + (1 * 2^1) + (1 * 2^2) + (0 * 2^3) + (0 * 2^4) + (1 * 2^5)
        // 1 + 2 + 4 + 32 = 39
        char[] chars = b.toCharArray();
        int multiplier;
        int total = 0;
        for (int i = chars.length - 1, power = 0; i >= 0; --i, ++power) {
            multiplier = (chars[i] == '1')? 1 : 0;
            total += multiplier * (Math.pow(2,power));
        }
        return total;
    }
    
    // String decimal2binary (String d) {
    List<Character> decimal2binary (String d) {

        char[] chars = d.toCharArray();
        // 39 / 2 = 19 r 1
        // 19 / 2 =  9 r 1
        //  9 / 2 =  4 r 1
        //  4 / 2 =  2 r 0
        //  2 / 2 =  1 r 0
        //  1 / 2 =  0 r 1
        
        int dividend = 0, divisor = 0, remainder = 0;
        dividend = Integer.parseInt(d);
        int quotient = dividend;
        String remainderString = "";
        char[] remainderChar;
        List<Character> backwards = new ArrayList<Character>();
        String forwardString = "";
        while (dividend >= 1) {
            divisor = dividend / 2;
            remainder = dividend % 2;
            remainderString = Integer.toString(remainder);
            remainderChar = remainderString.toCharArray();
            backwards.add(remainderChar[0]);
            dividend = divisor;
        }
            System.out.println("yoda " + backwards.size());
        
        List<Character> forwards = new ArrayList<Character>(); 
        for (int i = backwards.size() - 1; i >= 0; --i) {
            forwards.add(backwards.get(i));
            // forwardString = forwards.toString();
        }
        
        // return forwardString;
        return forwards;
    }
    
    public static void main(String[] args) {
        BinaryAndDecimal session = new BinaryAndDecimal();
        session.launch();
    }
}