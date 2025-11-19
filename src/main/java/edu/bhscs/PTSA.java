// Saanvi Shah
// 10/07/25
// P2
// This is making the PTSA class

package edu.bhscs;

public class PTSA {
  // FIELDS AND PROPERTIES
  String name;
  int totalFunds;

  // CONSTRUCTOR
  public PTSA(String name) {
    this.name = name;
    this.totalFunds = 0;
  }

  // METHODS
  public void receiveDonation(int amount) {
    if (amount <= 0) {
      System.out.println("Invalid donation amount.");
      return;
    }

    totalFunds += amount;
    System.out.println(
        name + " PTSA received a donation of $" + amount + ". Total funds: $" + totalFunds);
  }

  public void printPTSAInfo() {
    System.out.println("\n--- PTSA Info ---");
    System.out.println("PTSA Name: " + name);
    System.out.println("Total Funds Raised: $" + totalFunds);
  }
}
