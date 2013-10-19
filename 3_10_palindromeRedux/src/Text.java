import java.util.*;

public class Text {
    
    String tocheck;
    
    
    public void getFromUser() {
        System.out.println("Enter some text: ");
        tocheck = System.console().readLine();
    }
    
    public void showResult() {
        if (isRelPal(tocheck)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
    
    private boolean isRelPal(String str) {
        boolean relpal = true;
        char[] chars = str.toCharArray();
        List<Character> letters = new ArrayList<Character>();
        for (int i = 0; i < chars.length; ++i) {
            if (Character.isLetter(chars[i])) {
                letters.add(Character.toLowerCase(chars[i]));
            }
        }        
        return isPal(letters) ? true : false;
    }
    
    private boolean isPal(List<Character> chs) {
        // abcdcba
        // 0123456
        // 0=6, 1=5, 2=4, 3
        // abccba
        // 012345
        // 0=5, 1=4, 2=3
        boolean ispal = true;
        for (int i = 0, j = chs.size() - 1; i <= j; ++i, --j) {
            if (chs.get(i) != chs.get(j)) {
                ispal = false;
                break;
            }
        }
        return ispal;
    }
    
}

