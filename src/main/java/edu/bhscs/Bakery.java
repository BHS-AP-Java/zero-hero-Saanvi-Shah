// Saanvi Shah
// 9/30/25
// P2
// This is making the bakery class

// DESCRIPTION: Creating a bakery that sells cakes
// INPUT: name
// OUTPUT: A line saying the bakery is preparing your cake
// EDGE CASE: None
//

package edu.bhscs;

public class Bakery {
  // This file is for my Bakery class.
  // A Bakery is basically the "place" that makes cakes and gives them to people.
  // Fields and properties of a Bakery

  String name; // the name of the bakery

  // Constructor: makes a new Bakery with a name
  public Bakery(String name) {
    this.name = name;
  }

  // Method: the bakery sells a cake
  // It takes the details of the cake and returns a Cake object
  public Cake sellCake(String size, int layers, String flavor, String frosting, String grosting) {
    System.out.println(name + " bakery is preparing your cake...");
    return new Cake(size, layers, flavor, frosting, grosting);
  }
}
