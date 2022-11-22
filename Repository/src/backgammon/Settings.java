package backgammon;

import java.util.Scanner;


public class Settings {

  public int pip1;
  public int pip2;

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

  public Game init(boolean verbose) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Please enter the first username:\n");
    String username1 = scanner.nextLine();
    System.out.println();

    System.out.println("Please enter the second username:\n");
    String username2 = scanner.nextLine();
    System.out.println();

    Game game = new Game(username1, username2);
    game.decidePlayer();

    // Username info
    if (verbose) {
      System.out.println("The first  username is: " + game.getUsername1());
      System.out.println("The second username is: " + game.getUsername2());
    }

    return game;
  }

}
