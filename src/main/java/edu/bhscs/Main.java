// Saanvi Shah
// P2
// Making, Baking, and Buying a Cake
// 10/07/25

package edu.bhscs;

public class Main {
  public static void main(String[] args) {
    System.out.println("Welcome to the Sweet Treats Bake Sale!");
    System.out.println("Choose your player:");

    // Pre-made characters
    System.out.println("1. Sally");
    System.out.println("2. Bob");
    System.out.println("3. Georgina");

    Player player = new Player();
    int playerChoice = player.askInt("Enter 1, 2, or 3 to choose your character: ");

    String name;
    int startingBalance;

    if (playerChoice == 1) {
      name = "Sally";
      startingBalance = 200;
    } else if (playerChoice == 2) {
      name = "Bob";
      startingBalance = 50;
    } else {
      name = "Georgina";
      startingBalance = 20;
    }

    player.setName(name);
    player.setBankBalance(startingBalance);
    Bakery bakery = new Bakery("Sweet Treats");
    PTSA ptsa = new PTSA("Bothell High");
    Baker baker = new Baker(player);
    baker.f = new Flour("All-purpose flour", 5);

    System.out.println(
        "\nWelcome, " + name + "! You have $" + startingBalance + " in your bank account.");

    boolean keepPlaying = true;

    while (keepPlaying) {
      System.out.println("\n---- New Cake Order ----");

      int layers = 1;
      String flavor =
          player.ask(
              "Choose a cake flavor (chocolate / vanilla / red velvet / carrot / lemon / strawberry): ");

      String frosting =
          player.ask(
              "Choose frosting (chocolate / vanilla / strawberry / lemon / rhubarb / blueberry): ");
      String topping = player.ask("Choose topping (sprinkles / cherries / candles / none): ");

      Cake cake = bakery.sellCake("medium", layers, flavor, frosting, topping);
      baker.bakeCake(0, "");
      baker.experience++;

      int price = 40;
      System.out.println("\nYour cake costs $" + price);

      if (player.getBankBalance() < price) {
        System.out.println("You don't have enough money for this cake!");
      } else {
        player.pay(price);

        boolean bakerHonest = Math.random() < 0.5;
        if (bakerHonest) {
          player.donateToPTSA(price);
          System.out.println("The baker donates the money to the PTSA!");
        } else {
          System.out.println("Uh oh... The baker decided to keep the money!");
          String action = player.ask("Do you want to (1) beat up the baker or (2) say nothing? ");
          if (action.equals("1")) {
            System.out.println("You confront the baker and recover the money!");
            player.donateToPTSA(price);
          } else {
            System.out.println("You stay silent... The baker pockets the cash.");
          }
        }

        System.out.println("\nHere's your cake:");
        cake.showDecoratedCake();
        if (layers == 1) {
          cake.printAsciiCakeArt();
        }

        System.out.println("\nYou ordered a " + layers + "-layer " + flavor + " cake.");
        System.out.println("With " + frosting + " frosting and " + topping + " on top!");

        System.out.println("Your remaining balance: $" + player.getBankBalance());
        System.out.println("Baker's total experience: " + baker.experience + " cakes baked.");
      }

      String again = player.ask("\nWould you like to order another cake? (y/n): ");
      if (!again.equalsIgnoreCase("y")) {
        keepPlaying = false;
      }
    }

    System.out.println("\nThank you for visiting Sweet Treats Bakery!");
    System.out.println("Final PTSA balance: $" + ptsa.totalFunds);
    System.out.println("Goodbye, " + player.getName() + "!");
  }
}
