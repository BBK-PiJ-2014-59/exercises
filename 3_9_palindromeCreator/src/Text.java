public class Text {
    
    String makefrom;
    
    public void getFromUser(String str) {
        makefrom = str;
    }
    
    public void showResult() {
        int i;
        for (i=0; i < makefrom.length(); ++i)
            System.out.print(makefrom.charAt(i));
        for (--i; i >= 0; --i)
            System.out.print(makefrom.charAt(i));
    }
}