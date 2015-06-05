import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PatternTest { 
  public static void test() { 
    // from KATE print KAE:
    //Pattern p = Pattern.compile("a*b");
    String extract = "T"; 
    Pattern p = Pattern.compile(".*" + extract + ".*");
    //Matcher m = p.matcher("aaaaab");
    Matcher m = p.matcher("KATE");
    boolean b = m.matches();
    System.out.println(b);
    String k = "KATE";
    String t = k.substring(3,4);
    String k2 = k.replaceAll(t, "");
    System.out.println(k2);
  }
  public static void main(String[] args) { 
    PatternTest.test();
  }
}
