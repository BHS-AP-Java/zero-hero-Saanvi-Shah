// Saanvi Shah
// P2
// Making, Baking, and Buying a Cake
// 9/21/25

/*
 * DESCRIPTION: The main goal is to make a bake sale.
 * Required is a bakery, cake, customer. and PTSA to give the money
 * This excercise is about learning objects, classes, and methods.
 * My goal is to have a customer, come into the bakery and choose flavors and everything
 * INPUT: Name, flavor, frosting, grosting, size, layers
 * OUTPUT: Some cool lines in the command terminal thing
 * EDGE CASE: Every case is an edge case
 */

package edu.bhscs;

// This file talks to the other files (Cake, Person, Bakery).

import java.util.Scanner; // I need Scanner so I can let the user type stuff into the terminal

public class Main {
  public static void main(String[] args) {
    // Scanner lets me read input from the user
    Scanner sc = new Scanner(System.in);

    // Step 1: Ask the player for their name and make a Person object
    System.out.println("Welcome to the Bakery! What is your name?");
    String personName = sc.nextLine();
    Person customer = new Person(personName);

    // Step 2: Create a Bakery object
    Bakery bakery = new Bakery("Sweet Treats");

    // Step 3: Ask for cake details
    // NOTE: I am not doing full "error checking" I am just basically trusting the user to type one
    // of the
    // options.
    System.out.println("\nChoose a cake size (small / medium / large):");
    String size = sc.nextLine();

    System.out.println("How many layers? (1-3):");
    int layers = sc.nextInt();
    sc.nextLine(); // This line clears the weird extra newline so the next input works.

    System.out.println("Choose flavor (chocolate / vanilla / strawberry):");
    String flavor = sc.nextLine();

    System.out.println("Choose frosting (buttercream / whipped cream / fondant):");
    String frosting = sc.nextLine();

    System.out.println("Choose grosting (sprinkles / cherries / candles):");
    String grosting = sc.nextLine();

    // Step 4: Bakery makes and gives us a Cake object
    Cake myCake = bakery.sellCake(size, layers, flavor, frosting, grosting);

    // Step 5: Show the cake (draw it)
    myCake.showCake();

    // Step 6: The person eats the cake
    customer.eatCake(myCake);

    // Step 7: Close scanner
    sc.close();
  }
}
