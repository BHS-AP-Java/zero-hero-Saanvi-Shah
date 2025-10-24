// Saanvi Shah
// 10/07/25
// P2
// This is making the Bank class

/*
 * DESCRIPTION: The Bank class keeps track of money for the player (customer) and the PTSA. It
 * handles transactions when cakes are purchased and donated. Every player has their own bank
 * balance that decreases as they buy cakes.
 *
 * INPUT: Transaction amount when the player buys a cake.
 *
 * OUTPUT: Updated balances for the customer and PTSA.
 *
 * EDGE CASES: - When the player doesn’t have enough money. - Negative transaction amounts.
 */

package edu.bhscs;

public class Bank {
  // ---------------- FIELDS AND PROPERTIES ----------------
  int customerBalance = 100; // starting money for the customer
  int ptsaBalance = 0; // total PTSA funds raised

  // ---------------- CONSTRUCTOR ----------------
  public Bank() {
    // default constructor
  }

  // ---------------- METHODS ----------------

  // processTransaction(): moves money from customer to PTSA
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

  // getCustomerBalance(): returns current player money
  public int getCustomerBalance() {
    return customerBalance;
  }

  // getPTSABalance(): returns PTSA total
  public int getPTSABalance() {
    return ptsaBalance;
  }

  // depositToPTSA(): adds extra donations (if baker donates directly)
  public void depositToPTSA(int amount) {
    ptsaBalance += amount;
    System.out.println("The PTSA received a donation of $" + amount + "!");
    System.out.println("PTSA total is now $" + ptsaBalance);
  }
}
