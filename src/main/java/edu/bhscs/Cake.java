// Saanvi Shah
// 10/07/25
// P2
// This is making the CAKE class!!!

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
  // ANSI Color codes for different cake flavors and frostings
  private static final String RESET = "\u001B[0m";
  // Colors for both cake and frosting
  private static final String BROWN = "\u001B[38;5;130m"; // chocolate
  private static final String WHITE = "\u001B[37m"; // vanilla
  private static final String RED = "\u001B[31m"; // strawberry
  private static final String YELLOW = "\u001B[33m"; // lemon
  private static final String PURPLE = "\u001B[35m"; // rhubarb
  private static final String BLUE = "\u001B[34m"; // blueberry
  // Special color for candle flames
  private static final String ORANGE = "\u001B[38;5;208m"; // candle flames

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

  // Helper methods to get color codes for flavor and frosting
  private String getColorForFlavor() {
    switch (flavor.toLowerCase()) {
      case "chocolate":
        return BROWN;
      case "vanilla":
        return WHITE;
      case "strawberry":
        return RED;
      case "lemon":
        return YELLOW;
      case "rhubarb":
        return PURPLE;
      case "blueberry":
        return BLUE;
      default:
        return RESET;
    }
  }

  private String getColorForFrosting() {
    switch (frosting.toLowerCase()) {
      case "chocolate":
        return BROWN;
      case "vanilla":
        return WHITE;
      case "strawberry":
        return RED;
      case "lemon":
        return YELLOW;
      case "rhubarb":
        return PURPLE;
      case "blueberry":
        return BLUE;
      default:
        return WHITE;
    }
  }

  // showCake() - prints the simple plain cake using loops
  // this one is for when the player wants to see their basic cake order
  public void showCake() {
    System.out.println("\nHere is your cake:");

    // loop through each layer of the cake (top to bottom)
    for (int layer = 0; layer < layers; layer++) {
      // math: each layer gets 2 characters wider than the one above it
      // layer 0 = width 3, layer 1 = width 5, layer 2 = width 7
      int width = 3 + (layer * 2);

      // calculate leading spaces so cake is centered
      // top layer has most spaces, bottom has least
      int spaces = layers - layer - 1;

      // print the spaces to center this layer
      for (int s = 0; s < spaces; s++) {
        System.out.print(" ");
      }

      // print left border
      System.out.print("|");

      // print the underscores that make up the cake layer
      for (int w = 0; w < width; w++) {
        System.out.print("_");
      }

      // print right border and move to next line
      System.out.println("|");
    }

    // print description info using the cake's fields
    System.out.println("It is a " + size + " " + flavor + " cake.");
    System.out.println(
        "It has " + layers + " layer(s) and " + frosting + " frosting with " + topping + ".");
    System.out.println("Made with " + flour.quantity + " pounds of " + flour.name + ".");
  }

  // showDecoratedCake() - prints the fancy decorated cake with loops
  // the design changes based on how many layers the cake has
  public void showDecoratedCake() {
    System.out.println("\nHere is your decorated cake:");

    if (layers == 1) {
      // 1-LAYER CAKE - small and simple with decorative borders
      System.out.println("             ");

      String frostingColor = getColorForFrosting();

      // top border - uses a loop to print 9 vertical bar characters
      System.out.print("  ╭" + frostingColor);
      for (int i = 0; i < 9; i++) {
        System.out.print("┻");
      }
      System.out.println(RESET + "╮");

      // frosting pattern - loops to make the zigzag design
      System.out.print("  ┃" + frostingColor);
      for (int i = 0; i < 4; i++) {
        System.out.print("╱╲");
      }
      System.out.print("╱");
      System.out.print(RESET + "┃");
      System.out.println();

      // bottom border - loops to print the line
      System.out.print("  ┻" + frostingColor);
      for (int i = 0; i < 9; i++) {
        System.out.print("━");
      }
      System.out.println(RESET + "┻");
      System.out.println("   ");
      System.out.println("   ");

    } else if (layers == 2) {
      // 2-LAYER CAKE - medium size with stars on top
      String frostingColor = getColorForFrosting();

      // print stars across the top using a loop (stars are orange like candle flames)
      System.out.print("   ");
      for (int i = 0; i < 8; i++) {
        System.out.print(ORANGE + "☆" + RESET);
      }
      System.out.println();

      // top layer border
      System.out.print("  ╭" + frostingColor);
      for (int i = 0; i < 9; i++) {
        System.out.print("┻");
      }
      System.out.println(RESET + "╮");

      // top layer zigzag frosting pattern
      System.out.print("  ┃" + frostingColor);
      for (int i = 0; i < 4; i++) {
        System.out.print("╱╲");
      }
      System.out.print("╱");
      System.out.println(RESET + "┃");

      // middle divider between the two layers
      System.out.print(" ╭┻" + frostingColor);
      for (int i = 0; i < 9; i++) {
        System.out.print("━");
      }
      System.out.println(RESET + "┻╮");

      // bottom layer frosting pattern (slightly wider)
      System.out.print(" ┃" + frostingColor);
      for (int i = 0; i < 5; i++) {
        System.out.print("╱╲");
      }
      System.out.print("╱");
      System.out.println(RESET + "┃");

      // bottom border
      System.out.print(" ┗" + frostingColor);
      for (int i = 0; i < 11; i++) {
        System.out.print("━");
      }
      System.out.println(RESET + "┛");
      System.out.println("   ");
      System.out.println("   ");

    } else if (layers == 3) {
      // 3-LAYER BIRTHDAY CAKE - the biggest and fanciest!
      // this one has candles and "Happy Birthday" text

      int baseWidth = 35; // width of the bottom layer
      int depth = 3; // how many rows to use for 3D effect

      // candles on top (these are decorative)
      System.out.print("                 " + ORANGE + "0" + WHITE + "   " + ORANGE + "0" + RESET + "\n");
      System.out.println("                 |   |");

      // top layer roof - print underscores
      System.out.print("             ");
      for (int i = 0; i < 13; i++) {
        System.out.print("_");
      }
      System.out.println();

      // top layer with some depth - loop adds multiple rows
      for (int d = 0; d < depth; d++) {
        System.out.print("          " + ORANGE + "0" + RESET + "  |");
        // middle row is empty, others have wavy pattern
        for (int i = 0; i < 11; i++) {
          System.out.print(d == 1 ? " " : "~");
        }
        System.out.println("|   " + ORANGE + "0" + RESET);

        // add spacing between depth rows (except last one)
        if (d < depth - 1) {
          System.out.println("          |  |           |   |");
        }
      }

      // middle layer top border
      System.out.print("       ");
      for (int i = 0; i < 23; i++) {
        System.out.print("_");
      }
      System.out.println();

      // middle layer zigzag pattern
      System.out.print("       |");
      for (int i = 0; i < 21; i++) {
        // alternate between forward and back slashes
        if (i % 2 == 0) System.out.print("/");
        else System.out.print("\\");
      }
      System.out.println("|");

      // middle layer with "Happy" text
      System.out.print("   " + ORANGE + "0" + RESET + "   |       ");
      char[] happy = "H a p p y".toCharArray();
      for (char c : happy) {
        System.out.print(c);
      }
      System.out.println("       |   " + ORANGE + "0" + RESET);

      // middle layer bottom zigzag
      System.out.print("   |   |");
      for (int i = 0; i < 21; i++) {
        if (i % 2 == 0) System.out.print("/");
        else System.out.print("\\");
      }
      System.out.println("|   |");

      // bottom layer top border (widest part)
      System.out.print("  ");
      for (int i = 0; i < baseWidth; i++) {
        System.out.print("_");
      }
      System.out.println();

      // bottom layer top zigzag decoration
      System.out.print(" |");
      for (int i = 0; i < baseWidth - 2; i++) {
        if (i % 2 == 0) System.out.print("/");
        else System.out.print("\\");
      }
      System.out.println("|");

      // empty row in bottom layer
      System.out.print(" |");
      for (int i = 0; i < baseWidth - 2; i++) {
        System.out.print(" ");
      }
      System.out.println("|");

      // "Birthday!!!" text in the bottom layer
      System.out.print(" |         ");
      char[] bday = "B i r t h d a y! ! !".toCharArray();
      for (char c : bday) {
        System.out.print(c);
      }
      System.out.println("      |");

      // wavy decoration line near the bottom
      System.out.print(" | ");
      for (int i = 0; i < baseWidth - 4; i++) {
        // alternate waves and spaces
        if (i % 2 == 0) System.out.print("~");
        else System.out.print(" ");
      }
      System.out.println(" |");

      // final bottom border
      System.out.print(" |");
      for (int i = 0; i < baseWidth - 2; i++) {
        System.out.print("_");
      }
      System.out.println("|");
      System.out.println("   ");
      System.out.println("   ");
    }

    // extra layer indicators at the bottom - nested loops!!
    // outer loop = how many layer groups to print
    // inner loops = print the actual patterns
    String cakeColor = getColorForFlavor();
    String frostingColor = getColorForFrosting();
    for (int i = 0; i < layers; i++) {
      // print wavy frosting line
      System.out.print(" |" + frostingColor);
      for (int j = 0; j < 18; j++) {
        System.out.print("~");
      }
      System.out.print(RESET + "|");
      System.out.println();

      // print cake texture lines (number depends on layers)
      for (int j = 0; j < layers; j++) {
        System.out.print(" |" + cakeColor);
        for (int k = 0; k < 18; k++) {
          System.out.print("=");
        }
        System.out.print(RESET + "|");
        System.out.println();
      }
    }
  }

  // drawCake3D() - draws a 3D isometric cake slice using only loops!
  // this shows all three faces: top, front, and right side
  public static void drawCake3D() {
    int height = 8; // how tall the cake slice is
    int width = 16; // width of the front face at the base
    int depth = 6; // how deep the 3D effect goes

    // STEP 1: draw the top frosting layer (top face of the slice)
    // this creates a tapered effect - gets narrower as it goes back
    for (int i = 0; i < depth; i++) {
      // leading spaces create the 3D perspective
      for (int s = 0; s < i; s++) {
        System.out.print(" ");
      }

      // calculate how wide this line should be
      // math: each row back loses 2 characters of width
      int lineWidth = width - (i * 2);

      // left edge of frosting
      System.out.print("/");

      // wavy frosting texture
      for (int w = 0; w < lineWidth; w++) {
        System.out.print("~");
      }

      // right edge and newline
      System.out.println("\\");
    }

    // STEP 2: draw the main cake body (shows three faces!)
    // each row shows: front face + right side
    for (int row = 0; row < height; row++) {
      // spaces to offset for 3D perspective
      for (int s = 0; s < depth; s++) {
        System.out.print(" ");
      }

      // left border of front face
      System.out.print("|");

      // FRONT FACE: alternate between frosting layers and cake texture
      for (int col = 0; col < width - (depth * 2); col++) {
        // every 3rd row is a frosting layer
        if (row % 3 == 0) {
          System.out.print("="); // frosting
        } else {
          System.out.print("#"); // cake
        }
      }

      // right border of front face
      System.out.print("|");

      // RIGHT SIDE FACE: shows the depth of the slice
      for (int d = 0; d < depth; d++) {
        System.out.print("/"); // slashes show the angled side
      }

      System.out.println();
    }

    // STEP 3: draw the bottom edge (base of the slice)
    // this closes off the bottom of the cake
    for (int s = 0; s < depth; s++) {
      System.out.print(" ");
    }

    // bottom front edge with underscores
    System.out.print("\\");
    for (int i = 0; i < width - (depth * 2); i++) {
      System.out.print("_");
    }
    System.out.print("/");

    System.out.println();
  }
}
