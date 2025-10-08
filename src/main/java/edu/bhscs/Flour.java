// Saanvi Shah
// 10/07/25
// P2
// This is making the Flour class

/*
 * DESCRIPTION: The Flour class represents one of the main ingredients used to bake cakes. Every
 * cake uses some amount of flour, and this class can track its quality, quantity, and type.
 *
 * INPUT: name (type of flour), weight (quantity in pounds)
 *
 * OUTPUT: A message if the flour goes bad (quality becomes 0)
 *
 * EDGE CASES: - Negative or zero weight (handled by setting minimum quality to 0) - Expired flour
 * (quality = 0)
 */

package edu.bhscs;

public class Flour {
  // ---------------- FIELDS AND PROPERTIES ----------------
  String name = "All-purpose flour"; // the type of flour
  int quantity = 5; // in pounds
  int price = 3; // price per bag in dollars
  int quality = 8; // quality on a scale of 1–10

  // ---------------- CONSTRUCTOR ----------------
  public Flour(String name, int weight) {
    this.name = name;
    this.quantity = weight;
  }

  // ---------------- METHODS ----------------
  // goesBad(): called when the flour is expired or too old to use
  public void goesBad() {
    System.out.println("The flour is expired and cannot be used anymore!");
    this.quality = 0;
  }

  // printFlourInfo(): prints details about this flour
  public void printFlourInfo() {
    System.out.println("\n--- Flour Info ---");
    System.out.println("Type: " + name);
    System.out.println("Quantity: " + quantity + " lbs");
    System.out.println("Price per bag: $" + price);
    System.out.println("Quality: " + quality + "/10");
  }
}
