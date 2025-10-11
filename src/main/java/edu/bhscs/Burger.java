// Saanvi Shah
// 10/11/25
// P2
// This is making the burger class!!!

/*
 * DESCRIPTION: The Burger class represents the burger that the restaurant makes and sells. It holds
 * details about size, bun type, weight, and cheese. It can print an ASCII burger using a loop for
 * the patty layers.
 *
 * INPUT: size, bunType, burgerWeight, cheese
 *
 * OUTPUT: A visual ASCII burger and descriptions of the burger.
 *
 * EDGE CASES: - Different burger sizes - With or without cheese
 */

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

    // Patty layers using a loop - minimal keystrokes version
    for (int i = 0; i < burgerWeight; i++) {
      System.out.println(" |~~~~~~|");
    }

    // Cheese layer if applicable
    if (cheese) {
      System.out.println(" |[====]|");
    }

    // Bottom bun
    System.out.println("  \\    /");
    System.out.println("   ----");
  }
}
