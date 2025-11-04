// Saanvi Shah
// 10/02/25
// P2
// This is making the App class

package edu.bhscs;

public class App {
  public static void main(String[] args) {
    date10_27();
  }

  // This method is for the assignment - it shows off:
  // 1. The Baker class creating a cake with bakes()
  // 2. The Table class storing table info
  // 3. The Cake class drawing itself centered on the table
  // The cake and table are independent - change one without affecting the other!
  public static void date10_27() {
    Baker bob = new Baker("Bob"); // Create a baker named Bob
    Table t = new Table(4, 22); // Create a table with 4 legs and width of 22
    Cake bDay = bob.bakes(5, "Suzzie"); // Bob bakes a 5-layer cake for Suzzzie
    bDay.draw(t); // Draw the cake centered on the table
  }
}
