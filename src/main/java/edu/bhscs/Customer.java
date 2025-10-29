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
  //  METHODS

  int pay(int price);

  void takeCake(Cake cake);
}
