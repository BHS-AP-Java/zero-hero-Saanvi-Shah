// Saanvi Shah
// 10/27/25
// P2
// This is the Table class

package edu.bhscs;

public class Table implements Offsetable {
  // FIELDS AND PROPERTIES
  private int legs;
  private int width;
  private int height;
  private String legStyle;
  private String topStyle; // NEW: for custom table top

  // CONSTRUCTOR
  public Table(int legs, int width, int height) {
    this.legs = legs;
    this.width = width;
    this.height = height;
    this.legStyle = "|"; // Default leg style
    this.topStyle = "="; // Default top style
  }

  // Overloaded constructor with default height
  public Table(int legs, int width) {
    this(legs, width, 6); // Default height is 6
  }

  // METHODS
  public void setLegStyle(String style) {
    this.legStyle = style;
  }

  // NEW: setTop method as required by assignment
  public void setTop(String style) {
    this.topStyle = style;
  }

  public int getLegs() {
    return legs;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public String getLegStyle() {
    return legStyle;
  }

  public String getTopStyle() {
    return topStyle;
  }

  // UPDATED: drawTable method using loops and solving Fencepost Problem
  public void drawTable() {
    // Draw the table top using the topStyle
    // Loop to draw width characters (accounting for multi-char topStyle)
    for (int i = 0; i < width; i++) {
      System.out.print(topStyle);
    }
    System.out.println();

    // Draw the table legs (solving the FENCEPOST PROBLEM)
    // The fencepost problem: with N legs, there are N-1 gaps between them
    // Legs must appear at BOTH ends

    for (int row = 0; row < height; row++) {
      // For each row, we need to place legs at specific positions
      for (int legNum = 0; legNum < legs; legNum++) {
        int legPosition;

        // Calculate position for this leg (evenly spaced)
        // Special case: if only 1 leg, put it in the middle
        if (legs == 1) {
          legPosition = width / 2;
        } else {
          // FENCEPOST SOLUTION: distribute legs from position 0 to position (width-1)
          // This ensures legs at BOTH ends
          legPosition = legNum * (width - 1) / (legs - 1);
        }

        // Print spaces before this leg
        // Calculate how many spaces since the last leg (or start)
        int previousPosition = 0;
        if (legNum > 0) {
          if (legs == 1) {
            previousPosition = 0;
          } else {
            previousPosition = (legNum - 1) * (width - 1) / (legs - 1) + legStyle.length();
          }
        }

        int spacesToPrint = legPosition - previousPosition;
        for (int space = 0; space < spacesToPrint; space++) {
          System.out.print(" ");
        }

        // Draw the leg using the custom style
        System.out.print(legStyle);
      }
      System.out.println();
    }
    System.out.println();
  }
}
