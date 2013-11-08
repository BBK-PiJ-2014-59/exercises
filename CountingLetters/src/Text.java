public class Text {
    
    String str;
    char[] chars;
    int numE = 0;
    
    public void getFromUser() {
        System.out.println("Enter a sentence: ");
        str = System.console().readLine();
        str = str.toLowerCase();
        chars = str.toCharArray();
        // str.replaceAll("\\s+"," ");
    }
    
    public void countLetterE () {
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] == 'e') {
                ++numE;
            }
        }
        System.out.println("Number of letter \'e\': " + numE);
    }
    
    public String getLetterFromUser() {
        System.out.println("Enter a letter: ");
        String letter = System.console().readLine();
        letter = letter.toLowerCase();
        return letter;
    } 
    
    public void countLetterFromUser(String let) {
        int numlet = 0;
        char[] ch = let.substring(0,1).toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] == ch[0]) {
                ++numlet;
            }
        }
        System.out.println("Number of letter \'" + ch[0] + "\': " + numlet);
    }
    
}