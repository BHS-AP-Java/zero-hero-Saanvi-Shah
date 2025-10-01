// Saanvi Shah
// 9/30/25
// P2
// This is making the CAKE class!!!

// DESCRIPTION: Creating a cake that has size, layers, flavor, frosting, and grosting
// INPUT: size, layers, flavor, frosting, grosting
// OUTPUT: A line saying the cake is being shown
// EDGE CASE: None
//

package edu.bhscs;

// This file is only for my Cake class..
// A Cake is an object that has details like size, layers, flavor, frosting, and grosting
// (decorations).
// I also made it so the Cake knows how to "draw itself" in the terminal.

public class Cake {
  // These are the properties (aka variables) that describe my Cake.
  String size; // how big the cake is (small, medium, large)
  int layers; // how many layers (1-3 only)
  String flavor; // chocolate, vanilla, strawberry
  String frosting; // buttercream, whipped cream, fondant
  String grosting; // decorations like sprinkles, cherries, candles
  Flour flour; // a Cake "has a" Flour

  // This is the constructor.
  // like a blueprint step that tells Java how to build a Cake object
  // when I use "new Cake(...)"
  public Cake(String size, int layers, String flavor, String frosting, String grosting) {
    this.size = size; // "this" just means I’m talking about THIS cake’s size
    this.layers = Math.min(layers, 3); // I force layers to never go over 3
    this.flavor = flavor;
    this.frosting = frosting;
    this.grosting = grosting;
    this.flour = new Flour("All-purpose flour", 5); // Every cake "has a" Flour
  }

  // This method (function inside a class) prints the cake to the terminal.
  // It uses the number of layers to decide how to "draw" the pyramid cake.
  public void showCake() {
    System.out.println("\nHere is your cake:");

    // If the cake only has 1 layer
    if (layers == 1) {
      System.out.println("   |___|");
    }
    // If the cake has 2 layers
    else if (layers == 2) {
      System.out.println("   |___|");
      System.out.println("  |_____|");
    }
    // If the cake has 3 layers
    else if (layers == 3) {
      System.out.println("   |___|");
      System.out.println("  |_____|");
      System.out.println(" |_______|");
    }

    // This line explains the details of the cake in plain English
    System.out.println(
        "It is a "
            + size
            + " "
            + flavor
            + " cake with "
            + frosting
            + " frosting and "
            + grosting
            + "."
            + " It is made with "
            + flour.quantity
            + " pounds of "
            + flour.name
            + ".");
  }
}
