// Saanvi Shah
// 10/07/25
// P2
// This is making the CAKE class

package edu.bhscs;

public class Cake implements Offsetable {
  // FIELDS - Declare all properties at the top
  String size;
  int layers;
  String flavor;
  String frosting;
  String topping;
  Flour flour;
  int width; // NEW: width of the cake in characters

  public Cake(String flavor, Flour f) {
    this.size = "medium";
    this.layers = 1;
    this.flavor = flavor;
    this.frosting = "buttercream";
    this.topping = "sprinkles";
    this.flour = f;
    this.width = 10; // Default cake width
  }

  // NEW: Implement getWidth() from Offsetable interface
  public int getWidth() {
    return this.width;
  }

  // NEW: Implement drawWithOffset() from Offsetable interface
  public void drawWithOffset(int offset) {
    String candle = "|";
    String candleFlame = "\\*/";
    String frosting = "~";
    String cakeFilling = "#";
    String cakeSide = "|";

    int cakeWidth = this.width;

    // 1. Draw candle (with offset)
    for (int i = 0; i < offset + (cakeWidth / 2); i++) {
      System.out.print(" ");
    }
    System.out.println(candle);

    // 2. Draw candle flame (with offset)
    for (int i = 0; i < offset + (cakeWidth / 2) - 1; i++) {
      System.out.print(" ");
    }
    System.out.println(candleFlame);

    // 3. Draw frosting line
    for (int i = 0; i < offset; i++) {
      System.out.print(" ");
    }
    for (int i = 0; i < cakeWidth; i++) {
      System.out.print(frosting);
    }
    System.out.println();

    // 4. Draw cake layers
    for (int layer = 0; layer < this.layers; layer++) {
      for (int i = 0; i < offset; i++) {
        System.out.print(" ");
      }
      System.out.print(cakeSide);
      for (int i = 0; i < cakeWidth - 2; i++) {
        System.out.print(cakeFilling);
      }
      System.out.print(cakeSide);
      System.out.println();
    }
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
