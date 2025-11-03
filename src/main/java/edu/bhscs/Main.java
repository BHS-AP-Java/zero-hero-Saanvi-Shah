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

    // The Player class now handles the Scanner
    Player player = new Player(); // no Scanner in Main
    int playerChoice = player.askInt("Enter 1, 2, or 3 to choose your character: ");

    String name;
    int startingBalance;

    // Create player, bakery, baker, and PTSA objects
    player.setName(name);
    player.setBankBalance(startingBalance);
    Bakery bakery = new Bakery("Sweet Treats");
    PTSA ptsa = new PTSA("Bothell High");
    Baker baker = new Baker(player); // teacher's class
    baker.f = new Flour("All-purpose flour", 5);

     
