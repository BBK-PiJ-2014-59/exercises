/*
2) mkdir
Write a program that takes a name from the user at the command line and creates a directory with that name.
Remember that the only argument of method main is an array of Strings, each of them an argument written after
the name of the class. For example, if you write "java myClass this That 0" the elements in args will be three
strings of values “this”, “That”, and “0”.
*/

import java.io.File;

public class Mkdir { 
	private static void mkdir(String dirname) { 
	  File f = new File(dirname); 
	  f.mkdir();
	}
	
	public static void main(String[] args) { 
	  mkdir(args[0]);
	}
}
