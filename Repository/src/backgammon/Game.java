package backgammon;

/**
 * The Game class contains the game state and the information
 */
public class Game {
  private Dice dice;
  private String inputDice;
  private User user1;
  private User user2;
  private Board board;
  private User currentPlayer;
  private boolean gameOver;

  public Game() {
    this.user1 = new User();
    this.user2 = new User();
    this.dice = new Dice();
    this.board = new Board();
    this.currentPlayer = null;
    this.gameOver = false;
  }

  public Game(String username1, String username2) {
    this();
    this.user1.setName(username1);
    this.user2.setName(username2);
  }

  /**
   * Decide the player by rolling the dice
   */
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
    System.out.println();
  }

  public String boardInfo() {
    String currentUser = "Current User: " + this.currentPlayer.getName();
    return currentUser;
  }

  /**
   * Change the current user information
   */
  public void toggleCurrentUser() {
    if (this.currentPlayer.equals(user1)) {
      this.currentPlayer = user2;
    } else {
      this.currentPlayer = user1;
    }
  }

  /**
   * Print the whole game to the command line
   */
  public void displayGame() {
    // display board
    String checker = this.getCurrentUserID() == 1 ? this.board.getChecker1() : this.board.getChecker2();
    System.out.println("Current user: " + this.currentPlayer.getName() + "\t" + "Checker: " + checker);
    this.board.output(this.getUserID(this.currentPlayer));
    // display game info
    // System.out.println(this.boardInfo());
  }

  public int getUserID(User user) {
    return (user.equals(this.user1) ? 1 : 2);
  }

  public int getCurrentUserID() {
    return this.getUserID(this.currentPlayer);
  }

  /**
   * Roll the dice randomly or based on the user's input
   * @return the result of the dice, foramt <Integer>-<Integer>, for example, 2-6
   */
  public String roll() {
    if (this.inputDice != null) {
      String input = this.inputDice;
      this.inputDice = null;
      return input;
    }
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

  public boolean isGameOver(Settings settings) {
    if(settings.pip1 == 0 || settings.pip2 == 0) {
      return this.gameOver;
    } else {
      return false;
    }
  }

  public Board getBoard() {
    return this.board;
  }

  public String getCurrentChecker() {
    return (this.getCurrentUserID() == 1) ? this.board.getChecker1() : this.board.getChecker2();
  }

  public void setInputDice(String inputDice) {
    // try to casue exception
    int dice1 = Integer.parseInt(inputDice.split("-")[0]);
    int dice2 = Integer.parseInt(inputDice.split("-")[1]);
    this.inputDice = inputDice;
  }

}