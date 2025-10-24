// Saanvi Shah
// 10/07/25
// P2
// This is making the Customer interface

/*
 * DESCRIPTION: The Customer interface is used by the Baker class to interact with a customer. The
 * Player class implements this interface since every player is also a customer.
 *
 * INPUT: Payment amount and the cake they receive.
 *
 * OUTPUT: Methods are implemented in the Player class to pay for and receive cakes.
 */

package edu.bhscs;

public interface Customer {
  // ---------------- METHODS ----------------

  // pay(): the customer pays the given amount and returns how much was paid
  int pay(int price);

  // takeCake(): the customer receives the cake baked by the baker
  void takeCake(Cake cake);
}
