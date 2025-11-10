// Saanvi Shah
// 10/07/25
// P2
// This is making the CAKE class
// Modified on Nov 9th

package edu.bhscs;

public class Cake {
  // FIX #1: Add all the missing field declarations
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

  // UPDATED: draw(Table t) method - draws cake matching assignment requirements
  // Emphasizes loops as required by the assignment
  public void draw(Table t) {
    if (t == null) {
      System.out.println("Cannot draw cake - no table provided!");
      return;
    }

    int tableWidth = t.getWidth();

    // Cake components
    String candle = "|";
    String candleFlame = "\\*/";
    String frosting = "~";
    String cakeFilling = "#";
    String cakeSide = "|";

    // Calculate cake width (should be smaller than table width)
    int cakeWidth = 8; // Width of the cake filling part
    int offset = (tableWidth - cakeWidth) / 2;

    // 1. Draw candle (centered on cake)
    int candleOffset = (tableWidth - candle.length()) / 2;
    for (int i = 0; i < candleOffset; i++) {
      System.out.print(" ");
    }
    System.out.println(candle);

    // 2. Draw candle flame (centered)
    int flameOffset = (tableWidth - candleFlame.length()) / 2;
    for (int i = 0; i < flameOffset; i++) {
      System.out.print(" ");
    }
    System.out.println(candleFlame);

    // 3. Draw frosting line (wavy top of cake)
    for (int i = 0; i < offset; i++) {
      System.out.print(" ");
    }
    for (int i = 0; i < cakeWidth; i++) {
      System.out.print(frosting);
    }
    System.out.println();

    // 4. Draw cake layers (repeat based on this.layers)
    for (int layer = 0; layer < this.layers; layer++) {
      // Print offset spaces
      for (int i = 0; i < offset; i++) {
        System.out.print(" ");
      }

      // Print left side
      System.out.print(cakeSide);

      // Print filling
      for (int i = 0; i < cakeWidth - 2; i++) {
        System.out.print(cakeFilling);
      }

      // Print right side
      System.out.print(cakeSide);
      System.out.println();
    }

    // 5. Draw the table
    t.drawTable();

    // 6. Print cake info
    System.out.println("\nCake Info:");
    System.out.println("Flavor: " + this.flavor);
    System.out.println("Layers: " + this.layers);
  }
}
