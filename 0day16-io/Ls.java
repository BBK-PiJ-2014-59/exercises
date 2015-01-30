/* 
Day 16 - i/o
1) ls
Write a program that shows on screen the names of the files in the current directory. (Hint: look at methods from
class File).
*/

import java.io.File;

public class Ls { 
  public static void ls() { 
    File dir = new File("."); 
    for (String file : dir.list())
      System.out.println(file);
  }
  public static void main(String[] args) { 
    ls(); 
  }
}
