package backgammon;

import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public class Main {

  /**
   * The pip function prints the pip count value for both users using the game and settings object
   * @param game 
   * @param settings
   */
  public static void pip(Game game, Settings settings) {
    System.out.println("Pip count for user - " + game.getUsername1() + ": " + settings.pip1);
    System.out.println("Pip count for user - " + game.getUsername2() + ": " + settings.pip2);
  }

  /**
   * Display the pip value for the current user according to the Game and Settings object
   * @param game
   * @param settings
   */
  public static void currentPip(Game game, Settings settings) {
    // display the settings information
    if (settings != null) {
      int pip = 0;
      // display the pip count based on the current user
      if (game.getCurrentUserID() == 1) {
        pip = settings.pip1;
      } else
        pip = settings.pip2;

      System.out.println(game.getCurrentUser() + " pip count: " + Integer.toString(pip));
    }

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
  public static void play(Game game, Settings settings, Scanner scanner) {
    // print the board information
    String rollResultStr = game.roll();
    String[] result = rollResultStr.split("-");
    int rollResult = Integer.parseInt(result[0]) + Integer.parseInt(result[1]);
    int playTimes = result[0].equals(result[1]) ? 4 : 2;

    // print the dice information
    System.out.print(game.getCurrentChecker() + " to play: " + rollResultStr + "\t"); // not a new line
    currentPip(game, settings);

    // game.toggleCurrentUser(); // toggle user should be moved after the user
    // complete the checker-movement

    // print available moves for the current user for one dice per time
    for (int i = 0; i < playTimes; i++) {
      int dice = Integer.parseInt(result[i % 2]);
      if (i == 1) {
        System.out.println(game.getCurrentChecker() + " to play " + result[1]);
      }
      Map<Integer, Map<Integer, Integer>> options = game.getBoard().printAvailableMoves(game.getCurrentChecker(), dice);

      if (options.size() > 0) {

        int option = -1;
        System.out.println(); // add a new line for readability

        // user choose one movement
        System.out.println("Select an option");
        while (option == -1) {
          try {
            option = Integer.parseInt(scanner.nextLine());
            if (option > options.size() || option < 1) {
              option = -1;
              throw new NumberFormatException();
            }
          } catch (NumberFormatException e) {
            System.out.println("Enter a valid number for the option.");
          }
        }
        System.out.println("selected " + Integer.toString(option));

        // extract the result
        String selected = options.get(option).toString();
        selected = selected.replace("{", "");
        selected = selected.replace("}", "");
        String[] selected1 = selected.split("=");

        // move
        game.getBoard().move(game.getCurrentChecker(), Integer.parseInt(selected1[0]), Integer.parseInt(selected1[1]));

        // update the pip count
        int pipCount = game.getBoard().pipCount(game.getCurrentUserID());
        settings.setCurrentUserPip(game.getCurrentUserID(), pipCount);

        game.displayGame();
        currentPip(game, settings);

      } else {
        System.out.println("No available moves. Skipped");
        continue;
      }

    }

    game.toggleCurrentUser();

  }

  public static void main(String args[]) {

    Settings settings = new Settings();
    Game game = settings.init(); // this step will determin the current user by rolling dice
    InputStream in = System.in;
    Scanner scanner = new Scanner(in);

    // if any of the pip count in the settings object becomes zero,
    // then the game will stop
    while (!game.isGameOver(settings)) {

      System.out.println("(Input the command \"hint\" for more instruction.)");
      System.out.println("Input the command for user: " + game.getCurrentUser());
      System.out.println(); // add a new line for readability

      String cmdInput = scanner.nextLine();
      System.out.println(); // add a new line for readability

      Command cmd = new Command(cmdInput);

      if (cmd.isValidCmd()) {
        switch (cmd.getCMD()) {
          case "roll":
            game.displayGame();
            play(game, settings, scanner);
            break;

          case "hint":
            System.out.println("Command hint pressed.");
            cmd.printAllCmds();
            break;

          case "pip":
            System.out.println("Command pip pressed.");
            pip(game, settings);
            break;

          case "quit":
            System.out.println("Command quit pressed.");
            System.exit(0);

          default:

            // for user input dice, dice <int> <int>
            if (cmd.isDiceCmd()) {
              String dice1 = cmd.getCMD().split(" ")[1];
              String dice2 = cmd.getCMD().split(" ")[2];
              String inputDice = dice1 + "-" + dice2;
              game.setInputDice(inputDice);
              System.out.println("Next dice is set to " + inputDice);
            }

            // for test command, test <filename>
            if (cmd.isTestCmd()) {
              String filename;
              filename = cmd.getCMD().split(" ")[1];
              try {
                in = new BufferedInputStream(new FileInputStream(filename));
                scanner = new Scanner(in);
                System.out.println("Setting scanner input to a file.");
              } catch (FileNotFoundException e) {
                System.out.println("The file was not found, please try again.");
              }
            }

            break;
        }
      } else {
        System.out.println("Not a valid command, try again.");
        continue;
      }
    }

  }
}