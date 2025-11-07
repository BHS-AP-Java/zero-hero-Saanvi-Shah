// Saanvi Shah
// 10/07/25
// P2
// This is making the Player class

package edu.bhscs;

import java.util.Scanner;

public class Player implements Customer {

  private String name;
  private int bankBalance;
  private Scanner sc;
  private Bank bank;

  public Player() {
    sc = new Scanner(System.in);
    bank = new Bank();
  }

  // METHODS
  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  // Wrapper for text input so Main doesn’t need a Scanner
  public String ask(String prompt) {
    System.out.print(prompt);
    return sc.nextLine();
  }

  // When the game ends, close the scanner
  public void closeScanner() {
    sc.close();
  }
}
