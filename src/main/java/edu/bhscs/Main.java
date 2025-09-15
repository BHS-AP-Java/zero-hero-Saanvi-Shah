// Saanvi Shah
// P2
// Variables: Replacement is the gateway to abstractions
// 9/15/25

/*
 * DESCRIPTION: This excercise is about learning about variables, constants, and types
 * INPUT: We don't know yet :(
 * OUTPUT: Some cool lines in the command terminal thing
 * EDGE CASE: Every case is an edge case
 */

package edu.bhscs;
class Main{

  // this is an example of a 'char' constant
  // because it is global, it should be in capital letters
  public static final char A = 'a';

  public static void main(String[] args){

    int someNumber = 67;

    System.out.println("67!" + A + someNumber);
    System.out.print(A + "?" + A + someNumber);
    System.out.print(A + A + someNumber);
    System.out.println();
    System.out.println("this is neet");
    System.out.println();
    System.out.println();
    System.out.println("OK I am done");
    

  }

}