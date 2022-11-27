package backgammon;

import java.util.ArrayList;
import java.util.Arrays;

public class Command {
  /*
   * The command object takes in a string as its command
   */
  private String cmd;
  private ArrayList<String> validCmdList;
  private String[] validCmds = {"roll", "pip", "hint", "quit"};

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

  public boolean isValidCmd() {
    return (this.validCmdList.contains(this.cmd));
  }

  public String[] getAllCmds() {
    return this.validCmds;
  }

  public void printAllCmds() {
    System.out.println("This is all the valid commands"); 
    for (int i = 0; i < this.validCmds.length; i++) {
      System.out.println("- " + this.validCmds[i]); 
    }
  }
}
