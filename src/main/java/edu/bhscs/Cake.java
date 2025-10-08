// Saanvi Shah
// 10/07/25
// P2
// This is making the CAKE class!!!

/*
 * DESCRIPTION:
 * The Cake class represents the cake that the bakery makes and sells.
 * It holds details about size, layers, flavor, frosting, and toppings.
 * It can print either a plain cake or a fancy decorated cake based on player choice.
 *
 * INPUT:
 * size, layers, flavor, frosting, topping
 *
 * OUTPUT:
 * A visual ASCII cake and a sentence describing what kind of cake it is.
 *
 * EDGE CASES:
 * - Layers over 3 are capped at 3
 * - Missing or empty flavor/frosting/topping names
 */

package edu.bhscs;

public class Cake {
  // FIELDS AND PROPERTIES
  String size;
  int layers;
  String flavor;
  String frosting;
  String topping;
  Flour flour;

  // CONSTRUCTOR
  public Cake(String size, int layers, String flavor, String frosting, String topping) {
    this.size = size;
    this.layers = Math.min(layers, 3);
    this.flavor = flavor;
    this.frosting = frosting;
    this.topping = topping;
    this.flour = new Flour("All-purpose flour", 5);
  }

  // Alternate constructor
  public Cake(String flavor, Flour f) {
    this.size = "medium";
    this.layers = 1;
    this.flavor = flavor;
    this.frosting = "buttercream";
    this.topping = "sprinkles";
    this.flour = f;
  }

  // METHODS

  // Prints the plain cake (non-decorated)
  public void showCake() {
    System.out.println("\nHere is your cake:");

    if (layers == 1) {
      System.out.println("   |___|");
    } else if (layers == 2) {
      System.out.println("   |___|");
      System.out.println("  |_____|");
    } else if (layers == 3) {
      System.out.println("   |___|");
      System.out.println("  |_____|");
      System.out.println(" |_______|");
    }

    System.out.println("It is a " + size + " " + flavor + " cake.");
    System.out.println(
        "It has " + layers + " layer(s) and " + frosting + " frosting with " + topping + ".");
    System.out.println("Made with " + flour.quantity + " pounds of " + flour.name + ".");
  }

  // Prints the decorated cake (fancy version depending on layer count)
  public void showDecoratedCake() {
    System.out.println("\nHere is your decorated cake:");

    if (layers == 1) {
      // 🎂 1-LAYER DECORATED CAKE

      System.out.println("  ╭┻┻┻┻┻┻┻┻┻╮ ");
      System.out.println("  ┃╱╲╱╲╱╲╱╲╱┃ ");
      System.out.println("  ┻━━━━━━━━━┻ ");

    } else if (layers == 2) {
      // 🎂 2-LAYER DECORATED CAKE
      System.out.println("   ☆☆☆☆☆☆☆     ");
      System.out.println("  ╭┻┻┻┻┻┻┻┻┻╮   ");
      System.out.println("  ┃╱╲╱╲╱╲╱╲╱┃   ");
      System.out.println(" ╭┻━━━━━━━━━┻╮ ");
      System.out.println(" ┃╱╲╱╲╱╲╱╲╱╲╱┃   ");
      System.out.println(" ┗━━━━━━━━━━━┛  ");
      System.out.println(" ");
      System.out.println(" ");
      System.out.println("");
    } else if (layers == 3) {
      // 🎂 3-LAYER DECORATED CAKE
      System.out.println("        i   i   i");
      System.out.println("       |   |   |");
      System.out.println("     ___|___|___|___");
      System.out.println("    |~~~~~~~~~~~~~~~|");
      System.out.println("    |               |");
      System.out.println("  ___|_______________|___");
      System.out.println(" |~~~~~~~~~~~~~~~~~~~~~~~|");
      System.out.println(" |                       |");
      System.out.println("__|_______________________|__");
      System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
      System.out.println("|___________________________|");
      System.out.println(" * Triple-tier masterpiece *");
    }

    System.out.println("\nThis decorated cake is a " + flavor + " flavor cake!");
    System.out.println("It has " + frosting + " frosting and " + topping + " on top!");
    System.out.println("It is made with " + flour.quantity + " pounds of " + flour.name + ".");
  }
}
