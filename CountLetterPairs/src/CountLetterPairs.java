// 6 Counting pairs of letters (*)
// Write a program that reads a short string and then some longer text. 
// The program must say how many times you
// can find the short string in the text. 
// You cannot use any method of String apart from charAt() and length().

public class CountLetterPairs {
    public static void main(String[] args) {
        System.out.println("Enter long string: ");
        String searchthis = System.console().readLine();
        System.out.println("Enter short string: ");
        String findthis = System.console().readLine();
        Text text = new Text(searchthis);
        int timesfound = text.find(findthis);
        System.out.println("Time found: " + timesfound);
    }
}