// Saanvi Shah
// 10/07/25
// P2
// This is making the Store class

/*
 * DESCRIPTION: The Store class represents the bakery where the Baker works. It is used by the
 * Baker’s takeJob() method to set the place of work.
 *
 * INPUT: The store name.
 *
 * OUTPUT: Prints confirmation when the baker takes a job there.
 *
 * EDGE CASES:  Empty or null store names.
 */

package edu.bhscs;

public class Store {
  // FIELDS AND PROPERTIES
  String name; // name of the store (ex: "Sweet Treats")

  // CONSTRUCTOR
  public Store(String name) {
    this.name = name;
  }

  // METHODS
  // getName(): returns the store name
  public String getName() {
    return name;
  }
}
