// Saanvi Shah
// 10/11/25
// P2
// This is making the burger class!!!

package edu.bhscs;

public class Burger {
  // fields and properties
  String size;
  String bunType;
  int burgerWeight;
  boolean cheese;

  // constructors
  public Burger(String size, String bunType, int burgerWeight, boolean cheese) {
    this.size = size;
    this.bunType = bunType;
    this.cheese = cheese;
    this.burgerWeight = burgerWeight;
  }

  // methods
  public void showBurger() {
    System.out.println("\nHere is your burger:");
  }

  public void beEaten() {
    System.out.println("Nom nom nom! The burger is delicious!");
  }

  public void drawBurger() {
    // Top bun
    System.out.println("   ----");
    System.out.println("  /    \\");

    for (int i = 0; i < burgerWeight; i++) {
      System.out.println(" |~~~~~~|");
    }

    if (cheese) {
      System.out.println(" |[====]|");
    }

    // Bottom bun
    System.out.println("  \\    /");
    System.out.println("   ----");
  }
}
