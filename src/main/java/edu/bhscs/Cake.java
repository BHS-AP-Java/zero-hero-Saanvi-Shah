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

  // UPDATED: draw(Offsetable below) - new signature per assignment
  // Uses the default getOffset() method from Offsetable interface
  public void draw(Offsetable below) {
    // Calculate offset using the default method
    int offset = this.getOffset(below);

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

    // If there's something below, draw it
    if (below != null) {
      below.draw(null); // Draw the thing below with no offset
    }
  }
}