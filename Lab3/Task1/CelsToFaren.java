import java.util.Scanner;

public class CelsToFaren{

    public static void main(String[] args) {
        // Statements start here
        Scanner input = new Scanner(System.in); // Declare scanner
        System.out.println("Welcome to Temperature Converter");
        System.out.println("Which temperature scale are you converting from?");
        System.out.println("(C) elsius");
        System.out.println("(F) arenheit");
        char scale = input.next().charAt(0);

        double temperature, ans;
        
        if (scale == 'C' || scale == 'c') {
            System.out.println("Enter temperature in Celcius: ");
            temperature = input.nextDouble();
            ans = (temperature * 9 / 5) + 32;
            System.out.println(ans);
        } else if(scale == 'F' || scale == 'f') {
            System.out.println("Enter temperature in Farenheit: ");
            temperature = input.nextDouble();
            ans = (temperature - 32) * 5 / 9;
            System.out.println(ans);
        } else {
            System.out.println("Invalid input. Please enter 'C' or 'F'");
        }
        input.close();
    }
}