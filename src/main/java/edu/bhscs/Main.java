// Saanvi Shah
// P2
// Making, Baking, and Buying a Cake
// 10/07/25

/*
 * DESCRIPTION: This is the main class for my bake sale game. The player chooses a character,
 * orders cakes, and interacts with the baker.
 * INPUT: Character choice, cake options, decoration choice, and decisions if the baker steals.
 * OUTPUT: Messages showing gameplay, cake visuals, PTSA donations, and bank balances.
 * EDGE CASES: - Player runs out of money - Invalid menu input - Player chooses not to decorate cake
 */

package edu.bhscs;

public class Main {
  public static void main(String[] args) {

    System.out.println("Welcome to the Sweet Treats Bake Sale!");
    System.out.println("Choose your player:");

    // Pre-made characters
    System.out.println("1. Sally");
    System.out.println("2. Bob");
    System.out.println("3. Georgina");

    // The Player class now handles the Scanner internally
    Player player = new Player(); // no Scanner in Main
    int choice = player.askInt("Enter 1, 2, or 3 to choose your character: ");

    String name;
    int balance;

    // Assign character based on user input
    if (choice == 1) {
      name = "Sally";
      balance = 100;
    } else if (choice == 2) {
      name = "Bob";
      balance = 50;
    } else {
      name = "Georgina";
      balance = 20;
    }

    // Create player, bakery, baker, and PTSA objects
    player.setName(name);
    player.setBankBalance(balance);
    Bakery bakery = new Bakery("Sweet Treats");
    PTSA ptsa = new PTSA("Bothell High");
    Baker baker = new Baker(player); // teacher's class
    baker.f = new Flour("All-purpose flour", 5);

    System.out.println("\nWelcome, " + name + "! You have $" + balance + " in your bank account.");

    boolean keepPlaying = true;

    // LOOP: player can order multiple cakes
    while (keepPlaying) {
      System.out.println("\n---- New Cake Order ----");

      int layers = player.askInt("How many layers? (1-3): ");
      String flavor =
          player.ask("Choose a cake flavor (chocolate / vanilla / strawberry / lemon / rhubarb): ");

      // Decoration option
      String decorateChoice =
          player.ask(
              "Would you like it decorated for a $20 upcharge? (Highly recommended) (y/n): ");
      boolean decorated = decorateChoice.equalsIgnoreCase("y");

      String frosting = "";
      String topping = "";

      if (decorated) {
        frosting =
            player.ask(
                "Choose frosting (chocolate / vanilla / strawberry / lemon / rhubarb / blueberry): ");
        topping = player.ask("Choose topping (sprinkles / cherries / candles): ");
      }

      // Bakery makes the cake
      Backupzcake cake = bakery.sellCake("medium", layers, flavor, frosting, topping);
      baker.bakeCake(); // uses teacher's Baker class
      baker.experience++; // baker gains experience after every bake

      // Cake price
      int price = decorated ? 40 : 20;
      System.out.println("\nYour cake costs $" + price);

      // Check if player has enough money
      if (player.getBankBalance() < price) {
        System.out.println("You don't have enough money for this cake!");
      } else {
        player.pay(price);

        // Randomly decide if baker donates or steals
        boolean bakerHonest = Math.random() < 0.5;
        if (bakerHonest) {
          ptsa.receiveDonation(price);
          System.out.println("The baker donates the money to the PTSA!");
        } else {
          System.out.println("Uh oh... The baker decided to keep the money!");
          String action = player.ask("Do you want to (1) beat up the baker or (2) say nothing? ");
          if (action.equals("1")) {
            System.out.println("You confront the baker and recover the money!");
            ptsa.receiveDonation(price);
          } else {
            System.out.println("You stay silent... The baker pockets the cash.");
          }
        }

        // Show cake visual and details
        System.out.println("\nHere’s your cake:");
        if (decorated) {
          cake.showDecoratedCake();
        } else {
          cake.showCake();
        }

        System.out.println("\nYou ordered a " + layers + "-layer " + flavor + " cake.");
        if (decorated) {
          System.out.println("With " + frosting + " frosting and " + topping + " on top!");
        }

        System.out.println("Your remaining balance: $" + player.getBankBalance());
        System.out.println("Baker’s total experience: " + baker.experience + " cakes baked.");
      }

      // Ask to play again
      String again = player.ask("\nWould you like to order another cake? (y/n): ");
      if (!again.equalsIgnoreCase("y")) {
        keepPlaying = false;
      }
    }

    // Game end
    System.out.println("\nThank you for visiting Sweet Treats Bakery!");
    System.out.println("Final PTSA balance: $" + ptsa.totalFunds);
    System.out.println("Goodbye, " + player.getName() + "!");
  }
}
