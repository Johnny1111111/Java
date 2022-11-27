package backgammon;
import java.util.Scanner;

import java.util.Scanner;

public class Main {
  
  public static void pip(Game game, Settings settings) {
    System.out.println("Pip count for user - " + game.getUsername1() + ": " + settings.pip1);
    System.out.println("Pip count for user - " + game.getUsername2() + ": " + settings.pip2);
  }
  
  public static void play(Game game) {
    play(game, null);
  }

  public static void play(Game game, Settings settings) {
    // print the board information
    game.displayGame();
    // print the dice information
    System.out.print("Dice result: " + game.roll() + "\t"); // not a new line
    game.toggleCurrentUser();

    // display the settings information
    if (settings != null) {
      int pip = 0;
      // display the pip count based on the current user
      if (game.getCurrentUser().contains("1") ) {
        pip = settings.pip1;
      } else pip = settings.pip2;

      System.out.println("Pip count: " + Integer.toString(pip));

    }
  }

  public static void main(String args[]) {

    Settings settings = new Settings();
    Game game = settings.init();
    Scanner scanner = new Scanner(System.in);

    while (!game.isGameOver()) {
      System.out.println("Input the command for user: " + game.getCurrentUser());
      System.out.println(); // add a new line for readability
      String cmdInput = scanner.nextLine();
      System.out.println(); // add a new line for readability
      Command cmd = new Command(cmdInput);
      if (cmd.isValidCmd()) {
        switch (cmd.getCMD()) {
          case "roll":
            play(game, settings);
            System.out.println(); // add a new line for readability
            break;
          case "hint":
            cmd.printAllCmds();
            break;
          case "pip":
            pip(game, settings);
            break;
          case "quit":
            System.exit(0);
          default:
            break;
        }
      } else {
        System.out.println("Not a valid command, try again.");
        continue;
      }
    }

  }
}