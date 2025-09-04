// Write a program to take two integers from the user and perform division,
// catching the relevant exception.

import java.util.Scanner;

class DivisionProgram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            System.out.println("Enter first number: ");
            int a = scan.nextInt();

            System.out.println("Enter second number: ");
            int b = scan.nextInt();

            int ans = a / b;
            System.out.println("Result: " + ans);
        } 
        catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } 
        catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid integers.");
        } 
        finally {
            scan.close();
        }
    }
}

