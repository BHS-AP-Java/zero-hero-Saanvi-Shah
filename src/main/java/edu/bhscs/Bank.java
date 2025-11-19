// Saanvi Shah
// 10/07/25
// P2
// This is making the Bank class

package edu.bhscs;

public class Bank {
  // FIELDS AND PROPERTIES
  int customerBalance = 100;
  int ptsaBalance = 0;

  // CONSTRUCTOR
  public Bank() {}

  // METHODS
  public void processTransaction(int amount) {
    if (amount <= 0) {
      System.out.println("Invalid transaction amount!");
      return;
    }

    if (amount <= customerBalance) {
      customerBalance -= amount;
      ptsaBalance += amount;
      System.out.println("Transaction successful!");
      System.out.println("Customer balance: $" + customerBalance);
      System.out.println("PTSA balance: $" + ptsaBalance);
    } else {
      System.out.println("Transaction failed! Insufficient funds in customer account.");
    }
  }

  public int getCustomerBalance() {
    return customerBalance;
  }

  public int getPTSABalance() {
    return ptsaBalance;
  }

  public void depositToPTSA(int amount) {
    ptsaBalance += amount;
    System.out.println("The PTSA received a donation of $" + amount + "!");
    System.out.println("PTSA total is now $" + ptsaBalance);
  }
}
