import java.io.*;
import java.util.*;

public class SortByName {
    public static void main(String[] args) {
        String FileName = "input.csv";
        List<String[]> records = new ArrayList<>();

        // Read the csv
        try (BufferedReader reader = new BufferedReader(new FileReader(FileName))) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] parts = line.split(",",2); // seperate to ID and Name
                if(parts.length == 2) {
                    records.add(parts);
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        // Sort by name
        records.sort(Comparator.comparing(record -> record[1]));

        // print sorted list
        for (String[] record: records) {
            System.out.println(record[0] + ", " + record[1]);
        }
    }
}