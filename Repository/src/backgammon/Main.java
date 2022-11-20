package backgammon;

import java.util.Scanner;



public class Main {

  public static void main(String args[]) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Please enter the first username:\n");
    String username1 = scanner.nextLine();
    System.out.println();

    System.out.println("Please enter the second username:\n");
    String username2 = scanner.nextLine();
    System.out.println();

    Game game = new Game(username1, username2);

    // Username info
    System.out.println("The first  username is: " + game.getUsername1());
    System.out.println("The first  username is: " + game.getUsername2());

    // To roll the two dices
    // System.out.println(game.roll());


    System.out.println();
  }
}