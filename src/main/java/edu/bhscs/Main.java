// Saanvi Shah
// P2
// Making, Baking, and Buying a Cake
// 10/07/25

package edu.bhscs;

public class Main {
  public static void main(String[] args) {
    // Test the new Offsetable stacking feature with new Cup class
    CupOnTable();

    // Test the Table with Cake on it

    date10_27();
  }

  // Test method for stacking Offsetable objects
  public static void CupOnTable() {
    Table table1 = new Table(4, 16);
    Cup coffee = new Cup("☕");
    coffee.draw(table1);
  }

  // This method draws a table with a cake on it
  public static void date10_27() {
    Baker bob = new Baker("Bob");
    Table t = new Table(7, 35); // 5 legs, width 50
    Cake bDay = bob.bakes(5, "Suzzie"); // 3 layers
    bDay.draw(t);
  }

  // COMMENTED OUT: Player selection code (can be used later)
  /*
   * public static void playerGame() { Player player = new Player(); int playerChoice =
   * player.askInt("Enter 1, 2, or 3 to choose your character: ");
   *
   * String name; int startingBalance;
   *
   * // FIXED: Use playerChoice to assign name and balance if (playerChoice == 1) { name =
   * "Player 1"; startingBalance = 100; } else if (playerChoice == 2) { name = "Player 2";
   * startingBalance = 50; } else { name = "Player 3"; startingBalance = 20; }
   *
   * // Create player, bakery, baker, and PTSA objects player.setName(name);
   * player.setBankBalance(startingBalance); Bakery bakery = new Bakery("Sweet Treats"); PTSA ptsa =
   * new PTSA("Bothell High");
   *
   * // FIXED: Baker has two constructors - use the one that takes String Baker baker = new
   * Baker("Chef"); baker.f = new Flour("All-purpose flour", 5);
   *
   * System.out.println("\nPlayer " + playerChoice + " (" + name + ") created!");
   * System.out.println("Starting balance: $" + startingBalance); System.out.println("Bakery: " +
   * bakery.getName()); System.out.println("Supporting: " + ptsa.name + " PTSA");
   *
   * // Use the baker to bake a cake Cake myCake = baker.bakes(3, name);
   * System.out.println("\nCake baked successfully!"); }
   */
}
