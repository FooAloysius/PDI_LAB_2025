import java.util.Scanner;
/*
Author: Esther
Date: 23/3/2025
Assertion: ExtendedCalculator class
*/
public class ExtendedCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int operation = -1;
        double num1, num2, result;

        // set minimum and maximum values values for user input validation
        double minValue = 0;
        double maxValue = 10;

        System.out.println("Welcome to the Basic Calculator!");

        //Do while loop to keep the menu running until user selects Exit
        do { 
            // Display menu
            System.out.println("\nSelect an operation: ");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("0. Exit");

            operation = scanner.nextInt();
            if (operation == 0) {
                System.out.println("Exiting the program.");
                break; // Exit the loop if user choose 0
            }

            // Loop to ensure first number is between 0 and 10
            do { 
                System.out.println("Enter first number (0 to 10): ");
                num1 = scanner.nextDouble();
                if(num1 < minValue || num1 > maxValue) {
                    System.out.println("Error: The number must be between 0 and 10. Please try again.");
                }
            } while (num1 < minValue || num1 > maxValue); // Keep looping until valid input

            // Loop to ensure second number is between 0 and 10
            do { 
                System.out.println("Enter second number (0 to 10): ");
                num2 = scanner.nextDouble();
                if(num2 < minValue || num2 > maxValue) {
                    System.out.println("Error: The number must be between 0 and 10. Please try again.");
                }
            } while (num2 < minValue || num2 > maxValue); // Keep looping until valid input

            // Perform the calculation based on the user's choice
            result = 0;
            switch (operation) {
                case 1:
                    result = num1 + num2;
                    System.out.println("Result: " + num1 + " + " + num2 + " = " + result);
                    break;
                case 2:
                    result = num1 - num2;
                    System.out.println("Result: " + num1 + " - " + num2 + " = " + result);
                    break;
                case 3:
                    result = num1 * num2;
                    System.out.println("Result: " + num1 + " * " + num2 + " = " + result);
                    break;
                case 4:
                    if (num2 != 0) {
                        result = num1 / num2;
                        System.out.println("Result: " + num1 + " / " + num2 + " = " + result);
                    } else {
                        System.out.println("Second number cannot be 0, please try again");
                    }
                    break; 
                default:
                    System.out.println("Invalid choice for the operation choosen. Please try again");
            }
        } while (operation != 0); // Continue looping until the user selects 0 to exit

        scanner.close();
    }
}