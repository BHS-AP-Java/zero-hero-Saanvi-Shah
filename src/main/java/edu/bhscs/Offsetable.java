// Saanvi Shah
// 10/31/25
// P2
// Offsetable Interface - for objects that can be centered/offset
package edu.bhscs;

/**
 * The Offsetable interface defines objects that have a width and can be drawn with an offset
 * (shifted to the right). This allows Cake and Table to work together without depending directly on
 * each other's class structure.
 */
public interface Offsetable {

  /**
   * Returns the width of this object in characters
   *
   * @return the width as an integer
   */
  int getWidth();

  /**
   * Draws this object with the specified offset (spaces from left)
   *
   * @param offset number of spaces to print before drawing
   */
  void drawWithOffset(int offset);
}
