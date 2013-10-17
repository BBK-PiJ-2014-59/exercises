
public class Text {
    // constructor method p143
    
    String longstr;
    
    public Text(String searchthis) {
        longstr = searchthis;
    }
    
    public int find(String findthis) {        
        // foo in ffoobarfoof = 3, 11 long
        // ffo foo oob oba bar arf rfo foo oof = 9, 2 match
        
        int match = 0;
        boolean matchc = false;
        System.out.println(longstr.length());
        System.out.println(findthis.length());

        for (int i=0; i < ((longstr.length() - findthis.length()) + 1); ++i) {
            System.out.println("i: " + i);
            for (int j=0; j < findthis.length(); ++j) {
                matchc = false;
                if(longstr.charAt(i+j) != findthis.charAt(j)) {
                    System.out.println("no char match: " + longstr.charAt(i+j) + findthis.charAt(j));
                    break;
                }
                else {
                    matchc = true;
                    System.out.println("matchc: " + longstr.charAt(i+j) + findthis.charAt(j));
                }
            }
            if (matchc == true) {
                ++match;
                matchc = false;
                System.out.println("++match = " + match);
            }
        }
        return match;
    }
}