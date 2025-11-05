// Saanvi Shah
// 10/27/25
// P2
// This is the Table class

package edu.bhscs;

public class Table {
  // FIELDS AND PROPERTIES
  int legs;
  int width;
  String leg;

  // CONSTRUCTOR
  public Table(int legs, int width) {
    this.legs = legs;
    this.width = width;
  }

  // METHODS
  // Getter method so the Cake class can figure out how to center itself

  public void setLeg(String leg){
    this.leg = leg;
  }

  public int getLegs() {
    return legs;
  }

  // Getter method for table width, used to center the cake
  public int getWidth() {
    return width;
  }
}


