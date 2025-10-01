package edu.bhscs;

public class Flour {
  // Fields and properties
  String name = "All-purpose flour";
  int quantity = 5; // in pounds
  int price = 3; // price per bag in dollars
  int quality = 8; // quality on a scale of 1-10

  // constructor
  public Flour(String name, int weight) {
    this.name = name;
    this.quantity = weight;
  }

  // method
  public void goesBad() {
    System.out.println("Flour is expired.");
    this.quality = 0;
  }
}
