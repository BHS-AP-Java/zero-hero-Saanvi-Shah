// Saanvi Shah
// 10/07/25
// P2
// This is making the CAKE class

/*
 * DESCRIPTION: The Cake class represents the cake that the bakery makes and sells. It holds details
 * about size, layers, flavor, frosting, and toppings. It can print either a plain cake or a fancy
 * decorated cake based on player choice.
 *
 * INPUT: size, layers, flavor, frosting, topping
 *
 * OUTPUT: A visual ASCII cake and a sentence describing what kind of cake it is.
 *
 * EDGE CASES: - Layers over 3 are capped at 3 - Missing or empty flavor/frosting/topping names
 */

package edu.bhscs;

public class Cake {

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
