package backgammon;
import java.util.Scanner;

public class Main {

  public static void play(Game game) {
    // print the board information
    game.displayGame();
    // print the dice information
    System.out.println("Dice result: " + game.roll());
    game.toggleCurrentUser();
  }

  public static void main(String args[]) {

    Game game = new Settings().init();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("Input the command for user: " + game.getCurrentUser());
      String cmdInput = scanner.nextLine();
      Command cmd = new Command(cmdInput);
      if (cmd.isValidCmd()) {
        switch (cmd.getCMD()) {
          case "roll":
            play(game);
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