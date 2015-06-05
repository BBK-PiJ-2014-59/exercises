/*
8
Temperature averages
Write a program that reads a file from disk in comma-separated format (CSV). Every line must contain a list of
number separated by commas.
The program must output the average for every line plus the average for the whole file. A file may look like the
following:

10, 9, 8, 10, 9, 8,10,9,8,10,9,9
6,9,8,10,9,8,10, 9,8,10,9,8,1,1,1,4,6
16,14,8,10,9,8,10, 9,8, 10,9,12
*/

import java.util.List;
import java.util.ArrayList;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TempAve { 
	public static void main(String[] args) { 
    printList(ave(new File(args[0])));
	}

  private static void printList(List<Integer> list) { 
    int tot = 0;
    for (Integer n : list) { 
      System.out.println(n);
      tot += n;
    }
    int ave = 0;
    if (list.size() > 0)
      ave = tot/list.size();
    else
      throw new IllegalArgumentException("Zero-length list of lines"); 
    System.out.println("ave: " + ave);
  }

  private static int[] toInts (String[] sarr) { 
    int[] ints = new int[sarr.length]; 
    for (int i=0; i<sarr.length; ++i)
      ints[i] = Integer.parseInt(sarr[i]);
    return ints;
  }

  private static int aveLine(String line) { 
    //System.out.println(line);
    String[] intStrings = line.split("\\s*,\\s*");
    int[] ints = toInts(intStrings); 
    int tot = 0;
    for (int n : ints) 
      tot += n;
    int ave = 0;
    if (ints.length > 0)
      ave = tot/ints.length;
    else
      throw new IllegalArgumentException("Zero-length list of temperatures"); 
    return ave;
  }



  private static List<Integer> ave(File src) { 
    BufferedReader in = null;
    List<Integer> list = new ArrayList<>();
    try {
        in = new BufferedReader(new FileReader(src));
        String line;
        while ((line = in.readLine()) != null)
          list.add(aveLine(line));
    } catch (FileNotFoundException ex) {
        System.out.println("File " + src + " does not exist.");
    } catch (IOException ex) { 
        ex.printStackTrace(); 
    } finally {
        closeReader(in);
    }
    return list;
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
