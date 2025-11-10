// Saanvi Shah
// 11/07/25
// P2
// This is the Cup class - implements Offsetable

package edu.bhscs;

public class Cup implements Offsetable {
  // FIELDS
  private int width;
  private int height;
  private String contents; // What's in the cup (coffee, tea, water, etc.)

  // CONSTRUCTOR
  public Cup(String contents) {
    this.contents = contents;
    this.width = 5; // Default cup width
    this.height = 3; // Default cup height
  }

  // Overloaded constructor with custom size
  public Cup(String contents, int width, int height) {
    this.contents = contents;
    this.width = width;
    this.height = height;
  }

  // METHODS

  // Implement getWidth() from Offsetable
  public int getWidth() {
    return this.width;
  }

  // Implement draw(Offsetable below) from Offsetable
  public void draw(Offsetable below) {
    // Calculate offset using the default method from Offsetable
    int offset = this.getOffset(below);

    // Draw the cup
    // Top rim
    for (int i = 0; i < offset; i++) {
      System.out.print(" ");
    }
    for (int i = 0; i < width; i++) {
      System.out.print("_");
    }
    System.out.println();

    // Cup body (middle rows)
    for (int row = 0; row < height - 1; row++) {
      for (int i = 0; i < offset; i++) {
        System.out.print(" ");
      }
      System.out.print("|");

      // Fill with contents or spaces
      if (row == height / 2 && contents.length() <= width - 2) {
        // Center the contents text in the middle row
        int contentPadding = (width - 2 - contents.length()) / 2;
        for (int i = 0; i < contentPadding; i++) {
          System.out.print(" ");
        }
        System.out.print(contents);
        for (int i = 0; i < width - 2 - contentPadding - contents.length(); i++) {
          System.out.print(" ");
        }
      } else {
        for (int i = 0; i < width - 2; i++) {
          System.out.print(" ");
        }
      }

      System.out.print("|");
      System.out.println();
    }

    // Bottom of cup
    for (int i = 0; i < offset; i++) {
      System.out.print(" ");
    }
    System.out.print("|");
    for (int i = 0; i < width - 2; i++) {
      System.out.print("_");
    }
    System.out.print("|");
    System.out.println();
    System.out.println(); // Extra line for spacing

    // If there's something below, draw it
    if (below != null) {
      below.draw(null);
    }
  }

  // Optional: method to change contents
  public void setContents(String contents) {
    this.contents = contents;
  }

  public String getContents() {
    return this.contents;
  }
}
