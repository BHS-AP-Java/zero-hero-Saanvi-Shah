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

  // getWidth() already exists - implements Offsetable interface
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

  // UPDATED: draw(Offsetable below) - Fixed for multi-character leg styles
  // Uses the default getOffset() method from Offsetable interface
  public void draw(Offsetable below) {
    // Calculate offset using the default method
    int offset = this.getOffset(below);

    // Draw the table top with offset
    for (int i = 0; i < offset; i++) {
      System.out.print(" ");
    }
    for (int i = 0; i < width; i++) {
      System.out.print(topStyle);
    }
    System.out.println();

    // Draw the table legs with offset
    // FIXED: Account for multi-character leg styles
    int legStyleWidth = legStyle.length();

    for (int row = 0; row < height; row++) {
      int previousEndPosition = 0;

      for (int legNum = 0; legNum < legs; legNum++) {
        int legStartPosition;

        if (legs == 1) {
          // One leg in the middle
          legStartPosition = (width - legStyleWidth) / 2;
        } else {
          // FENCEPOST FIX: Distribute legs from 0 to (width - legStyleWidth)
          // This ensures last leg ends exactly at table edge
          legStartPosition = legNum * (width - legStyleWidth) / (legs - 1);
        }

        // Calculate spaces to print before this leg
        int spacesToPrint = legStartPosition - previousEndPosition;
        if (legNum == 0) {
          spacesToPrint += offset; // Add global offset for first leg
        }

        // Print spaces
        for (int space = 0; space < spacesToPrint; space++) {
          System.out.print(" ");
        }

        // Draw the leg
        System.out.print(legStyle);

        // Update where this leg ends
        previousEndPosition = legStartPosition + legStyleWidth;
      }
      System.out.println();
    }
    // REMOVED: Extra System.out.println() that was causing spacing issues

    // If there's something below, draw it
    if (below != null) {
      below.draw(null);
    }
  }
}
