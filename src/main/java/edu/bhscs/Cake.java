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

    // Get table info
    int tableWidth = t.getWidth();
    int tableLegs = t.getLegs();
    int tableHeight = 4; // How tall the legs are

    System.out.println("\n");

    int offset = (tableWidth - cakeWidth) / 2;

    // Top of cake: candle
    for (int i = 0; i < offset + (cakeWidth / 2); i++) {
      System.out.print(" ");
    }
    System.out.println("|");

    // Candle flame
    for (int i = 0; i < offset + (cakeWidth / 2) - 1; i++) {
      System.out.print(" ");
    }
    System.out.println("\\*/");

    // Top frosting layer of the cake
    for (int i = 0; i < offset; i++) {
      System.out.print(" ");
    }
    System.out.print(" ");
    for (int i = 0; i < cakeWidth - 2; i++) {
      System.out.print("~");
    }
    System.out.println(" ");

    // Body of the cake - using a LOOP based on cakeHeight!
    // Change cakeHeight in the constructor to make the cake taller or shorter
    for (int row = 0; row < cakeHeight; row++) {
      // Add offset spaces to center the cake
      for (int i = 0; i < offset; i++) {
        System.out.print(" ");
      }

      // Draw the cake body
      System.out.print("|");
      for (int col = 0; col < cakeWidth - 2; col++) {
        System.out.print("#");
      }
      System.out.println("|");
    }

    // STEP 2: Draw the table top (independent of cake!)
    // This loop makes the table top using the table's width
    for (int i = 0; i < tableWidth; i++) {
      System.out.print("=");
    }
    System.out.println();

    // STEP 3: Draw the table legs using the FENCEPOST PROBLEM
    // Fencepost problem: N legs means N-1 gaps between them
    // We need to evenly space the legs across the table width

    for (int row = 0; row < tableHeight; row++) {
      // For each row of the table legs...

      for (int legNum = 0; legNum < tableLegs; legNum++) {
        // Calculate where THIS leg should be positioned
        // This formula solves the fencepost problem!
        int legPosition;
        if (tableLegs == 1) {
          // Special case: one leg goes in the middle
          legPosition = tableWidth / 2;
        } else {
          // Evenly space the legs from position 0 to position (width-1)
          legPosition = legNum * (tableWidth - 1) / (tableLegs - 1);
        }

        // Print spaces until we reach this leg's position
        if (legNum == 0) {
          // First leg: print spaces from the start
          for (int space = 0; space < legPosition; space++) {
            System.out.print(" ");
          }
        } else {
          // Other legs: print spaces from the previous leg
          int previousLegPosition = (legNum - 1) * (tableWidth - 1) / (tableLegs - 1);
          int gapSize = legPosition - previousLegPosition - 1;
          for (int space = 0; space < gapSize; space++) {
            System.out.print(" ");
          }
        }

        // Now draw the actual leg
        System.out.print("|");
      }
      System.out.println();
    }

    System.out.println();
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


  public void drawCake() {

    int height = Math.max(10, this.cakeHeight);
    int width = Math.max(3, this.cakeWidth);

    int depth = Math.max(0, Math.min((width - 1) / 2, this.layers));


    int innerWidth = width - (depth * 2);
    if (innerWidth < 1) {
      depth = Math.max(0, (width - 1) / 2);
      innerWidth = width - (depth * 2);
    }


    for (int i = 0; i < depth; i++) {
      for (int s = 0; s < i; s++) {
        System.out.print(" ");
      }
      int lineWidth = Math.max(0, width - (i * 2));
      System.out.print("/");
      for (int w = 0; w < lineWidth; w++) {
        System.out.print("~");
      }
      System.out.println("\\");
    }

    // Draw cake body using height and innerWidth
    for (int row = 0; row < height; row++) {
      for (int s = 0; s < depth; s++) {
        System.out.print(" ");
      }
      System.out.print("|");
      for (int col = 0; col < innerWidth; col++) {
        if (row % 3 == 0) {
          System.out.print("=");
        } else {
          System.out.print("#");
        }
      }
      System.out.print("|");
      for (int d = 0; d < depth; d++) {
        System.out.print("/");
      }
      System.out.println();
    }

    // Draw bottom of the cake
    for (int s = 0; s < depth; s++) {
      System.out.print(" ");
    }
    System.out.print("\\");
    for (int i = 0; i < innerWidth; i++) {
      System.out.print("_");
    }
    System.out.print("/");
    System.out.println();
  }

}