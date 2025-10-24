// Saanvi Shah
// 10/02/25
// P2
// This is making the Baker class

/*
 * DESCRIPTION: The Baker class represents the person who bakes cakes in the game. It uses the
 * Player object to get user input and can interact with the Store, Cake, and Customer.
 * INPUT: Player responses and orders from the game.
 *OUTPUT: Messages describing the baker’s actions, cake baking progress, and experience.
 * EDGE CASES: - Player doesn’t give valid input for cake type - Baker works without a store
 * assigned
 */

package edu.bhscs;

public class Baker {
  //  FIELDS AND PROPERTIES
  Player p; // the player interacting with the baker
  Flour f; // the flour used by the baker
  Store placeOfWork; // the bakery where the baker works
  int cash; // baker’s total cash on hand

  // CONSTRUCTOR
  Baker(Player p) {
    this.p = p;
  }

  // METHODS
  // This method allows the baker to take a cake order from a customer
  void takeOrder(int price, Customer c) {
    cash += c.pay(price);
    c.takeCake(bakeCake());
  }

  // This method lets the baker bake a cake using the player’s answer
  Cake bakeCake() {
    // Baking should be simulated by the baker without prompting the player directly here.
    // The main game flow constructs the Cake object (via Bakery.sellCake) and calls
    // baker.bakeCake() to simulate the action. For compatibility with other code that
    // expects a Cake return value, return a simple default cake using the baker's flour.
    // simulate baking without duplicating bakery messaging
    return new Cake("vanilla", this.f);
  }

  // This method lets the baker accept a job at a store
  void takeJob(Store bakery) {
    String doYouWantToWorkHere =
        this.p.giveAnswer("Do you want to work at " + bakery.getName() + "? (y/n)");
    if (doYouWantToWorkHere.equals("y")) {
      this.placeOfWork = bakery;
      System.out.println("The baker now works at " + bakery.getName() + "!");
    }
  }

  // ADDITIONS
  int experience = 0; // how many cakes the baker has baked
  boolean isCertified = false; // extra flavor from earlier assignment

  // Prints information about the baker
  public void printBakerInfo() {
    System.out.println("\n--- Baker Info ---");
    System.out.println("Experience: " + experience + " cakes baked.");
    System.out.println("Certified: " + (isCertified ? "Yes" : "No"));
    System.out.println("Cash on hand: $" + cash);
    if (placeOfWork != null) {
      System.out.println("Place of work: " + placeOfWork.getName());
    } else {
      System.out.println("Place of work: None yet.");
    }
  }

  // Helper method to increase experience after each cake baked
  public void gainExperience() {
    experience++;
    if (experience >= 3 && !isCertified) {
      isCertified = true;
      System.out.println("The baker has gained certification through experience!");
    }
  }
}
