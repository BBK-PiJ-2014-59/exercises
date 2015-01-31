/*
4
cp
a)
Write a program that takes two names from the user at the command line. If a file with the first name exists, the
program must copy it into a file with the second name.
If the first file does not exist, the program must say so. If the second file does exists, the program must ask the
user whether to overwrite it or not, and act accordingly.
*/

import java.io.Reader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Cp { 
	public static void main(String[] args) { 
    File src = new File(args[0]);
    File dest = new File(args[1]);
	  cp(src, dest);
	}

  private static void cp(File src, File dest) { 
    BufferedReader in = null;
    PrintWriter out = null;
    try {
        in = new BufferedReader(new FileReader(src));
        try {
          out = new PrintWriter(dest);
          String line;
          while ((line = in.readLine()) != null)
            out.write();
		    } catch (FileNotFoundException ex) {
		        System.out.println("File " + dest + " does not exist.");
		    } catch (IOException ex) {
		        ex.printStackTrace();
		    } finally {
		        out.close();
        }
    } catch (FileNotFoundException ex) {
        System.out.println("File " + src + " does not exist.");
    } catch (IOException ex) {
        ex.printStackTrace();
    } finally {
        closeReader(in);
        out.close();
    }
  }

	private static void closeReader(Reader reader) {
	  try {
	    if (reader != null) 
	      reader.close();
	  } catch (IOException ex) { 
	      ex.printStackTrace();
	  }
	}
}
