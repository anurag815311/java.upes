import java.io.*;
import java.util.*;

public class FileOperations {
    public static void main(String[] args) throws IOException {
        // Step 1: Create file and write integers
        File file = new File("numbers.txt");
        PrintWriter writer = new PrintWriter(file);
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            writer.println(rand.nextInt(100) + 1); // Random integers between 1-100
        }
        writer.close();

        // Step 2: Read, sort, calculate sum and product
        Scanner reader = new Scanner(file);
        List<Integer> numbers = new ArrayList<>();
        while (reader.hasNextInt()) {
            numbers.add(reader.nextInt());
        }
        reader.close();

        Collections.sort(numbers);
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        long product = numbers.stream().mapToLong(Integer::longValue).reduce(1, (a, b) -> a * b);

        // Step 3: Write results to another file
        File resultFile = new File("result.txt");
        PrintWriter resultWriter = new PrintWriter(resultFile);
        resultWriter.println("Sorted List: " + numbers);
        resultWriter.println("Sum: " + sum);
        resultWriter.println("Product: " + product);
        resultWriter.close();
    }
}
