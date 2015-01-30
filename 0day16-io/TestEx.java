  /*
  Creation of a FileReader may throw an FileNotFoundException, and this is a checked excep-
  tion. This means that the code above must be placed inside a try/catch construct or the method
  must declare that it throws this exception.
  */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class TestEx { 
  public static void b() throws FileNotFoundException { 
      File file = new File("here/be/the/route/to/the/file");
      BufferedReader in = new BufferedReader(new FileReader(file));
  }

  public static void callb() throws FileNotFoundException { 
      b();
  }

  public static void callcallb() throws FileNotFoundException { 
      callb();
  }

  public static void a() { 
    try { 
      File file = new File("here/be/the/route/to/the/file");
      BufferedReader in = new BufferedReader(new FileReader(file));

    } catch (Exception e) { 
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
  public static void main(String[] args) { 
    a();
    try { 
    b();

    } catch (Exception e) { 

    }
  }
}
