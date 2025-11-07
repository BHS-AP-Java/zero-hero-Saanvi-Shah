// Saanvi Shah
// 10/27/25
// P2
// This is the Table class

package edu.bhscs;

public class Table {
  // FIELDS AND PROPERTIES
  private int legs;
  private int width;
  private int height;
  private String legStyle;

  // CONSTRUCTOR
  public Table(int legs, int width, int height) {
    this.legs = legs;
    this.width = width;
    this.height = height;
    this.legStyle = "|"; // Default leg style
  }
  // chANGE
  // Overloaded constructor with default height
  public Table(int legs, int width) {
    this(legs, width, 6); // Default height is 4
  }

  // METHODS
  public void setLegStyle(String style) {
    this.legStyle = style;
  }

  public int getLegs() {
    return legs;
  }

  public int getWidth() {
    return width;
  }

  public void drawTable() {
    // Draw the table top
    for (int i = 0; i < width + 8; i++) {
      System.out.print("=");
    }
    System.out.println();

    // Draw the table legs
    for (int row = 0; row < height; row++) {
      for (int legNum = 0; legNum < legs; legNum++) {
        int legPosition;
        if (legs == 1) {
          // One leg goes in the middle
          legPosition = width / 2;
        } else {
          // Evenly space the legs
          legPosition = legNum * (width - 1) / (legs - 1);
        }

        // Print spaces until we reach this leg's position
        if (legNum == 0) {
          // First leg: print spaces from the start
          for (int space = 0; space < legPosition; space++) {
            System.out.print(" ");
          }
        } else {
          // Other legs: print spaces from the previous leg
          int previousLegPosition = (legNum - 1) * (width - 1) / (legs - 1);
          int gapSize = legPosition - previousLegPosition - 1;
          for (int space = 0; space < gapSize; space++) {
            System.out.print(" ");
          }
        }

        // Draw the leg using the custom style
        System.out.print(legStyle);
      }
      System.out.println();
    }
    System.out.println();
  }

  {

    // Draw the table legs
    for (int row = 0; row < height; row++) {
      for (int legNum = 0; legNum < legs; legNum++) {
        int legPosition;
        if (legs == 1) {
          // One leg goes in the middle
          legPosition = width / 2;
        } else {
          // Evenly space the legs
          legPosition = legNum * (width - 1) / (legs - 1);
        }

        // Print spaces until we reach this leg's position
        if (legNum == 0) {
          // First leg: print spaces from the start
          for (int space = 0; space < legPosition; space++) {
            System.out.print(" ");
          }
        } else {
          // Other legs: print spaces from the previous leg
          int previousLegPosition = (legNum - 1) * (width - 1) / (legs - 1);
          int gapSize = legPosition - previousLegPosition - 1;
          for (int space = 0; space < gapSize; space++) {
            System.out.print(" ");
          }
        }

        // Draw the leg using the custom style
        System.out.print(legStyle);
      }
      System.out.println();
    }
    System.out.println();
  }
}
