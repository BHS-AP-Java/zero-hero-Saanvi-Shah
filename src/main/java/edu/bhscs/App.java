// Saanvi Shah
// 10/02/25
// P2
// This is making the App class

package edu.bhscs;

public class App {
  public static void main(String[] args) {
    date10_27();
  }
// Let's say the tale leg is "|?|"
// now that leg size is 3.
// so the space between needs to comesate.
// so if the table has a width of 15 and 5 legs, then there is 0 space between.


  public static void date10_27() {
    Baker bob = new Baker("Bob");
    Table t = new Table(13, 50);
    t.setLeg("|?|");
    Cake bDay = bob.bakes(7, "Suzzie");
    bDay.draw(t);
  }
}
