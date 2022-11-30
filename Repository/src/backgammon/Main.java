package backgammon;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void pip(Game game, Settings settings) {
    System.out.println("Pip count for user - " + game.getUsername1() + ": " + settings.pip1);
    System.out.println("Pip count for user - " + game.getUsername2() + ": " + settings.pip2);
  }

  public static void play(Game game) {
    play(game, null);
  }

  /**
   * This method is used for displaying the key information for each round
   * Show the board, the dice result and the pip values for the current player
   * 
   * @param game
   * @param settings
   *                 If the user is able to select movement with the dice result,
   *                 then return true otherwise false;
   */
  public static Map<Integer, Map<Integer, Integer>> play(Game game, Settings settings) {
    // print the board information
    game.displayGame();
    String rollResultStr = game.roll();
    String[] result = rollResultStr.split("-");
    int rollResult = Integer.parseInt(result[0]) + Integer.parseInt(result[1]);

    // print the dice information
    System.out.print(game.getCurrentChecker() + " to play: " + rollResultStr + "\t"); // not a new line

    // game.toggleCurrentUser(); // toggle user should be moved after the user
    // complete the checker-movement

    // display the settings information
    if (settings != null) {
      int pip = 0;
      // display the pip count based on the current user
      if (game.getCurrentUserID() == 1) {
        pip = settings.pip1;
      } else
        pip = settings.pip2;

      System.out.println("Pip count: " + Integer.toString(pip));
    }

    // print available moves for the current user
    Map<Integer, Map<Integer, Integer>> options = game.getBoard().printAvailableMoves(game.getCurrentChecker(), rollResult);
    if (options.size() > 0) {
      return options;
    } else {
      System.out.println("There is no available move for the current user.");
      return new HashMap<>();
    }

    // After chose one, toggle the current user
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

      int option = -1;
      if (cmd.isValidCmd()) {
        switch (cmd.getCMD()) {
          case "roll":
            Map<Integer, Map<Integer, Integer>> options = play(game, settings);
            System.out.println(); // add a new line for readability
            if (options.size() > 0) {
              // user choose one movement
              System.out.println("Select an option");
              while (option == -1) {
                try {
                  option = Integer.parseInt(scanner.nextLine());
                  if (option > options.size() || option < 1) throw new NumberFormatException();
                } catch (NumberFormatException e) {
                  System.out.println("Enter a valid number for the option.");
                }
              }
              System.out.println("selected " + Integer.toString(option));
            } else {
              System.out.println("No available moves. Skipped");
              continue;
            }

            // extract the result
            String selected = options.get(option).toString();
            selected = selected.replace("{", "");
            selected = selected.replace("}", "");
            String[] selected1 = selected.split("=");

            // move
            game.getBoard().move(Integer.parseInt(selected1[0]), Integer.parseInt(selected1[1]));

            // update the pip count
            int pipCount = game.getBoard().pipCount(game.getCurrentUserID());
            settings.setCurrentUserPip(game.getCurrentUserID(), pipCount);

            game.displayGame();
            game.toggleCurrentUser();
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