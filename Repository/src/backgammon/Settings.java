package backgammon;

import java.util.Scanner;
/*
 * A settings class which contains the information about the game,
 * - pip for user1 and pip for user2;
 * - init the game to start
 * - set the pip value for the current user
 */
public class Settings {

  public int pip1;
  public int pip2;

  /**
   * The initial pip count for the settings.
   */
  public Settings() {
    this.pip1 = 167;
    this.pip2 = 167;
  }

  /**
   * init the game no information output as a default
   * 
   * @return a game object
   */
  public Game init() {
    return this.init(false);
  }

  /*
   * Initialise the game
   */
  public Game init(boolean verbose) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Please enter the first username:\n");
    String username1 = scanner.nextLine();
    System.out.println();

    System.out.println("Please enter the second username:\n");
    String username2 = scanner.nextLine();
    System.out.println();

    Game game = new Game(username1, username2);
    // decide which player to start by rolling dice
    game.decidePlayer();

    // Username info
    if (verbose) {
      System.out.println("The first  username is: " + game.getUsername1());
      System.out.println("The second username is: " + game.getUsername2());
    }

    return game;
  }

  /**
   * A function to set the pip value for the current user
   * @param userID the user id to update the pip value
   * @param pip the updated pip value
   */
  public void setCurrentUserPip(int userID, int pip) {
    if(userID == 1) {
      this.pip1 = pip;
    } else {
      this.pip2 = pip;
    }
  }

}
