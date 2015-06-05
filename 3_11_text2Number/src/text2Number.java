// 11 Text2number
// Write a program that reads a number with commas and decimal dots (such as 
// “23,419.34”) and then prints a number that is half of it. Do not use 
// Double.parseDouble(). If you were writing a simple spreadsheet, you could use 
// this code to parse the input in the cells.

public class text2Number {
    public static void main(String[] args) {
        Text text = new Text();
        text.getFromUser();
        text.showResult();
    }
}