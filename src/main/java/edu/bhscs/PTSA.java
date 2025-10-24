// Saanvi Shah
// 10/07/25
// P2
// This is making the PTSA class

/*
 * DESCRIPTION: The PTSA class represents the Parent Teacher Student Association that receives money
 * from the bake sale donations. Every time a cake is sold (and the baker decides to donate the
 * money), this class records the amount raised.
 *
 * INPUT: Donation amount (int)
 *
 * OUTPUT: A message showing how much money the PTSA has earned so far.
 *
 * EDGE CASES: - Negative or zero donation amounts.
 */

package edu.bhscs;

public class PTSA {
  // FIELDS AND PROPERTIES
  String name; // name of the PTSA (like "Bothell High")
  int totalFunds; // total money raised through bake sales

  // CONSTRUCTOR
  public PTSA(String name) {
    this.name = name;
    this.totalFunds = 0;
  }

  // METHODS

  // receiveDonation(): called whenever the baker donates
  public void receiveDonation(int amount) {
    if (amount <= 0) {
      System.out.println("Invalid donation amount.");
      return;
    }

    totalFunds += amount;
    System.out.println(
        name + " PTSA received a donation of $" + amount + ". Total funds: $" + totalFunds);
  }

  // printPTSAInfo(): optional helper to display PTSA summary
  public void printPTSAInfo() {
    System.out.println("\n--- PTSA Info ---");
    System.out.println("PTSA Name: " + name);
    System.out.println("Total Funds Raised: $" + totalFunds);
  }
}
