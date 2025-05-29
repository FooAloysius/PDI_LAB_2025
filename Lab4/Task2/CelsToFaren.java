import java.util.*;

public class CelsToFaren {
    /************************************************************************
     * Methods: main                                                           *
     * Created Date: 3 Apr, 2025                                            *
     * Guide By: Ms Esther                                                  *
     ************************************************************************/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double cels, faren;
        char choice;
        do { 
            System.out.println("What conversion do you want to perform? ");
            System.out.println("\t(F) celcius to farenheit\n\t(C) farenheit to celcius");
            choice = scanner.next().charAt(0);
            if (choice == 'f' || choice == 'F') {
                System.out.println("Please enter Celcius: ");
                cels = scanner.nextDouble();
                faren = (9.0 / 5.0) * cels + 32;
                System.out.println(cels + "C = " + faren + "F");
            } else if (choice == 'c' || choice == 'C') {
                System.out.println("Please enter Farenheit: ");
                faren = scanner.nextDouble();
                cels = (9.0 / 5.0) * faren + 32;
                System.out.println(faren + "C = " + cels + "F");
            } else {
                System.out.println("Error, invalid item selected");
            }

        } while (choice != 'c' && choice != 'C' && choice != 'f' && choice != 'F');
        scanner.close();
    }

}