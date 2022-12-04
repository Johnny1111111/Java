package backgammon;

import java.util.ArrayList;
import java.util.Arrays;

public class Command {
  /*
   * The command object takes in a string as its command
   */
  private String cmd;
  private ArrayList<String> validCmdList;
  private String[] validCmds = {"roll", "pip", "hint", "quit", "dice"};

  public Command() {
    this.cmd = "";
    this.validCmdList = new ArrayList<String>();

    // add the valid commands
    this.validCmdList.addAll(Arrays.asList(this.validCmds));
  }

  public Command(String cmd) {
    this();
    this.cmd = cmd;
  }

  public String getCMD() {
    return this.cmd;
  }

  // check if the user-input command is valid or not
  public boolean isValidCmd() {
    if (this.validCmdList.contains(this.cmd)) return true;
    if (this.isDiceCmd()) return true;
    if (this.isTestCmd()) return true;
    return false;
  }

  // return a list of available commands
  public String[] getAllCmds() {
    return this.validCmds;
  }

  public void printAllCmds() {
    System.out.println("This is all the valid commands"); 
    for (int i = 0; i < this.validCmds.length; i++) {
      System.out.println("- " + this.validCmds[i]); 
    }
  }

  // Use the regular expression to check the command type
  public boolean isDiceCmd() {
    return this.cmd.matches("dice \\d \\d");
  }

  public boolean isTestCmd() {
    return this.cmd.matches("test .*");
  }
}
