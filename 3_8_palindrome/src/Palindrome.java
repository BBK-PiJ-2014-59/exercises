// 8 Palindrome
// A palindrome is a word, phrase, number, or other sequence of units that 
// may be read the same way in either
// direction. Examples of strict palindromes include “ABBA”, “madam”, “radar”, 
// “kayak”, and “step on no pets”.
// Write a program that reads a text and detects whether the text is a strict palindrome.

public class Palindrome {
    public static void main(String args[]) {
        Text text = new Text();
        text.getFromUser();
        text.showResult();
    }
}