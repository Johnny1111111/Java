package backgammon;
/*
 * A User object, which contains the user information, username
 */
class User {
	  private String username;

	  public User() {
	    this.username = "";
	  }

	  public User(String username) {
	    this.username = username;
	  }

	  public String getName() {
	    return this.username;
	  }

	  public void setName(String username) {
	    this.username = username;
	  }

	}