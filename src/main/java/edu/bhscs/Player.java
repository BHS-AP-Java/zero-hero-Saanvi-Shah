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

  // FIX #4: Added missing setBankBalance method
  public void setBankBalance(int balance) {
    this.bankBalance = balance;
    bank.customerBalance = balance; // Sync with bank object
  }

  // FIX #4: Added missing getBankBalance method
  public int getBankBalance() {
    return bankBalance;
  }

  // Wrapper for text input
  public String ask(String prompt) {
    System.out.print(prompt);
    return sc.nextLine();
  }

  // FIX #4: Added missing askInt method
  public int askInt(String prompt) {
    System.out.print(prompt);
    while (!sc.hasNextInt()) {
      System.out.print("Please enter a valid number: ");
      sc.next();
    }
    int num = sc.nextInt();
    sc.nextLine(); // Clear newline
    return num;
  }

  // FIX #4: Added missing pay method (required by Customer interface)
  public int pay(int price) {
    if (bankBalance >= price) {
      bankBalance -= price;
      bank.customerBalance = bankBalance;
      System.out.println("Payment successful! $" + price + " deducted.");
      System.out.println("Remaining balance: $" + bankBalance);
      return price;
    } else {
      System.out.println("Insufficient funds!");
      return 0;
    }
  }

  // FIX #4: Added missing takeCake method (required by Customer interface)
  public void takeCake(Cake cake) {
    System.out.println(name + " receives the cake and smiles!");
  }

  // FIX #4: Added missing giveAnswer method (used by Baker)
  public String giveAnswer(String question) {
    System.out.print(question + " ");
    return sc.nextLine();
  }

  // When the game ends, close the scanner
  public void closeScanner() {
    sc.close();
  }
}
