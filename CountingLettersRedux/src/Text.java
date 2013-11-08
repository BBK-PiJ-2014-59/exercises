public class Text {
    
    private String searchthis;
    private String findthis;
    
    public void getTextFromUser() {
        String lc;
        System.out.println("Enter a string to search: ");
        searchthis = System.console().readLine();
        searchthis = searchthis.toLowerCase();
    } 
    
    public void showResult() {
        int n = 0;
        for (int i=0; i < searchthis.length(); ++i) {
            if (searchthis.charAt(i) == findthis.charAt(0)) {
                ++n;
            }
        }
        System.out.println("Times found: " + n);
    }
    
    public void getLetterFromUser() {
        System.out.println("Enter a letter to search for: ");
        findthis = System.console().readLine();
        findthis = findthis.toLowerCase();
        if (findthis.length() != 1) {
            System.exit(1);
        }
    }
    
    public String getLetter() {
        return findthis;
    }
}
