// 10 Palindrome redux (*)
// A strict palindrome is difficult to see in every day language. A relaxed 
// palindrome, a text that is a palindrome if you ignore punctuation marks such 
// as commas or spaces, is easier to see. Examples include “A man, a plan, a 
// canal - Panama!”, “Was it a car or a cat I saw?”, and “Rise to vote, sir”.
// Write a program that reads a text from the user and then says whether the 
// text is a relaxed palindrome. Note that all strict palindromes are relaxed 
// palindromes by definition. Hint: There are two methods that will make your 
// life easier. The first one is Character.isLetter(), that accepts a character 
// (not a String, even of length one) and returns true if the character is a 
// letter (e.g. ’a’, ’R’) and false otherwise (e.g. ’.’, ’5’). The second one is 
// Character.toLowerCase(), that accepts a character (not a String) and returns 
// the lower case version of the character.

public class PalindromeRedux {
    public static void main(String[] args) {
        Text text = new Text();
        text.getFromUser();
        text.showResult();
    }
}