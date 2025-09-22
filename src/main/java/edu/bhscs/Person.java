package edu.bhscs;

// This file is for my Person class.
// A Person is just an object with a name. The person can also eat cake.

public class Person {
  String name; // the name of the person

  // Constructor: makes a new Person with a name
  public Person(String name) {
    this.name = name;
  }

  // Method: what the person does (eat cake)
  // It prints a sentence saying the person ate the cake.
  public void eatCake(Cake cake) {
    System.out.println(name + " eats the cake happily!");
  }
}
