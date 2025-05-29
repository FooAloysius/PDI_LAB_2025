
import java.io.*;
import java.util.*;

public class StudentManager {

    private  static final int MAX_STUDENT=20;
    private static Student[] students =new Student[MAX_STUDENT];
    private static int studentCount =0;
     
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);

        int option;

        do { 
            System.out.println("\nSelect an option:");
            System.out.println("1. Import student data from CSV.");
            System.out.println("2. Calculate test mark average.");
            System.out.println("3. View all student data.");
            System.out.println("0. Exit the program.");
            System.out.println("Your choice:");
            option= scanner.nextInt();
            scanner.nextLine();  


            switch (option){
                case 1:
                    System.out.println("Enter CSV file name:");
                    String fileName= scanner.nextLine();
                    importStudents(fileName);
                    break;

                case 2:
                    System.out.printf("Average Test Mark: %.2f%%\n", calcAverage()); //to format to 2 decimal points
                    break;
                case 3:
                    viewStudents();
                    break;

                case 0:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid option");
            }       
            
        } while (option!=0);
        
    }

    private static void importStudents(String fileName){
        studentCount=0;
        try(BufferedReader br=new BufferedReader(new FileReader(fileName))){
            String line;
            while((line =br.readLine())!= null && studentCount < MAX_STUDENT){
                if(line.trim().isEmpty() || line.contains(" ,") || line.contains(", ") || !line.contains(",")){
                    continue;//invalid line
                }

                String[] parts =line.split(",");
                if(parts.length!=3){
                    continue;

                }
                try {
                    int id=Integer.parseInt(parts[0].trim());
                    String name=parts[1].trim();
                    double mark =Double.parseDouble(parts[2].trim());

                    students[studentCount++]= new Student(id, name, mark);

                } catch (NumberFormatException e) {
                    // 
                }
            }

            if (studentCount ==0){
                System.out.println("No valid student data found");

            }

        }catch(IOException e){
            System.out.println("File error:"+ e.getMessage());
        }

    }

    private static double calcAverage(){
        if(studentCount==0){
            return 0.0;
        }

        double sum=0;
        for (int i=0; i<studentCount; i++){
            sum += students[i].getMark();


        }
        return sum/studentCount;
    }
    private static void viewStudents(){
   
       for (int i=0; i<studentCount; i++){
            System.out.println(students[i]);
        }
    }

}