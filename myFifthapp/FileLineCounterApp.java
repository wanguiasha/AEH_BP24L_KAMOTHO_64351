import java.io.*;
import java.util.Scanner;

class FileLineCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Line Counter Program ===");

        // Ask user for input file path
        System.out.print("Enter the input file path: ");
        String inputFilePath = scanner.nextLine();

        File inputFile = new File(inputFilePath);

        // Check if file exists
        while (!inputFile.exists() || !inputFile.isFile()) {
            System.out.println("❌ The file doesn't exist or it's not a valid file. Please try again.");
            System.out.print("Enter the input file path: ");
            inputFilePath = scanner.nextLine();
            inputFile = new File(inputFilePath);
        }

        // Ask for output file path
        System.out.print("Enter the output file path: ");
        String outputFilePath = scanner.nextLine();

        int lineCount = 0;

        // Count lines in the input file
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
            }

            System.out.println("✅ Line count: " + lineCount);
        } catch (IOException e) {
            System.out.println("❌ Error reading input file.");
            return;
        }

        // Write result to the output file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            writer.write("Input File: " + inputFile.getName());
            writer.newLine();
            writer.write("Line Count: " + lineCount);
            System.out.println("✅ Result written to: " + outputFilePath);
        } catch (IOException e) {
            System.out.println("❌ Error writing to output file.");
        }

        scanner.close();
    }
}




