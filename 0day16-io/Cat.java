/*
3
cat
a)
Write a program that takes a name from the user at the command line. If a file with that name exists, the program
must show its contents on screen. If it does not, the program must say so.
*/

import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Cat { 

	public static void main(String[] args) { 
	  cat(args[0]);
	}

  private static void cat(String fname) { 
    File file = new File(fname);
    BufferedReader in = null;
    try {
        in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null)
          System.out.println(line);
    } catch (FileNotFoundException ex) {
        System.out.println("File " + file + " does not exist.");
    } catch (IOException ex) {
        ex.printStackTrace();
    } finally {
        closeReader(in);
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
