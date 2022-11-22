package backgammon;


public class Game {
	  private Dice dice;
	  private User user1;
	  private User user2;
	  private Board board;
	  private User currentPlayer;

	  public Game() {
	    this.user1 = new User();
	    this.user2 = new User();
	    this.dice = new Dice();
	    this.board = new Board();
	    this.currentPlayer = null;
	  }

	  public Game(String username1, String username2) {
	    this();
	    this.user1.setName(username1);
	    this.user2.setName(username2);
	  }

	  public void decidePlayer() {
	    int dice1;
	    int dice2;
	    while (true) {
	      // generate two random dice for player1 and player2
	      String[] diceResult = this.dice.roll().split("-");
	      dice1 = Integer.parseInt(diceResult[0]);
	      dice2 = Integer.parseInt(diceResult[1]);

	      if (dice1 > dice2) {
	        this.currentPlayer = user1;
	        break;
	      } else if (dice1 < dice2) {
	        this.currentPlayer = user2;
	        break;
	      } else
	        continue;
	    }
	    System.out.println(user1.getName() + " rolls " + Integer.toString(dice1) + ", " + user2.getName() + " rolls "
	        + Integer.toString(dice2));
	    System.out.println(this.currentPlayer.getName() + " starts to play.");
	  }

	  public String boardInfo() {
	    String currentUser = "Current User: " + this.currentPlayer.getName();
	    return currentUser;
	  }

	  public void toggleCurrentUser() {
	    if (this.currentPlayer.equals(user1)) {
	      this.currentPlayer = user2;
	    } else {
	      this.currentPlayer = user1;
	    }
	  }

	  public void displayGame() {
	    // display board
	    this.board.output();
	    // display game info
	    // System.out.println(this.boardInfo());
	  }

	  public String roll() {
	    return this.dice.roll();
	  }

	  public String getUsername1() {
	    return this.user1.getName();
	  }

	  public String getUsername2() {
	    return this.user2.getName();
	  }

	  public String getCurrentUser() {
	    return this.currentPlayer.getName();
	  }

	}