import java.util.*;

public class Text {
    String str;
    double total = 0.0;
    
    public void getFromUser() {
        System.out.println("Enter a number: ");
        str = System.console().readLine();
    }
    
    public void showResult() {
        // List<Character> chars = new ArrayList<Character>();
        
        System.out.println(halfOf(str));
    }
    
    private double halfOf(String str) {
        
        int dp = this.str.indexOf(".");
        if (dp == -1) {
            dp = this.str.length();
        }
        double addthis = 0.0;
        // for (int i = dp - 1, j = 0; i >= 0; --i, ++j) {
        int i = dp - 1;
        int j = 0;
        char c;
        while (i >= 0) {
            c = this.str.charAt(i);
            if (Character.isDigit(c)) {
                System.out.println(c);
                addthis = Character.getNumericValue(c) * Math.pow(10.0, j);    
                System.out.println(addthis);
                total += addthis;
                --i;
                ++j;
            } else {
                continue;
            }
        }
        
        // for (int i = dp + 1, j = -1; i < this.str.length(); ++i, --j) {
        i = dp + 1;
        j = -1;
        while (i < this.str.length()) {
            c = this.str.charAt(i);
            if (Character.isDigit(c)) {
                System.out.println(c);
                addthis = Character.getNumericValue(c) * Math.pow(10.0, j);
                System.out.println(addthis);
                total += addthis;
                ++i;
                --j;
            } else {
                continue;
            }
        }
        
        return total / 2;
    }
    
}