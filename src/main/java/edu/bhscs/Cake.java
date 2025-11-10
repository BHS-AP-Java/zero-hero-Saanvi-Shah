// Saanvi Shah
// 10/07/25
// P2
// This is making the CAKE class

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

  // UPDATED: draw(Table t) method - handles both positive and negative offsets
  // Checks if table is bigger or cake is bigger
  public void draw(Table t) {
    if (t == null) {
      System.out.println("Cannot draw cake - no table provided!");
      return;
    }

    int tableWidth = t.getWidth();
    int cakeWidth = this.getWidth();

    // Calculate offset (difference between widths)
    int offset = (tableWidth - cakeWidth) / 2;

    // ASSIGNMENT REQUIREMENT: Check if offset is positive or negative
    if (offset < 0) {
      // Table is smaller than cake - center the TABLE under the cake
      System.out.println("⚠️ Table is smaller than cake!");

      // Draw cake with no offset (at left edge)
      this.drawWithOffset(0);

      // Draw table centered under the cake
      int tableOffset = -offset; // Make it positive for table
      t.drawWithOffset(tableOffset);

    } else {
      // Table is bigger than or equal to cake - center the CAKE on the table

      // Draw cake centered on table
      this.drawWithOffset(offset);

      // Draw table with no offset
      t.drawWithOffset(0);
    }

    // Print cake info
    System.out.println("\nCake Info:");
    System.out.println("Flavor: " + this.flavor);
    System.out.println("Layers: " + this.layers);
    System.out.println("Cake width: " + cakeWidth + ", Table width: " + tableWidth);
  }
}
