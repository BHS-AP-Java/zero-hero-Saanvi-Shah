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

  public draw(Table t) {


    int offset = (tableWidth - cakeWidth) /2;


    if (t == null) return (t);
    int legs = t.legs;
    int w = t.width;

    if (legs < 4) legs = 4;
    if (w < 7) w = 7;

    int[] pos = new int[4];
    for (int i = 0; i < 4; i++) {
      pos[i] = 1 + (int) Math.round(i * (double) (w - 3) / 3.0);
    }
  }
}
