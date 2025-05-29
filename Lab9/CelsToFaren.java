import java.util.*;

public class CelsToFaren {
    /************************************************************************
     * Methods: main                                                        *
     * Created Date: 3 Apr, 2025                                            *
     * Guide By: Ms Esther                                                  *
     ************************************************************************/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double cels, faren;
        int choice;
        int con_type, data_type;
        do { 
            System.out.println("What conversion do you want to perform? ");
            System.out.println("\t(1) celsius to farenheit\n\t(2) farenheit to celsius");
            con_type = scanner.nextInt();

            System.out.println("What is your data type for the value you want to convert from, \n\t(1) int \n\t(2) double");
            data_type = scanner.nextInt();
            switch (con_type) {
                case 1:
                    if (data_type == 1) {
                        int celsius, fahrenheit;
                        System.out.println("Please enter celsius (int): ");
                        celsius = scanner.nextInt();
                        fahrenheit = CelsToFaren(celsius);
                        System.out.println(celsius + "C = " + fahrenheit + "F");
                    } else if (data_type == 2) {
                        double celsius, fahrenheit;
                        System.out.println("Please enter celsius (double): ");
                        celsius = scanner.nextDouble();
                        fahrenheit = CelsToFaren(celsius);
                        System.out.println(celsius + "C = " + fahrenheit + "F");
                    } else {
                        System.out.println("Error, invalid data type selected");
                    }
                    break;

                case 2:
                    if (data_type == 1) {
                        int celsius, fahrenheit;
                        System.out.println("Please enter Farenheit (int): ");
                        fahrenheit = scanner.nextInt();
                        celsius = FarenToCels(fahrenheit);
                        System.out.println(fahrenheit + "F = " + celsius + "C");
                    } else if (data_type == 2) {
                        double celsius, fahrenheit;
                        System.out.println("Please enter celsius (double): ");
                        fahrenheit = scanner.nextDouble();
                        celsius = FarenToCels(fahrenheit);
                        System.out.println(fahrenheit + "C = " + celsius + "F");
                    } else {
                        System.out.println("Error, invalid data type selected");
                    }
                    break;

                default:
                    System.out.println("Error, invalid item selected");
            }
        } while (con_type != 1 && con_type != 2);
        System.out.println("Program End!");
        scanner.close();
    }

    public static int CelsToFaren(int celsius) {
        int fahrenheit;
        fahrenheit = (int) ((9.0 / 5.0) * (double) celsius + 32.0);
        return fahrenheit;
    }

    public static double CelsToFaren(double celsius) {
        double fahrenheit;
        fahrenheit = (9.0 / 5.0) * celsius + 32.0;
        return fahrenheit;
    }

    public static int FarenToCels(int fahrenheit) {
        int celsius;
        celsius = (int) ((5.0 / 9.0) * (double) fahrenheit - 32.0);
        return celsius;
    }

    public static double FarenToCels(double fahrenheit) {
        double celsius;
        celsius = (5.0 / 9.0) * (fahrenheit - 32.0);
        return celsius;
    }

}