import java.io.*;
import java.util.*;

public class StudentManager {
   private static final int MAX_STUDENTS = 20;
    private static Student[] studentArray = new Student[MAX_STUDENTS];
    private static int numStudents = 0;


 // Method to validate name (Non-empty and no spaces)
    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }
     
 // Method to validate student ID (Within a valid range)
    public static boolean isValidStudentID(int id) {
        return id >= 700000000 && id <= 700099999;
    }
 // Main method to handle menu options
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            // Display the menu
            System.out.println("Select an option:");
            System.out.println("1. Import student data from CSV.");
            System.out.println("2. Calculate test mark average.");
            System.out.println("3. View all student data.");
            System.out.println("0. Exit the program.");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the filename to import student data: ");
                    String filename = scanner.nextLine();
                    ReadFile(filename);
                    break;

                case 2:
                    double average = calculateAverage();
                    System.out.println("The average test mark is: " + average);
                    break;

                case 3:
                    displayAllStudents();
                    break;

                case 0:
                    System.out.println("Exiting the program.");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please select again.");
                    break;
            }
        }

        scanner.close();
    }
    // Method to calculate the average of test marks
    public static double calculateAverage() {
        String students = ReadFile("ListName.csv");
        String[] stud = students.trim().split(",");
        System.out.println(stud[0]);
        // if (numStudents == 0) {
        //     System.out.println("No students to calculate average.");
        //     return 0.0;
        // }

        // double sum = 0.0;
        // for (int i = 0; i < numStudents; i++) {
        //     sum += studentArray[i].getMark();
        // }
        double sum = 2.93453825;
        return sum / numStudents;
    }

    // Method to display all student data
    public static void displayAllStudents() {
        if (numStudents == 0) {
            System.out.println("No student data available.");
        } else {
            for (int i = 0; i < numStudents; i++) {
                System.out.println(studentArray[i].toString());
            }
        }
    }
   
    public static String ReadFile (String theFile) {
        FileInputStream fileStream = null;
        InputStreamReader isr;
        BufferedReader bufRdr;
        int lineNum;
        String line = null;
        try {
            fileStream = new FileInputStream(theFile);
            isr = new InputStreamReader(fileStream);
            bufRdr = new BufferedReader(isr);
            lineNum = 0;
            line = bufRdr.readLine();
            while (line != null) {
                lineNum++;
                System.out.println(line);
                line = bufRdr.readLine();
            }
            fileStream.close();
        } catch (IOException errorDetails) {
            if (fileStream != null) {
                try {
                    fileStream.close();
                } catch (IOException ex2) {
                }
            }
            System.out.println("Error in fileProcessing: " + errorDetails.getMessage());
        }
       return line;
    }
    
}
