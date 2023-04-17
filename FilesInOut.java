import java.io.*;
import java.util.*;

public class FilesInOut {

    public static void main(String[] args) {

        //set the defualt for these things and find the imput and output file neames, ooooo you get to see the file paths on my pc arnt you lucky
        boolean upperCase = false; 
        String inputFile = "C:\\Users\\Peter Eve\\Downloads\\input.txt"; 
        String outputFile = "C:\\Users\\Peter Eve\\Documents\\WriteFile\\Output.txt"; 

        // looks through comand line and parses, first is input second is the output and third is if you wanna be fancy and do uppercase 
        if (args.length >= 2) {
            inputFile = args[0]; 
            outputFile = args[1]; 
            if (args.length >= 3 && args[0].equals("-u")) {
                upperCase = true; 
            }
        }

        // Scans input and output file streams to see if they are actually there and if this could or should work(hint it never does)
        Scanner scanner = null;
        PrintWriter writer = null;
        try {
            scanner = new Scanner(new File(inputFile));
            writer = new PrintWriter(outputFile);
        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }

        // scans through the input file, one line at a time because apparently throwing an ass load of ram at the problem is "cheating"
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            // diffent cases if you wanna be fancy 
            if (upperCase) {
                line = line.toUpperCase();
            } else {
                line = toTitleCase(line);
            }

            // writes the line it just read to the output file after being formatted, and then the while loop does it again
            writer.println(line);
        }

        // closes scan and write functions
        scanner.close();
        writer.close();
    }

    // this bit converts strings to tile case 
    private static String toTitleCase(String input) {
        StringBuilder titleCase = new StringBuilder();
        boolean nextTitleCase = true;

        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            } else {
                c = Character.toLowerCase(c);
            }
            titleCase.append(c);
        }

        return titleCase.toString();
    }
}
