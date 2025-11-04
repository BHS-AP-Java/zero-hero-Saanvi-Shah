// Saanvi Shah
// 10/07/25
// P2
// This is making the Flour class

package edu.bhscs;

public class Flour {
  // FIELDS AND PROPERTIES
  String name = "All-purpose flour";
  int quantity = 5;
  int price = 3;
  int quality = 8;

  // CONSTRUCTOR
  public Flour(String name, int weight) {
    this.name = name;
    this.quantity = weight;
  }

  // METHODS
  public void goesBad() {
    System.out.println("The flour is expired and cannot be used anymore!");
    this.quality = 0;
  }

  public void printFlourInfo() {
    System.out.println("\n--- Flour Info ---");
    System.out.println("Type: " + name);
    System.out.println("Quantity: " + quantity + " lbs");
    System.out.println("Price per bag: $" + price);
    System.out.println("Quality: " + quality + "/10");
  }
}
