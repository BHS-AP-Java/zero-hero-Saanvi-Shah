// Saanvi Shah
// 9/26/25
// P2
// This is making the baker class

/*
 * DESCRIPTION: Creating a baker with years of experience and if they are certified
 * INPUT: years of experience, if they are certified
 * OUTPUT: A line saying the baker is baking the cake
 * EDGE CASE: None
 */

package edu.bhscs;

public class Baker {
  // fields and properties

  int experience; // in years
  boolean isCertified;

  // constructor
  /* I want the baker to eventually get
  certified after baking a certain amount of cakes. I don't know if I
  Should do this by saving the previous answers of the baker and making
  the first few cakes really bad and not what the person asked for or I
  should allow for multiple orders within the saeme run of the program
  and after a certain amount of cakes, the baker gets certified.
  */
  public Baker(int experience, boolean isCertified) {
    this.experience = experience;
    this.isCertified = isCertified;
  }

  // method
  public void bakeCake() {
    System.out.println("The baker is taking the order...");
    // I could add more details here about the baking process

  }
}
