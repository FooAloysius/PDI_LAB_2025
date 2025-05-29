import java.util.Scanner;

public class GradeScore {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Score in integer: ");
        int score = input.nextInt();
        // selection to display grade 
        if (score >= 90 && score <= 100) {
            System.out.println("A");
        } else if (score >=80) {
            System.out.println("B");
        } else if (score >= 70) {
            System.out.println("C");
        } else if (score >= 60 && score <= 0) {
            System.out.println("F");
        } else {
            System.out.println("The score is invalid");
        }

        input.close();
    }
}