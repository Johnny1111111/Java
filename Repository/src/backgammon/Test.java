package backgammon;

/*
 * A simple test class which serves as a manual test script for some functions
 */
public class Test {
  public static void main(String[] args) {
    // Test board
    Board board = new Board();

    // Test user game information
    Game game = new Game("d", "w");
    game.decidePlayer();
    System.out.println(game.boardInfo());

    // Test checker movement

    // Board board = new Board();
    board.output(2);
    board.printAvailableMoves("X", 2);
    // board.move(13, 11);
    System.out.println();
    board.output(1);

  }
}
