import java.util.Scanner;

public class CelsToFaren{

    public static void main(String[] args) {
        // Statements start here
        Scanner input = new Scanner(System.in); // Declare scanner
        System.out.println("Hello, please enter a Celcius value (whole number) :");
        int celcius = input.nextInt();
        int farenheit = (9/5) * celcius + 32;
        System.out.print(celcius + " C = " + farenheit + " F");
        input.close();
    }
}