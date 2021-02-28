import au.com.bytecode.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        //Build reader instance
        //Read data.csv
        //Default seperator is comma
        //Default quote character is double quote
        //Start reading from line number 2 (line numbers start from zero)
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader("data/movementList.csv"), ',' , '"' , 1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Read CSV line by line and use the string array as you want
        String[] nextLine;
        Double sumRevenue = 0.0;
        Double sumExpenses = 0.0;
        while ((nextLine = reader.readNext()) != null) {
            if (nextLine != null) {
                //Verifying the read data here
                System.out.println(Arrays.toString(nextLine));
                sumRevenue += Double.parseDouble(nextLine[6]);
                //sumExpenses += Double.parseDouble(nextLine[7]);
            }
        }
        System.out.println(sumRevenue);
    }
}
