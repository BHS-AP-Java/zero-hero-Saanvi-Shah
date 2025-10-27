// Saanvi Shah
// 10/07/25
// P2
// This is making the Player class

/*
 * DESCRIPTION: The Player class represents the person playing the bake sale game. It handles all
 * user input (Scanner wrapped inside), stores the player’s info, manages the player’s bank balance,
 * and interacts with other objects like the Baker and PTSA. INPUT: User choices from the terminal
 * (through ask() and askInt()). OUTPUT: Prompts and feedback messages to guide gameplay. EDGE
 * CASES: - Invalid numeric or text input - Bank balance goes below zero
 */

package edu.bhscs;

import java.util.Scanner;

public class Player implements Customer {
  // FIELDS AND PROPERTIES
  private String name; // name of the player
  private int bankBalance; // player’s available money
  private Scanner sc; // Scanner for user input

  // Associated objects
  private Bank bank; // bank account object

  // CONSTRUCTOR
  public Player() {
    sc = new Scanner(System.in);
    bank = new Bank(); // starts with default 100 but will be updated later
  }

  // METHODS

  // This method lets Main set the player’s name after choosing a character
  public void setName(String name) {
    this.name = name;
  }

  // This method returns the player’s name
  public String getName() {
    return name;
  }

  // This method sets the starting bank balance based on chosen character
  public void setBankBalance(int balance) {
    this.bankBalance = balance;
    bank.customerBalance = balance; // sync with the bank object
  }

  // This method returns the player’s current balance
  public int getBankBalance() {
    return bankBalance;
  }

  // Wrapper for text input so Main doesn’t need a Scanner
  public String ask(String prompt) {
    System.out.print(prompt);
    return sc.nextLine();
  }

  // Wrapper for integer input
  public int askInt(String prompt) {
    System.out.print(prompt);
    while (!sc.hasNextInt()) {
      System.out.print("Please enter a valid number: ");
      sc.next();
    }
    int num = sc.nextInt();
    sc.nextLine(); // clear newline
    return num;
  }

  // This method handles payments — reduces player's balance through the bank
  public int pay(int price) {
    if (bankBalance >= price) {
      bank.processTransaction(price); // Let the bank handle the transaction
      bankBalance = bank.getCustomerBalance(); // Update local balance from bank
      return price;
    } else {
      System.out.println("You don't have enough money for this purchase!");
      return 0;
    }
  }

  // Baker uses this to ask questions (required by Baker class)
  public String giveAnswer(String question) {
    System.out.print(question + " ");
    return sc.nextLine();
  }

  // Baker gives the player the cake (also required by Baker class)
  public void takeCake(Cake cake) {
    System.out.println(name + " takes the cake and smiles happily!");
  }

  // Method to handle PTSA donations
  public void donateToPTSA(int amount) {
    bank.depositToPTSA(amount);
  }

  // When the game ends, close the scanner
  public void closeScanner() {
    sc.close();
  }
}
