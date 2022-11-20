package backgammon;



public class Game {
	  private  Dice dice;
	  private User user1;
	  private User user2;

	  public Game() {
	    this.user1 = new User();
	    this.user2 = new User();
	    this.dice = new Dice();
	  }

	  public Game(String username1, String username2) {
	    this();
	    this.user1.setName(username1);
	    this.user2.setName(username2);
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

	}