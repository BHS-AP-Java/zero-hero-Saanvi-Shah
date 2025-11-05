// Saanvi Shah
// 10/07/25
// P2
// This is making the CAKE class

package edu.bhscs;

public class Cake {
  // ANSI Color codes for different cake flavors and frostings
  private static final String RESET = "\u001B[0m";
  private static final String BROWN = "\u001B[48;5;130m";
  private static final String WHITE = "\u001B[47m";
  private static final String RED = "\u001B[41m";
  private static final String YELLOW = "\u001B[43m";
  private static final String PURPLE = "\u001B[45m";
  private static final String BLUE = "\u001B[44m";
  private static final String ORANGE = "\u001B[48;5;208m";

  // FIELDS AND PROPERTIES
  String size;
  int layers;
  String flavor;
  String frosting;
  String topping;
  Flour flour;

  // Cake dimensions - these control how big the cake looks in ASCII art
  int cakeWidth;
  int cakeHeight;

  // CONSTRUCTOR
  public Cake(String size, int layers, String flavor, String frosting, String topping) {
    this.size = size;
    this.layers = Math.min(layers, 3);
    this.flavor = flavor;
    this.frosting = frosting;
    this.topping = topping;
    this.flour = new Flour("All-purpose flour", 5);

    // Set the cake's physical size for ASCII art
    this.cakeWidth = 9; // Change this to make the cake wider/narrower
    this.cakeHeight = 3; // Change this to make the cake taller/shorter
  }

  // Alternate constructor
  public Cake(String flavor, Flour f) {
    this.size = "medium";
    this.layers = 1;
    this.flavor = flavor;
    this.frosting = "buttercream";
    this.topping = "sprinkles";
    this.flour = f;

    // Set default cake size
    this.cakeWidth = 9;
    this.cakeHeight = 3;
  }

  // METHODS
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

  // METHOD: Draw the cake centered on top of a table
  public void draw(Table t) {
    if (t == null) {
      System.out.println("No table provided!");
      return;
    }

    System.out.println("\n");

    // Calculate offset to center the cake on the table
    int offset = (t.getWidth() - cakeWidth) / 2;

    // Draw the cake
    drawCakeWithOffset(offset);

    // Draw the table
    t.drawTable();
  }

  // Helper method to draw the cake with proper offset
  private void drawCakeWithOffset(int offset) {
    // Top of cake: candle
    for (int i = -4; i < offset + (cakeWidth / 2); i++) {
      System.out.print(" ");
    }
    System.out.println("|");

    // Candle flame
    for (int i = -4; i < offset + (cakeWidth / 2) - 1; i++) {
      System.out.print(" ");
    }
    System.out.println("\\*/");

    // Top frosting layer
    for (int i = -4; i < offset; i++) {
      System.out.print(" ");
    }
    System.out.print(" ");
    for (int i = 0; i < cakeWidth - 2; i++) {
      System.out.print("~");
    }
    System.out.println(" ");

    // Cake body
    drawCakeBody(offset);
  }

  public void printAsciiCakeArt() {
    String cakeColor = getColorForFlavor();
    String frostingColor = getColorForFrosting();
    String white = WHITE;
    String orange = ORANGE;

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

    String quoteLine;
    {
      StringBuilder sb = new StringBuilder();
      sb.append("             ");
      for (int q = 0; q < 15; q++) sb.append('"');
      sb.append(",,,,,,,,,'");
      for (int q = 0; q < 15; q++) sb.append('"');
      quoteLine = sb.toString();
    }
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
    for (int i = 0; i < quoteLine.length(); i++) {
      char ch = quoteLine.charAt(i);
      if (ch == ' ') System.out.print(' ');
      else if (ch == '"') System.out.print(cakeColor + ch + RESET);
      else if (ch == ',') System.out.print(cakeColor + ch + RESET);
      else if (ch == '\'') System.out.print(cakeColor + ch + RESET);
      else System.out.print(cakeColor + ch + RESET);
    }
    System.out.println();
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
  }

  public void showDecoratedCake() {
    System.out.println("\nHere is your decorated cake:");

    if (layers == 1) {
    } else if (layers == 2) {
    } else if (layers == 3) {
    }
  }

  // Draw just the cake with specified dimensions
  public void drawCake() {
    drawCakeWithOffset(0);
  }

  // Helper method to draw the cake body with proper offset
  private void drawCakeBody(int offset) {
    // Body of the cake
    for (int row = 0; row < cakeHeight; row++) {
      // Add offset spaces to center the cake
      for (int i = -4; i < offset; i++) {
        System.out.print(" ");
      }

      // Draw the cake body
      System.out.print("|");
      for (int col = 0; col < cakeWidth - 2; col++) {
        if (row % 3 == 0) {
          System.out.print("="); // Decorative layer
        } else {
          System.out.print("#");
        }
      }
      System.out.println("|");
    }
  }

  // Method to set cake dimensions
  public void setCakeDimensions(int width, int height) {
    this.cakeWidth = Math.max(3, width); // Minimum width of 3
    this.cakeHeight = Math.max(2, height); // Minimum height of 2
  }
}
