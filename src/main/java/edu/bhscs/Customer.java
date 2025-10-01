// Saanvi Shah
// 9/30/25
// P2
// This is making the customer class

// DESCRIPTION: Creating a flour that has name, quantity, price, and quality
// INPUT: name
// OUTPUT: A line saying the person ate the cake
// EDGE CASE: Nothing entered
//

package edu.bhscs;

// This file is for my Person class.
// A Person is just an object with a name. The person can also eat cake.

public class Customer {
  String name; // the name of the person

  // Constructor: makes a new Person with a name
  public Customer(String name) {
    this.name = name;
  }

  // Method: what the person does (eat cake)
  // It prints a sentence saying the person ate the cake.
  public void eatCake(Cake cake) {
    System.out.println(name + " eats the cake happily!");
  }
}
