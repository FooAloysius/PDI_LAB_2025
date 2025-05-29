import java.util.Scanner;

public class AIChatbot{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Welcome to Ai ChatBot! Type a message (or 'bye' to exit): ");

        while (true) {
            System.out.print("Enter a message: ");
            String userMessage = input.nextLine().toLowerCase();

            if(userMessage.contains("hello")) {
                System.out.println("Chatbot: Hey there! How can I help?");
            }
            else if(userMessage.contains("joke")) {
                System.out.println("Chatbot: Why don't programmers like nature? Too many bugs!");
            }
            else if(userMessage.contains("how are you")) {
                System.out.println("Chatbot: I'm just a chatbot, but I'm doing great!");
            }
            else if(userMessage.contains("bye")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Chatbot: Sorry! I cannot understand what you type! ");
            }
        }
        input.close();
    }
}