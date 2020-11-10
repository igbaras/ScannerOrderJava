import java.text.DecimalFormat;
import java.util.Scanner;
class tian{
public static void main(String[] args) {
    DecimalFormat df = new DecimalFormat("#.##");
    Scanner keyboard = new Scanner(System.in);

    //  Variables
    String firstName; // first name of user
    char crustType;
    String crust; // name of crust
    int inches; // pizza size
    double cost = 0.0; // pizza cost
    final double taxRate = 0.08; // amount tax owed
    double tax; // tax amount
    double total; // total of pizza + toppings
    double lastTotal; // total of everything
    int numberOfToppings = 0;
    String toppings = "Cheese";

    // Prompts for name & determines discount
    System.out.println("Enter your name: ");
    firstName = keyboard.nextLine();

    //Prompts for distance 
    double distance = 0;
    double deliveryfee = 0;
    System.out.println("Please enter total distance in miles from pizza shop (0 for in store pickup):");
    distance = keyboard.nextDouble();
    if (distance == 0) {
        deliveryfee = 0;
        System.out.println("There is no delivery fee.");
    } else if (distance > 1) {
        deliveryfee = ((distance * 0.5) + 2);
        System.out.println("Your delivery fee is: $" + df.format(deliveryfee));
    } else if (distance > 0) {
        deliveryfee = 2.00;
        System.out.println("Your delivery fee is: $" + df.format(deliveryfee));
    }

    // Prompts for pizza size
    System.out.print("What size of pizza would you like (diameter in inches)? (10,   12, 14, or 16) ");
    inches = keyboard.nextInt();
    if (inches == 10) {
        cost = 10.99;
    } else if (inches == 12) {
        cost = 12.99;
    } else if (inches == 14) {
        cost = 14.99;
    } else if (inches == 16) {
        cost = 16.99;
    } else if (inches != 10 && inches != 12 && inches != 14 && inches != 16) {
        System.out.println("The number you have entered is illegal, your pizza size will    be set to 12 inches. ");
        cost = 12;
    }
    keyboard.nextLine();

    // Prompts user for type of crust
    System.out.print("What type of crust do you want? (H)and-Tossed, (T)hin-crust, or (D)eep-dish (enter H, T, or D,): ");
    crustType = keyboard.nextLine().charAt(0);

    if (crustType == 'H' || crustType == 'h') {
        crust = "Hand-Tossed";
    } else if (crustType == 'T' || crustType == 't') {
        crust = "Thin-Crust";
    } else if (crustType == 'D' || crustType == 'd') {
        crust = "Deep-Dish";
    } else if (crustType != 'H' && crustType != 'h' && crustType != 'T' && crustType != 't' && crustType != 'D' && crustType != 'd') {
        System.out.println("The crust type you have entered is illegal, your crust type will be set to hand-tossed. ");
    }
    crust = "Hand-Tossed";

    // Prompts user for additonal toppings
    System.out.println("All pizzas come with cheese.");
    System.out.println("Additional toppings are $1.25 each, choose from Pepperoni or Sausage.");

    // Pepperoni
    System.out.println("Do you want Pepperoni? (Y/N)");
    numberOfToppings = keyboard.nextLine().charAt(0);
    if (numberOfToppings == 'Y' || numberOfToppings == 'y') {
        numberOfToppings = numberOfToppings + 1;
        toppings = toppings + " and Pepperoni";
    } else {
    }

    //Sausage
    System.out.println("Do you want Sausage? (Y/N)");
    numberOfToppings = keyboard.nextLine().charAt(0);
    if (numberOfToppings == 'Y' || numberOfToppings == 'y') {
        numberOfToppings = numberOfToppings + 1;
        toppings = toppings + " and Sausage";
    } else {
    }

    // Calculations
    System.out.println(cost);
    System.out.println(numberOfToppings);
    System.out.println(deliveryfee);
    total = (cost) + (numberOfToppings * 1.25) + (deliveryfee);
    tax = total * taxRate;
    lastTotal = total * (1 + taxRate);

    // Payment Confirmation
    System.out.println(firstName + ", here is your order:");
    System.out.println(inches + " inch pizza");
    System.out.println(crust + ", " + toppings);
    System.out.println("Order Cost: $" + df.format(total));
    System.out.println("Tax: $" + df.format(tax));
    System.out.println("Total Due: $" + df.format(lastTotal));
}
}
