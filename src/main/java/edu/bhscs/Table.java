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

  // NEW: Implement drawWithOffset() from Offsetable interface
  public void drawWithOffset(int offset) {
    // Draw the table top with offset
    for (int i = 0; i < offset; i++) {
      System.out.print(" ");
    }
    for (int i = 0; i < width; i++) {
      System.out.print(topStyle);
    }
    System.out.println();

    // Draw the table legs with offset
    for (int row = 0; row < height; row++) {
      for (int legNum = 0; legNum < legs; legNum++) {
        int legPosition;

        if (legs == 1) {
          legPosition = width / 2;
        } else {
          legPosition = legNum * (width - 1) / (legs - 1);
        }

        int previousPosition = 0;
        if (legNum > 0) {
          if (legs == 1) {
            previousPosition = 0;
          } else {
            previousPosition = (legNum - 1) * (width - 1) / (legs - 1) + legStyle.length();
          }
        }

        // Add offset to the first leg
        int spacesToPrint = legPosition - previousPosition;
        if (legNum == 0) {
          spacesToPrint += offset; // Add offset for first leg
        }

        for (int space = 0; space < spacesToPrint; space++) {
          System.out.print(" ");
        }

        System.out.print(legStyle);
      }
      System.out.println();
    }
    System.out.println();
  }

  // ORIGINAL drawTable() method - draws with no offset
  public void drawTable() {
    drawWithOffset(0); // Just calls drawWithOffset with 0
  }
}
