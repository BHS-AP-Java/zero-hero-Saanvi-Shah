// Saanvi Shah
// 10/07/25
// P2
// This is making the Bakery class

/*
 * DESCRIPTION: The Bakery class represents the shop that sells cakes. It has a name and can make
 * and sell Cake objects when requested. The Bakery is where the Baker works and where the Player
 * orders their cakes.
 *
 * INPUT: Cake details (like layers, flavor, frosting, toppings)
 *
 * OUTPUT: A message saying the bakery is preparing the cake
 *
 * EDGE CASES: - Invalid cake options - Zero or negative layers
 */

package edu.bhscs;

public class Bakery {
  // FIELDS AND PROPERTIES
  String name; // name of the bakery

  // CONSTRUCTOR
  public Bakery(String name) {
    this.name = name;
  }

  // METHODS

  // getName(): returns the bakery name
  public String getName() {
    return name;
  }

  // sellCake(): creates and returns a new cake with the given specifications
  public Cake sellCake(String size, int layers, String flavor, String frosting, String topping) {
    System.out.println(name + " is preparing your cake...");
    return new Cake(size, layers, flavor, frosting, topping);
  }
}
