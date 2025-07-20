// Define abstraction: Write Java program that overrides methods (getUserValue() and displayUserDetail()).
// getUserValue() gets details (name, address, age) from user
// displayUserDetail() displays user details.

// Abstraction is a key concept in object-oriented programming (OOP)
// where only essential details are shown to the user, and unnecessary details are hidden.

import java.util.Scanner;

// Abstract class
abstract class User {
    String name;
    String address;
    int age;

    // Abstract methods
    abstract void getUserValue();
    abstract void displayUserDetail();
}

// Concrete subclass
class Details extends User {
    @Override
    void getUserValue() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your Name:");
        name = input.nextLine();

        System.out.println("Enter your Address:");
        address = input.nextLine();

        System.out.println("Enter your Age:");
        age = input.nextInt();
    }

    @Override
    void displayUserDetail() {
        System.out.println("\n======= User Details =======");
        System.out.println("Your Name: " + name);
        System.out.println("Your Address: " + address);
        System.out.println("Your Age: " + age);
    }
}

// Main class
public class AbstractionExample {
    public static void main(String[] args) {
        Details details = new Details(); // object creation
        details.getUserValue();          // calling method to get input
        details.displayUserDetail();     // displaying the values
    }
}
