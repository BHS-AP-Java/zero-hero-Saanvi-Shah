// Saanvi Shah
// 10/07/25
// P2
// This is making the Bakery class

/*
 * DESCRIPTION: The Bakery class represents the shop that sells cakes. It has a name and can make
 * and sell Cake objects when requested. The Bakery is where the Baker works and where the Player
 * orders their cakes.
 *
 * INPUT: Cake details (like layers, flavor, frosting, toppings)
 *
 * OUTPUT: A message saying the bakery is preparing the cake
 *
 * EDGE CASES: - Invalid cake options - Zero or negative layers
 */

package edu.bhscs;

public class Baker {
  // PROPERTIES AND FIELDS
  Player p;
  Flour f;
  Store placeOfWork;
  int cash;

  // CONSTRUCTOR
  Baker(Player p) {
    this.p = p;
  }

  // METHODS
  void takeOrder(int price, Customer c) {
    cash += c.pay(price);
    c.takeCake(bakeCake());
  }

  Cake bakeCake() {
    String answer = this.p.giveAnswer("what cake do you you want?");
    return new Cake(answer, this.f);
  }

  void takeJob(Store bakery) {
    String doYouWantToWorkHere = this.p.giveAnswer("Do you want to work at " + bakery.getName());
    if (doYouWantToWorkHere.equals("y")) {
      this.placeOfWork = bakery;
      System.out.println(this.name + " now works at " + bakery.getName());
    }
  }
}
