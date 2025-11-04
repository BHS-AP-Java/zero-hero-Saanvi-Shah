// Saanvi Shah
// 10/07/25
// P2
// This is making the Bakery class

package edu.bhscs;

public class Bakery {
  // FIELDS AND PROPERTIES
  String name;

  // CONSTRUCTOR
  public Bakery(String name) {
    this.name = name;
  }

  // METHODS
  public String getName() {
    return name;
  }

  public Cake sellCake(String size, int layers, String flavor, String frosting, String topping) {
    System.out.println(name + " is preparing your cake...");
    return new Cake(size, layers, flavor, frosting, topping);
  }
}
