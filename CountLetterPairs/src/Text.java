
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
        boolean matchc;
        for (int i=0; i < ((longstr.length() - findthis.length()) + 1); ++i) {
            matchc = false;
            for (int j=i; j < findthis.length(); ++j) {
                if(longstr.charAt(i+j) != findthis.charAt(j)) 
                    break;
                else 
                    matchc = true;
            if (matchc == true)
                ++match;
            }
        }
        return match;
    }
}