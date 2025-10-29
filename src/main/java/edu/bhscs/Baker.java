// Saanvi Shah
// 10/02/25
// P2
// This is making the Baker class

/*
 * DESCRIPTION: The Baker class represents the person who bakes cakes in the game. It uses the
 * Player object to get user input and can interact with the Store, Cake, and Customer. INPUT:
 * Player responses and orders from the game. OUTPUT: Messages describing the baker’s actions, cake
 * baking progress, and experience. EDGE CASES: - Player doesn’t give valid input for cake type -
 * Baker works without a store assigned
 */

package edu.bhscs;

public class Baker {
  // FIELDS AND PROPERTIES
  String name;
  Player p;
  Flour f;
  Store placeOfWork;
  int cash;

  // CONSTRUCTOR
  public Baker(String name) {
    this.name = name;
  }

  Baker(Player p) {
    this.p = p;
  }

  // METHODS
  Cake bakeCake(int cash, String name) {
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

  public static void bakes(int cash, String name) {}

  // ADDITIONS
  int experience = 0;
  boolean isCertified = false;

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
