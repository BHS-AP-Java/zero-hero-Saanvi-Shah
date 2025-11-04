// Saanvi Shah
// 10/02/25
// P2
// This is making the App class

package edu.bhscs;

public class App {
  public static void main(String[] args) {
    date10_27();
  }

  public static void date10_27() {
    Baker bob = new Baker("Bob");
    Table t = new Table(19, 44);
    Cake bDay = bob.bakes(5, "Suzzie");
    bDay.draw(t);
  }
}
