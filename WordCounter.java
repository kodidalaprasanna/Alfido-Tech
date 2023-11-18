import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    public static void main(String[] args) {
        // Specify the path to the text file
        String filePath = "abc.txt";

        try {
            // Read the text file
            String content = readFile(filePath);

            // Count the number of words
            int wordCount = countWords(content);

            // Calculate the average word length
            double averageWordLength = calculateAverageWordLength(content);

            // Display the results
            System.out.println("Word Count: " + wordCount);
            System.out.println("Average Word Length: " + averageWordLength);

            // You can also perform additional analyses, such as word frequency
            Map<String, Integer> wordFrequency = calculateWordFrequency(content);
            System.out.println("Word Frequency: " + wordFrequency);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }

        return content.toString();
    }

    private static int countWords(String text) {
        String[] words = text.split("\\s+");
        return words.length;
    }

    private static double calculateAverageWordLength(String text) {
        String[] words = text.split("\\s+");
        int totalLength = 0;

        for (String word : words) {
            totalLength += word.length();
        }

        return (double) totalLength / words.length;
    }

    private static Map<String, Integer> calculateWordFrequency(String text) {
        String[] words = text.split("\\s+");
        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        return wordFrequency;
    }
}
