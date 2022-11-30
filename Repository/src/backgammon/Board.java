package backgammon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

public class Board {

  class Point {
    public int x;
    public int y;

    public Point() {
      this.x = 0;
      this.y = 0;
    }

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

  }

  private String[][] board;
  private ArrayList<ArrayList<String>> board_list;
  private String checker1 = "O";
  private String checker2 = "X";

  private String firstRow1 = "13--+---+---+---+---18 BAR  19--+---+---+---+--24";
  private String lastRow1 = "12--+---+---+---+---07 BAR  06--+---+---+---+--01";

  private String firstRow2 = "01--+---+---+---+---06 BAR  07--+---+---+---+--12";
  private String lastRow2 = "24--+---+---+---+---19 BAR  18--+---+---+---+--13";

  private String bar = "|"; // the empty checker placeholder
  private int barCount;

  public Board() {
    this.barCount = 0;
    this.board = new String[11][13];
    this.board_list = new ArrayList<>();
    // i = 0 represents off
    // i = 25 represents bar
    for (int i = 0; i <= 25; i++) {
      board_list.add(new ArrayList<>());
    }

    // initialise the state
    String[] twoX = new String[2];
    Arrays.fill(twoX, "X");
    board_list.get(1).addAll(Arrays.asList(twoX));

    String[] twoO = new String[2];
    Arrays.fill(twoO, "O");
    board_list.get(24).addAll(Arrays.asList(twoO));

    String[] fiveO = new String[5];
    Arrays.fill(fiveO, "O");
    board_list.get(6).addAll(Arrays.asList(fiveO));
    board_list.get(13).addAll(Arrays.asList(fiveO));

    String[] fiveX = new String[5];
    Arrays.fill(fiveX, "X");
    board_list.get(12).addAll(Arrays.asList(fiveX));
    board_list.get(19).addAll(Arrays.asList(fiveX));

    String[] threeO = new String[3];
    Arrays.fill(threeO, "O");
    board_list.get(8).addAll(Arrays.asList(threeO));

    String[] threeX = new String[3];
    Arrays.fill(threeX, "X");
    board_list.get(17).addAll(Arrays.asList(threeX));

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

  private boolean isChecker(Point p) {
    return this.board[p.x][p.y].equals(checker1) || this.board[p.x][p.y].equals(checker2);
  }

  public boolean moveChecker(Point pa, Point pb) {
    if (isChecker(pa)) {
      String checker = this.board[pa.x][pa.y];
      this.board[pa.x][pa.y] = bar; // set the original point to the empty placeholder
      this.board[pb.x][pb.y] = checker;
      return true;
    } else {
      System.out.println("Invalid move.");
      return false;
    }
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

  /**
   * print the top-half boards
   */
  public void outputBoard1() {

    for (int i = 0; i < 5; i++) {
      for (int j = 13; j <= 24; j++) {
        String element;

        try {
          element = this.board_list.get(j).get(i);
          System.out.print(element + "   ");

        } catch (IndexOutOfBoundsException e) {
          System.out.print(this.bar + "   ");
        }

        // print the bar column
        String itemOnBar;
        if (j == 18) {
          try {
            itemOnBar = this.board_list.get(0).get(this.barCount++);
            System.out.println(itemOnBar + "   ");

          } catch (IndexOutOfBoundsException e) {
            System.out.print(" " + "   ");
          }
        }
      }
      System.out.println();
    }
  }

  /**
   * Print the bottom half board
   */
  public void outputBoard2() {
    for (int i = 4; i >= 0; i--) {
      for (int j = 12; j >= 1; j--) {
        String element;

        try {
          element = this.board_list.get(j).get(i);
          System.out.print(element + "   ");

        } catch (IndexOutOfBoundsException e) {
          System.out.print(this.bar + "   ");
        }

        // print the bar column
        String itemOnBar;
        if (j == 7) {
          try {
            itemOnBar = this.board_list.get(0).get(this.barCount++);
            System.out.println(itemOnBar + "   ");

          } catch (IndexOutOfBoundsException e) {
            System.out.print(" " + "   ");
          }
        }
      }
      System.out.println();
    }
  }

  public void output(int userID) {
    String firstRow, lastRow;
    // firstRow = (userID == 1) ? firstRow1 : firstRow2;
    firstRow = firstRow1;
    lastRow = lastRow1;
    // lastRow = (userID == 1) ? lastRow1 : lastRow2;

    System.out.println(firstRow);
    // this.outputBoard(); // deprecated using array to represent
    this.outputBoard1();
    System.out.println();
    this.outputBoard2();
    System.out.println(lastRow);
  }

  /**
   * Print available moves for the user
   * 
   * @param checker
   * @return true if there is at least one legal move; false if there is not a
   *         legal move.
   */
  public Map<Integer, Map<Integer, Integer>> printAvailableMoves(String checker, int dice) {
    int count = 1;
    Map<Integer, Map<Integer, Integer>> options = new HashMap();
    System.out.println("Select moves for checker " + checker + ":");
    for (int i = 0; i < this.board_list.size(); i++) {
      ArrayList<String> column = this.board_list.get(i);
      int desColumn = -1;
      if (checker.equals(this.checker1)) {
        // for user 1
        desColumn = i - dice;
      } else {
        // for user 2
        desColumn = i + dice;
      }
      if (desColumn < 0) {
        continue;
      }

      /**
       * A column is moveable either empty or only one opponent checker;
       */
      // System.out.println("moveable? " + Integer.toString(i) + "," +
      // Integer.toString(desColumn));
      if (this.moveable(i, desColumn)) {
        if (column.get(0).equals(checker)) {
          Map<Integer, Integer> option = new HashMap<>();
          option.put(i, desColumn);
          options.put(count++, option);
        }
      }
    }

    for (int i = 1; i < count; i++) {
      String option = options.get(i).toString();
      option = option.replace("{", "");
      option = option.replace("}", "");
      option = option.replace("=", "-");
      System.out.println(
          Integer.toString(i) + ":" + " " + option);
    }
    return options;
  }

  public void move(int column, int desColumn) {
    if (this.moveable(column, desColumn)) {
      ArrayList<String> initialList = this.board_list.get(column);
      String lastOne = initialList.remove(initialList.size() - 1);
      this.board_list.get(desColumn).add(lastOne);
    }
  }

  public boolean moveable(int column, int desColumn) {
    String checkerType;
    boolean moveable = false;
    try {
      checkerType = this.board_list.get(column).get(0);

      if (this.board_list.get(desColumn).isEmpty()) {
        moveable = true;
      } else {
        // Not empty but match the type
        // if the column checker type match the current players checker type
        // A column is moveable either empty or only one opponent checker;
        if ((this.board_list.get(desColumn).get(0).equals(checkerType) && this.board_list.get(desColumn).size() < 5)
            || this.board_list.get(desColumn).size() == 1) {
          moveable = true;
        }
      }

    } catch (IndexOutOfBoundsException e) {
      // not a checker, it is empty
      return false;
    }
    return moveable;
  }

  /**
   * compute the pip count for user 1
   * 
   * @return
   */
  public int pipCount(int userID) {
    int pip = 0;
    for (int i = 1; i < this.board_list.size(); i++) {
      ArrayList<String> column = this.board_list.get(i);
      if (!column.isEmpty()) {
        if (userID == 1) {
          if (column.get(0).equals(this.checker1)) {
            pip += i * column.size();
          }
        } else if(userID == 2) {
          if (column.get(0).equals(this.checker2)) {
            pip += (25 - i) * column.size();
          }
        }
      }
    }
    return pip;
  }

  public String getChecker1() {
    return this.checker1;
  }

  public String getChecker2() {
    return this.checker2;
  }

}
