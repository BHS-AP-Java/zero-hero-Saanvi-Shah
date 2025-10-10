package edu.bhscs;

public class Burger {
  //fields and properties
  String size;
  String bunType;
  int burgerWeight;
  boolean cheese;

  //contructors
  public Burger(String size, String bunType, int burgerWeight, boolean cheese) {
    this.size = size;
    this.bunType = bunType;
    this.cheese = cheese;
    this.burgerWeight = burgerWeight;

  }

  //methods
  public void showBurger() {
    System.out.println("\nHere is your burger:");


}
  public void beEaten()
  {
    System.out.println("Nom nom nom! The burger is delicious!");
  }

  public void drawBurger()
  {
String s = "            \r\n" +
 "                     \r\n" +
 "      _..----.._       \r\n" +
 "    .'     o    '.      \r\n" +
 "   /   o       o  \\    \r\n" +
  "  |o        o     o|   \r\n" +
 "  /'-.._o     __.-'\\   \r\n" +
 "  \\      `````     /  \r\n" +
  "  |``--........--'`|    \r\n" +
  "  \\               /                \r\n" +
  "     `'----------'`                   \r\n" +
  "---------------------------------------\r\n" +
 "     .-/-.                       \r\n" +
 "   | -'|                      \r\n" +
    "  |   |                      \r\n" +
     " |   |   .-\"\"\"\"-.           \r\n" +
      "\\___/  /' .  '. \\   \\|/\\// \r\n" +
       "     (`-..:...-')  |`\"\"`| \r\n" +
        "     ;-......-;   |    | \r\n" +
         "     '------'    \\____/ \r\n" +
"------------------------------------------------ \r\n";
    System.out.println(s);

  }
  }




