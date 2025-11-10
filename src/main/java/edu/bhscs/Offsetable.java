
// Saanvi Shah
// 11/07/25
// P2
// Offsetable Interface - for objects that can be centered/offset

package edu.bhscs;

/**
 * The Offsetable interface defines objects that have a width and can be drawn with an offset (shifted to the right).
 * This allows Cake, Table, and Cup to work together without depending directly on each other's class structure.
 */
public interface Offsetable {

  /**
   * Returns the width of this object in characters
   * @return the width as an integer
   */
  int getWidth();

  /**
   * Default centering logic — always clamps to 0 so alignment never goes negative. Calculates how
   * many spaces to offset this object when centered on another object.
   *
   * @param below the object this is being placed on top of
   * @return the offset (number of spaces from left) - never negative
   */
  default int getOffset(Offsetable below) {
    if (below == null)
      return 0;
    return Math.max(0, (below.getWidth() - this.getWidth()) / 2);
  }

  /**
   * Each Offsetable thing knows how to draw itself relative to whatever is beneath it.
      * @param below the object this is being placed on (can be null for ground level)
   */
  void draw(Offsetable below);
}
