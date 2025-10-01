// Saanvi Shah
// 10/1/25
// P2
// This is making the PSTA class

// DESCRIPTION: Creating a PTSA that gets money for
// every cake sold because they are doing a fundraiser
// INPUT:
// OUTPUT:
// EDGE CASE:
//

package edu.bhscs;

public class PTSA {

  // Fields and properties

  String name; // the name of the PTSA
  int totalFunds; // total funds raised

  // Constructor: makes a new PTSA
  public PTSA(String name) {
    this.name = name;
    this.totalFunds = 0;
  }

  // Method: the PTSA gets a donation for each cake sold
  public void receiveDonation(int amount) {
    totalFunds += amount;
    System.out.println(
        name + " PTSA received a donation of $" + amount + ". Total funds: $" + totalFunds);
  }
}
