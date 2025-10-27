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
  // Background colors for both cake and frosting (user requested backgrounds instead of
  // foregrounds)
  // Use 48;5;<n> for 256-color background where appropriate, and standard bg codes for others
  private static final String BROWN = "\u001B[48;5;130m"; // chocolate (background)
  private static final String WHITE = "\u001B[47m"; // vanilla (background white)
  private static final String RED = "\u001B[41m"; // strawberry (background red)
  private static final String YELLOW = "\u001B[43m"; // lemon (background yellow)
  private static final String PURPLE = "\u001B[45m"; // rhubarb (background magenta/purple)
  private static final String BLUE = "\u001B[44m"; // blueberry (background blue)
  // Special background color for candle flames
  private static final String ORANGE = "\u001B[48;5;208m"; // candle flames (background orange)

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

  // Prints a large ASCII cake/art supplied by the user
  public void printAsciiCakeArt() {
    // We'll render the original 3D ASCII cake as closely as possible by iterating
    // over a stored template of the original lines (minus the decorative star
    // block at the very top and minus the attribution text at the bottom).
    //
    // Coloring rules (per user):
    // - '@' characters => frosting color (use selected frosting)
    // - '*' and parentheses '(' and ')' => flame color (orange)
    // - '%' characters => cake stand (white)
    // - '|' characters => candle stems (white)
    // - spaces => printed as-is
    // - all other non-space characters => cake color (selected flavor)

    String cakeColor = getColorForFlavor();
    String frostingColor = getColorForFrosting();
    String white = WHITE;
    String orange = ORANGE;

    // Original art lines (trimmed: removed top decorative star block and removed
    // attribution lines like the artist name and website). We iterate this array
    // and print each character with the appropriate color mapping using nested
    // loops so it's programmatic (not a block of System.out.println calls).
    String[] art =
        new String[] {
          "                          (             )",
          "                  )      (*)           (*)      (",
          "         *       (*)      |             |      (*)",
          "                  |      |~|           |~|      |          *",
          "                 |~|     | |           | |     |~|",
          "                 | |     | |           | |     | |",
          "                ,| |a@@@@| |@@@@@@@@@@@| |@@@@a| |.",
          "           .,a@@@| |@@@@@| |@@@@@@@@@@@| |@@@@@| |@@@@a,.",
          "         ,a@@@@@@| |@@@@@@@@@@@@.@@@@@@@@@@@@@@| |@@@@@@@a,",
          "        a@@@@@@@@@@@@@@@@@@@@@' . `@@@@@@@@@@@@@@@@@@@@@@@@a",
          "        ;`@@@@@@@@@@@@@@@@@@'   .   `@@@@@@@@@@@@@@@@@@@@@';",
          "        ;@@@`@@@@@@@@@@@@@'     .     `@@@@@@@@@@@@@@@@'@@@;",
          "        ;@@@;,.aaaaaaaaaa       .       aaaaa,,aaaaaaa,;@@@;",
          "        ;;@;;;;@@@@@@@@;@      @.@      ;@@@;;;@@@@@@;;;;@@;",
          "        ;;;;;;;@@@@;@@;;@    @@ . @@    ;;@;;;;@@;@@@;;;;;;;",
          "        ;;;;;;;;@@;;;;;;;  @@   .   @@  ;;;;;;;;;;;@@;;;;@;;",
          "        ;;;;;;;;;;;;;;;;;@@     .     @@;;;;;;;;;;;;;;;;@@@;",
          "    ,%%%;;;;;;;;@;;;;;;;;       .       ;;;;;;;;;;;;;;;;@@;;%%%,",
          " .%%%%%%;;;;;;;@@;;;;;;;;     ,%%%,     ;;;;;;;;;;;;;;;;;;;;%%%%%%,",
          ".%%%%%%%;;;;;;;@@;;;;;;;;   ,%%%%%%%,   ;;;;;;;;;;;;;;;;;;;;%%%%%%%,",
          "%%%%%%%%`;;;;;;;;;;;;;;;;  %%%%%%%%%%%  ;;;;;;;;;;;;;;;;;;;'%%%%%%%%",
          "%%%%%%%%%%%%`;;;;;;;;;;;;,%%%%%%%%%%%%%,;;;;;;;;;;;;;;;'%%%%%%%%%%%%",
          "`%%%%%%%%%%%%%%%%%,,,,,,,%%%%%%%%%%%%%%%,,,,,,,%%%%%%%%%%%%%%%%%%%%'",
          "  `%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%'",
          "      `%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%'",
          "                            `%%%%%%%'",
          "                             `%%%%%'"
        };

    // Build the tricky quote/comma line programmatically to avoid literal-escaping
    // issues with many double quotes in a row.
    String quoteLine;
    {
      StringBuilder sb = new StringBuilder();
      sb.append("             ");
      for (int q = 0; q < 15; q++) sb.append('"');
      sb.append(",,,,,,,,,'");
      for (int q = 0; q < 15; q++) sb.append('"');
      quoteLine = sb.toString();
    }

    // Print all art lines except the last two, then print the constructed quote line,
    // then print the final two lines. This preserves the visual order near the bottom
    // while avoiding a problematic heavy-quote literal.
    int limit = Math.max(0, art.length - 2);
    for (int idx = 0; idx < limit; idx++) {
      String line = art[idx];
      for (int i = 0; i < line.length(); i++) {
        char ch = line.charAt(i);
        if (ch == ' ') {
          System.out.print(' ');
        } else if (ch == '@') {
          System.out.print(frostingColor + ch + RESET);
        } else if (ch == '*' || ch == '(' || ch == ')') {
          System.out.print(orange + ch + RESET);
        } else if (ch == '%' || ch == '`') {
          System.out.print(white + ch + RESET);
        } else if (ch == '|') {
          System.out.print(white + ch + RESET);
        } else {
          System.out.print(cakeColor + ch + RESET);
        }
      }
      System.out.println();
    }

    // print our constructed quote/comma line
    for (int i = 0; i < quoteLine.length(); i++) {
      char ch = quoteLine.charAt(i);
      if (ch == ' ') System.out.print(' ');
      else if (ch == '"') System.out.print(cakeColor + ch + RESET);
      else if (ch == ',') System.out.print(cakeColor + ch + RESET);
      else if (ch == '\'') System.out.print(cakeColor + ch + RESET);
      else System.out.print(cakeColor + ch + RESET);
    }
    System.out.println();

    // print the final two lines from the art array (if present)
    for (int idx = art.length - 2; idx < art.length; idx++) {
      if (idx < 0 || idx >= art.length) continue;
      String line = art[idx];
      for (int i = 0; i < line.length(); i++) {
        char ch = line.charAt(i);
        if (ch == ' ') {
          System.out.print(' ');
        } else if (ch == '@') {
          System.out.print(frostingColor + ch + RESET);
        } else if (ch == '*' || ch == '(' || ch == ')') {
          System.out.print(orange + ch + RESET);
        } else if (ch == '%' || ch == '`') {
          System.out.print(white + ch + RESET);
        } else if (ch == '|') {
          System.out.print(white + ch + RESET);
        } else {
          System.out.print(cakeColor + ch + RESET);
        }
      }
      System.out.println();
    }

    // End of art. No attribution or external links printed.
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

  // NOTE: plain (undecorated) cake display removed — decorated cakes are always used now.

  // showDecoratedCake() - prints the fancy decorated cake with loops
  // the design changes based on how many layers the cake has
  public void showDecoratedCake() {
    System.out.println("\nHere is your decorated cake:");

    if (layers == 1) {
      // 3D slice output suppressed per user request — no large ASCII art printed here.
      // If you want a small inline indicator, enable the line below.
      // System.out.println("[single-layer cake (art suppressed)]");
    } else if (layers == 2) {
      // 2-LAYER CAKE - Commented out for now
      /*
       * String frostingColor = getColorForFrosting(); // ... 2-layer cake art code removed ...
       */
      // 3D slice suppressed for multi-layer output as well.

    } else if (layers == 3) {
      // 3-LAYER CAKE - Commented out for now
      /*
       * int baseWidth = 35; int depth = 3; // ... 3-layer cake art code removed ...
       */
      // 3D slice suppressed for multi-layer output as well.
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
