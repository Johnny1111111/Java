package backgammon;
import java.util.Random;

public class Dice {

  public String roll() {
    Random random = new Random();
    int dice1 = random.nextInt(6) + 1;
    int dice2 = random.nextInt(6) + 1;
    return "" + dice1 + "-" + dice2;
  }

  // May be used as a test
  // public static void main(String args[]) {
  //   for (int i = 0; i < 100; i ++) {
  //     System.out.println(roll());
  //   }
  // }

}

