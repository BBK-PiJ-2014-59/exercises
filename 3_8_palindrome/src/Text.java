public class Text {
    
    String tocheck;
    
    public void getFromUser() {
        System.out.println("Enter a string to check: ");
        tocheck = System.console().readLine();
        tocheck = tocheck.toLowerCase();
    }
    
    public void showResult() {
        boolean pal = false;
        pal = isPal(tocheck);
        if (pal) {
            System.out.println("Palindrome!");
        } else {
            System.out.println("Not a palindrome.");
        }
    }
    
    private boolean isPal(String str) {
        // abcdcba
        // 0123456
        // 0=6, 1=5, 2=4, 3
        // abccba
        // 012345
        // 0=5, 1=4, 2=3
        boolean ispal = true;
        for (int i = 0, j = str.length() - 1; i <= j; ++i, --j) {
            if (str.charAt(i) != str.charAt(j)) {
                ispal = false;
                break;
            }
        }
        return ispal;
    }
}