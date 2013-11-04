import java.util.*;

public class Matrix {
  private int[][] m;
  private int numRows;
  private int numCols;


  private Matrix (int d1, int d2) {
    numRows = d1;
    numCols = d2;
    m = new int[numRows][numCols]; 
    for (int i = 0; i < numRows; ++i) 
      for (int j = 0; j < numCols; ++j)
        m[i][j] = 1;
  }
  
  private void setElement(int d1, int d2, int v) {
    if (d1 < m.length && d2 < m[m.length - 1].length)
      m[d1][d2] = v;
  }

  // a method setRow(int,String) that modifies one whole row of the array, given its position as an integer and the list of numbers as a String like “1,2,3”. The method must check that the index is valid and the numbers are correct (i.e. if the array has three columns, the String contains three numbers). If the index or the String is invalid, the method will do nothing. 
  private void setRow(int rowNum, String rowVals) {
    // setRow(1, "6,5,4,343,2");
    if (rowNum >= 0 && rowNum < m.length) {
      String[] rowValStrings = rowVals.split(",");
      if (rowValStrings.length == m[rowNum].length) {
        for (int i = 0; i < m[rowNum].length; ++i) {
          m[rowNum][i] = (Integer.parseInt(rowValStrings[i]));
        }
      } 
    }
  }

  // a method setColumn(int,String) that modifies one whole column of the array, given its position as an integer and the list of numbers as a String like “1,2,3”. The method must check that the index is valid and the numbers are correct (i.e. if the array has four rows, the String contains four numbers). If the index or the String is invalid, the method will do nothing.
  
  private void setColumn(int colNum, String colVals) {
    // setColumn(1, "6,5,4,343");
    if (colNum >= 0 && colNum < m[0].length) {
      String[] colValStrings = colVals.split(",");
      if (colValStrings.length == m.length) {
        for (int i = 0; i < m.length; ++i) {;
          m[i][colNum] = (Integer.parseInt(colValStrings[i]));
        }
      } 
    }
  }

  // a method toString() that returns the values in the array as a String using square brackets, commas, and semicolons, e.g. “[1,2,3;4,5,6;3,2,1]”

  private String toString2() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < numRows; ++i) {
      for (int j = 0; j < numCols; ++j) {
        sb.append(m[i][j]);
        if (j < numCols - 1) 
          sb.append(",");
      }
      if (i < numRows - 1)
        sb.append(";");
    } 
    sb.append("]");
    return sb.toString();
  }

  // A method prettyPrint() that prints the values of the matrix on screen in a legible format. Hint: you can use the special character ’\t’ (backslash-t) to mark a tabulator so that all numbers are placed in the same column regardless of their size. You can think of a tabulator character as a move-to-the-next-column command when printing on the screen.


  private void prettyPrint() {
    for (int i = 0; i < numRows; ++i) {
      for (int j = 0; j < numCols; ++j) {
        System.out.print(m[i][j]);    
        if (j < numCols - 1) { 
          System.out.print('\t');
        }
      }
      System.out.println();
    } 
  }

  // exe 6-4: One-liners for matrices (*) Extend your Matrix class with a method setMatrix(String) that takes a String representing the numbers to be put in the elements of the array separated by commas, separating rows by semicolons, e.g. 1,2,3;4,5,6;7,8,9.
  private void setMatrix(String allVals) {
    String[] rowStrings = allVals.split(";"); 
    // private void setRow(int rowNum, String rowVals) {
    for (int i = 0; i < numRows; ++i) {
      System.out.println(i + " " + rowStrings[i]);
      setRow(i, rowStrings[i]);
    }
  }

  private void launch() {
    // int d1 = 3, d2 = 5, val = 99;
    // setElement(d1, d2, val);
    setRow(1, "6,5,4,343,2");
    setColumn(1, "6,5,4,342");
    System.out.println(m[1][3]);
    System.out.println(m[3][1]);
    System.out.println(toString2());
    prettyPrint();
    setMatrix("1,2,3,4;5,6,7,8;9,10,11,12;13,14,15,16;17,18,19,20");
    System.out.println();
    prettyPrint();
  }

  public static void main(String[] args) {
    int d1 = 4, d2 = 5;
    Matrix m = new Matrix(d1, d2);
    m.launch();
  }

}