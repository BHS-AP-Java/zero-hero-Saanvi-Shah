// Saanvi Shah
// 10/02/25
// P2
// This is making the Baker class

package edu.bhscs;

public class Baker {
  // FIELDS AND PROPERTIES
  String name;
  Player p;
  Flour f;
  Store placeOfWork;
  int cash;
  int experience = 0;
  boolean isCertified = false;

  // CONSTRUCTOR
  public Baker(String name) {
    this.name = name;
    this.f = new Flour("All-purpose flour", 5);
  }

  Baker(Player p) {
    this.p = p;
    this.f = new Flour("All-purpose flour", 5);
  }

  // METHODS
  Cake bakeCake(int cash, String name) {
    return new Cake("vanilla", this.f);
  }

  // NEW METHOD: Returns a Cake object for the assignment
  // This method creates a cake with the specified number of layers
  // and dedicates it to someone (the name parameter)
  public Cake bakes(int layers, String name) {
    System.out.println(this.name + " is baking a " + layers + "-layer cake for " + name + "!");
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