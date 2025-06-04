import java.io.*;
import java.nio.file.*;
import java.util.*;

public class app {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Path inputFile = null;
        Path outputFile = null;

        // Step 1: Get a valid input file path
        while (true) {
            System.out.print("Enter the path to the input text file: ");
            String inputPath = scanner.nextLine();
            inputFile = Paths.get(inputPath);

            if (Files.exists(inputFile)) {
                break;
            } else {
                System.out.println("The file does not exist. Please try again.");
            }
        }

        // Step 2: Get the output file path (overwrite or create new)
        System.out.print("Enter the path to the output file: ");
        String outputPath = scanner.nextLine();
        outputFile = Paths.get(outputPath);

        try {
            // Step 3: Read the file and count words
            List<String> lines = Files.readAllLines(inputFile);
            Map<String, Integer> wordCounts = new HashMap<>();
            int totalWords = 0;

            for (String line : lines) {
                String[] words = line.toLowerCase().split("\\W+"); // Split on non-word characters
                for (String word : words) {
                    if (!word.isEmpty()) {
                        totalWords++;
                        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Step 4: Display results in console
            System.out.println("Total words: " + totalWords);
            System.out.println("Word frequencies:");
            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            // Step 5: Save results to the output file
            try (BufferedWriter writer = Files.newBufferedWriter(outputFile)) {
                writer.write("Input File: " + inputFile.getFileName() + "\n");
                writer.write("Total Words: " + totalWords + "\n");
                writer.write("Word Frequencies:\n");
                for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                    writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
                }
            }

            System.out.println("Results have been written to: " + outputFile.toAbsolutePath());

        } catch (IOException e) {
            System.out.println("An error occurred during file processing.");
            e.printStackTrace();
        }
    }
}

