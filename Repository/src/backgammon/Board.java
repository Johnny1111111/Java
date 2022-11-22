package backgammon;

public class Board {
	  private String[][] board;
	  private String firstRow = "13--+---+---+---+---18 BAR  19--+---+---+---+--24";
	  private String lastRow  = "12--+---+---+---+---07 BAR  06--+---+---+---+--01";

	  private String bar = "|";
	  private String checker1 = "X";
	  private String checker2 = "O";

	  public Board() {
	    this.board = new String[11][13];
	    for (int i = 0; i < board.length; i++) {
	      for (int j = 0; j < board[0].length; j++) {
	        if (i == 5) {
	          board[i][j] = " ";
	        } else {
	          board[i][j] = bar;
	        }
	      }
	    }

	    // initial state
	    // for checker1 in the 1st and checker2 8th column
	    for (int i = 0; i < 5; i++) {
	      board[i][0] = checker1;
	      board[i][7] = checker2;
	    }

	    // for checker2 in the first column and checker1 8th column
	    for (int i = 6; i <= 10; i++) {
	      board[i][0] = checker2;
	      board[i][7] = checker1;
	    }


	    // for checker2 in the fifth column and checker1 last column
	    for (int i = 0; i < 3; i++) {
	      board[i][4] = checker2;
	      board[i][12] = checker1;
	    }

	    // for checker1 in the fifth column and checker 2 last column
	    for (int i = 8; i <= 10; i++) {
	      board[i][4] = checker1;
	      board[i][12] = checker2;
	    }

	    board[2][12] = bar;
	    board[8][12] = bar;

	  }

	  public String[][] getBoard() {
	    return this.board;
	  }

	  private void outputBoard() {
	    for (int i = 0; i < board.length; i++) {
	      for (int j = 0; j < board[0].length; j++) {
	        System.out.print(this.board[i][j]);
	        System.out.print("   "); // 3 space bar
	        if (j == board[0].length - 1) {
	          System.out.println();
	        }
	      }
	    }
	  }
	  
	  public void output() {
	    System.out.println(firstRow);
	    this.outputBoard();
	    System.out.println(lastRow);
	  }

	}