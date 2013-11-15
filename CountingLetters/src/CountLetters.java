// 5 Counting letters
// Write a program that reads some text from the user and then says 
// how many letters ’e’ are there in that text.
// Then modify the program so that it reads the text from the user and 
// then asks for a letter. The program should then say how many times you 
// can find the letter in the text.

public class CountLetters {
    public static void main(String[] args) {
        Text text = new Text();
        text.getFromUser();
        text.countLetterE();        
        String str = text.getLetterFromUser();
        text.countLetterFromUser(str);
    }
}