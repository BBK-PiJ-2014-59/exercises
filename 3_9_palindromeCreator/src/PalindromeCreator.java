// 9 Palindrome creator
// Write a program that reads a text and then writes on the screen a palindrome 
// by writing the same text followed by the same text in reversed order. 
// For example, if the user enters the text “It was a dark and stormy night” the
// program must output “It was a dark and stormy nightthgin ymrots dna krad a saw tI”.

public class PalindromeCreator {
    public static void main(String[] args) {
        Text text = new Text();
        System.out.println("Enter some text and hit return: ");
        String str = System.console().readLine();
        text.getFromUser(str);
        text.showResult();
    }
}