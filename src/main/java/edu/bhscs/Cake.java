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

  // CONSTRUCTOR
  public Cake(String size, int layers, String flavor, String frosting, String topping) {
    this.size = size;
    this.layers = Math.min(layers, 3);
    this.flavor = flavor;
    this.frosting = frosting;
    this.topping = topping;
    this.flour = new Flour("All-purpose flour", 5);
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
  public void showDecoratedCake() {
    System.out.println("\nHere is your decorated cake:");

    if (layers == 1) {
    } else if (layers == 2) {
    } else if (layers == 3) {
    }
  }
  public static void drawCake3D() {
    int height = 8;
    int width = 16;
    int depth = 6;

    for (int i = 0; i < depth; i++) {
      for (int s = 0; s < i; s++) {
        System.out.print(" ");
      }
      int lineWidth = width - (i * 2);
      System.out.print("/");
      for (int w = 0; w < lineWidth; w++) {
        System.out.print("~");
      }
      System.out.println("\\");
    }
    for (int row = 0; row < height; row++) {
      for (int s = 0; s < depth; s++) {
        System.out.print(" ");
      }
      System.out.print("|");
      for (int col = 0; col < width - (depth * 2); col++) {
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
    for (int s = 0; s < depth; s++) {
      System.out.print(" ");
    }
    System.out.print("\\");
    for (int i = 0; i < width - (depth * 2); i++) {
      System.out.print("_");
    }
    System.out.print("/");
    System.out.println();
  }

    public void draw(Table t) {
     if (t == null) return;
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


