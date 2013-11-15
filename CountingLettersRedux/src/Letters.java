public class Letters {
    
    int[] charq = new int[35]; // 35 is the return value for getNumericValue of z or Z
    
    public void addLetterIfUnusedElseExit(String let) {
        if (charq[Character.getNumericValue(let.charAt(0))] != 0) {
            System.out.println("Bye!");
            System.exit(0);
        } else {
        ++charq[Character.getNumericValue(let.charAt(0))];
        } 
    }
}