// Saanvi Shah
// 10/27/25
// P2
// This is the Table class

package edu.bhscs;

public class Table {
  // FIELDS AND PROPERTIES
  // These control the table's appearance
  int legs; // How many legs the table has
  int width; // How wide the table is (in characters)

  // CONSTRUCTOR
  public Table(int legs, int width) {
    this.legs = legs;
    this.width = width;
  }

  // METHODS
  // Getter method so the Cake class can figure out how to center itself
  public int getLegs() {
    return legs;
  }

  // Getter method for table width - used to center the cake
  public int getWidth() {
    return width;
  }
}
