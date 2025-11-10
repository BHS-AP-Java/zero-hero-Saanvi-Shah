// Saanvi Shah
// 10/07/25
// P2
// This is making the CAKE class

package edu.bhscs;

public class Cake {
  // Add field declarations

  String size;
  int layers;
  String flavor;
  String frosting;
  String topping;
  Flour flour;

  public Cake(String flavor, Flour f) {
    this.size = "medium";
    this.layers = 1;
    this.flavor = flavor;
    this.frosting = "buttercream";
    this.topping = "sprinkles";
    this.flour = f;
  }

  public void draw(Table t) {

    if (t == null) {
      System.out.println("Cannot draw cake - no table provided!");
      return;
    }

    int legs = t.getLegs();
    int tableWidth = t.getWidth();

    if (legs < 4) legs = 4;
    if (tableWidth < 7) tableWidth = 7;

    // int offset = (tableWidth - cakeWidth) / 2;

    // Then draw the cake on top (centered)
    System.out.println("\n🎂 Cake placed on table!");
    System.out.println("Flavor: " + this.flavor);
    System.out.println("Layers: " + this.layers);
  }
}
