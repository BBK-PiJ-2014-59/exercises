// 6 Eight Dames (**)
// Create a method that calculates the solution to the problem of the eight 
// Dames: “given a chess board, and knowing that the Dame can reach any 
// tile horizontally, vertically, or diagonally, place 8 Dames on the board 
// so that none of them can reach the others by doing only one move”. You 
// can return the solution as an array of 8x8 booleans where eight tiles are 
// true (those with the Dames on them) and the others are false.  For extra 
// complexity, make your method return all the possibilities in which the 
// problem can be solved (this may take a long time).

public class EightDames {
  static boolean[][] squares = new boolean[8][8];
   
  void showSquares(int n) {
  }

  class Square {
    int x;
    int y;
    int damenum;
  
    Square (int n) {
      damenum = n;
    }

    int getx() {
      return x;
    }

    int gety() {
      return y;
    }

    int getDameNum() {
      return damenum;
    }

    Square nextDame(int n) {
	    if (x == 7)  {
	      x = 0;
	      ++y;
	    } 
	    if (y == 7) {
	      y = 0; 
	    } else {
	      ++x;
	    }
      boolean allOk, horizontalOk, verticalOk, diagonalOk;
      horizontalOk = verticalOk = diagonalOk = false;
	    if (n == 1) {
	       allOk = true;
	    } else {
        Square nextdame = new Square(n - 1);
	      if (this.getx() != nextdame.getx()) {
          horizontalOk = true;
        } 
        if (horizontalOk) { 
          if (this.gety() != nextdame.gety()) {
            verticalOk = true;
          }
        if (horizontalOk && verticalOk) {
          int xdif = this.getx() - nextdame.getx();
	      } 
	    }
  }

  public static void main(String[] args) {
    EightDames ed = new EightDames();
    ed.showSquares(8);
  }
}