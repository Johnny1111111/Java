package backgammon;

public class Test {
	  public static void main(String[] args) {
	    // Test board
	    // Board board = new Board();
	    // board.output();

	    // Test user game information
	    Game game = new Game("d", "w");
	    game.decidePlayer();
	    System.out.println(game.boardInfo());
	  }
	}
