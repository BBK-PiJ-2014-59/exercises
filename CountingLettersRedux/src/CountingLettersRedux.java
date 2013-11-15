// 7 Counting letters redux (*)
// Write a program that reads a text from the user and then enter a loop of 
// requesting letters and counting them.
// The program stops if the user asks for the same letter twice. //
// This is an example of the output of such a program
// (with a rather short and boring text):
// Please write a text: It was a dark and stormy night
// Which letter would you like to count now? a
// There are 6 in your text.
// Which letter would you like to count now? s
// There are 3 in your text.
// Which letter would you like to count now? u
// There are 0 in your text.
// Which letter would you like to count now? a
// Repeated character. Exiting the program...
// Thank you for your cooperation. Good bye!

public class CountingLettersRedux {
    public static void main(String[] args) {
        boolean repeated = false;
        Text text = new Text();
        text.getTextFromUser();
        Letters lettersUsed = new Letters();
        while (true) {
            text.getLetterFromUser();
            lettersUsed.addLetterIfUnusedElseExit(text.getLetter());
            text.showResult();
        }
    }
}