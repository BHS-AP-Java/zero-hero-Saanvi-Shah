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

  public void setBankBalance(int balance) {
    this.bankBalance = balance;
    bank.customerBalance = balance;
  }

  public int getBankBalance() {
    return bankBalance;
  }

  public String ask(String prompt) {
    System.out.print(prompt);
    return sc.nextLine();
  }

  public int askInt(String prompt) {
    System.out.print(prompt);
    while (!sc.hasNextInt()) {
      System.out.print("Please enter a valid number: ");
      sc.next();
    }
    int num = sc.nextInt();
    sc.nextLine();
    return num;
  }

  public int pay(int price) {
    if (bankBalance >= price) {
      bank.processTransaction(price);
      bankBalance = bank.getCustomerBalance();
      return price;
    } else {
      System.out.println("You don't have enough money for this purchase!");
      return 0;
    }
  }

  public String giveAnswer(String question) {
    System.out.print(question + " ");
    return sc.nextLine();
  }

  public void takeCake(Cake cake) {
    System.out.println(name + " takes the cake and smiles happily!");
  }

  public void donateToPTSA(int amount) {
    bank.depositToPTSA(amount);
  }

  public void closeScanner() {
    sc.close();
  }
}
