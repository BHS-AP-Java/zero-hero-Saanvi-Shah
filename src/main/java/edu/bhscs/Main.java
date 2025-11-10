// Saanvi Shah
// P2
// Making, Baking, and Buying a Cake
// 10/07/25

package edu.bhscs;

public class Main {
  public static void main(String[] args) {

    Player player = new Player();
    int playerChoice = player.askInt("Enter 1, 2, or 3 to choose your character: ");

    String name;
    int startingBalance;

    // Create player, bakery, baker, and PTSA objects
    player.setName(name);
    player.setBankBalance(startingBalance);
    Bakery bakery = new Bakery("Sweet Treats");
    PTSA ptsa = new PTSA("Bothell High");
    Baker baker = new Baker(player);
    baker.f = new Flour("All-purpose flour", 5);

    }

  }