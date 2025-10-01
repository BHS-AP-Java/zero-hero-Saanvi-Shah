// Saanvi Shah
// P2
// Making, Baking, and Buying a Cake
// 9/21/25

/*
 * DESCRIPTION: The main goal is to make a bake sale.
 * Required is a bakery, cake, customer. and PTSA to give the money
 * This excercise is about learning objects, classes, and methods.
 * My goal is to have a customer, come into the bakery and choose flavors and eat cake.
 * INPUT: Name, flavor, frosting, grosting, size, layers
 * OUTPUT: Some cool lines in the command terminal thing
 * EDGE CASE: Every case is an edge case
 */

package edu.bhscs;

import java.util.Scanner; // I need Scanner so I can let the user type stuff into the terminal

public class Main {
  public static void main(String[] args) {
    // Scanner lets me read input from the user
    Scanner sc = new Scanner(System.in);

    // Asking the player for their name and make a Person object
    System.out.println("Welcome to the Bakery! What is your name?");
    String personName = sc.nextLine();
    Customer customer = new Customer(personName);

    // Creating a Bakery object
    Bakery bakery = new Bakery("Sweet Treats");

    // Adding experience of baker as a factor
    Baker baker = new Baker(1, false);
    baker.bakeCake();

    // Asking for cake details
    // I am just basically trusting the user to type one
    // of the options.
    // Talking about how much experience the baker has
    System.out.println("Our baker has " + baker.experience + " years of experience.");
    if (baker.isCertified) {
      System.out.println("They are also a certified baker!");
    } else {
      System.out.println("They are not a certified baker.");
    }
    // Asking for cake details

    System.out.println("\nChoose a cake size (small / medium / large):");
    String size = sc.nextLine();

    System.out.println("How many layers? (1-3):");
    int layers = sc.nextInt();
    sc.nextLine(); // This line clears the weird extra newline so the next input works.

    System.out.println("Choose flavor (chocolate / vanilla / strawberry):");
    String flavor = sc.nextLine();

    System.out.println("Choose frosting (chocolate / vanilla / strawberry):");
    String frosting = sc.nextLine();

    System.out.println("Choose grosting (sprinkles / cherries / candles):");
    String grosting = sc.nextLine();

    // Bakery makes and gives us a Cake object
    Cake myCake = bakery.sellCake(size, layers, flavor, frosting, grosting);

    // Show the cake (draw it)
    myCake.showCake();

    // The person eats the cake
    customer.eatCake(myCake);

    // Close scanner
    sc.close();
  }
}
