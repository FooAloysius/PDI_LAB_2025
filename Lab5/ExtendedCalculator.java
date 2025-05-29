import java.util.Scanner;
/*
Author: Esther
Date: 23/3/2025
Purpose: A basic calculator program that will perform basic math operations
*/
public class ExtendedCalculator {
    /*
    Method: Main
    Date: 3/4/2025
    Import: none
    Export: none
    Purpose: Serves as the program's entry point. It controls the flow of the program by calling other methods.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Basic Calculator!");

        int choice;

        //Do while loop to keep the menu running until user selects Exit
        do { 
            // Display menu
            choice = displayMenu(scanner);

            if (choice != 0) {
                int[] num = new int[2];

                for (int i = 0; i < 2; i++) {
                    num[i] = getValideNumber(scanner);
                }

                double result = performOperation(choice, num);
                System.out.println("Result: " + result);

            } else {
                System.out.println("Exiting program. Thank you!");
            }
        } while (choice != 0); // Continue looping until the user selects 0 to exit

        scanner.close();
    }

    /*
    Method: displayMenu
    Date: 3/4/2025
    Import: scanner (Scanner)
    Export: choice
    Purpose: This method will display menu and allow user to enter their choice
     */
    public static int displayMenu(Scanner scanner) {
        System.out.println("\nSelect an operation: ");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("0. Exit");
        int choice = scanner.nextInt();
        return choice;
    }

    /*
    Method: getValidNumber
    Date: 3/4/2025
    Import: scanner (Scanner)
    Export: number (int)
    Purpose: This method will validate user input to ensude only number 0-10 is entered
    */
   public static int getValideNumber(Scanner scanner) {
    int number;
    do { 
        System.out.println("Enter a number (0-10): ");
        number = scanner.nextInt();
        if (number < 0 || number > 10) 
        {
            System.out.println("Invalid input! Please enter a number between 0 and 10.");
        }
    } while (number < 0 || number > 10);

    return number;
   }

   /*
   Method: performOperation
   Date: 3/4/2025
   Import: choice (int), num[] (int)
   Export: number (int)
   Purpose: This method will validate user input to ensure only the number 0 - 10 is entered
   */
  public static double performOperation(int choice, int[] num) {
    switch (choice) {
        case 1: // Adition
            return num[0] + num[1];
        case 2: // Subtraction
            return num[0] - num[1];
        case 3: // Multiplication
            return num[0] * num[1];
        case 4: // Division
            if(num[1] == 0) {
                System.out.println("Error: Division by zero is not allowed.");
                return 0;
            } else {
                return (double) num[0] / num[1];
            }
        default:
            System.out.println("Invalid choice.");
            return 0;
    }
  }
}