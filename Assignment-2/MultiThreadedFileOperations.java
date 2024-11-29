
//question 3 solution
import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class MultiThreadedFileOperations {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        File file = new File("numbers.txt");
        File resultFile = new File("result.txt");

        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Task 1: Write random numbers to file
        Runnable writeTask = () -> {
            try (PrintWriter writer = new PrintWriter(file)) {
                Random rand = new Random();
                for (int i = 0; i < 100; i++) {
                    writer.println(rand.nextInt(100) + 1);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        // Task 2: Read, sort, calculate sum and product
        Callable<Map<String, Object>> computeTask = () -> {
            List<Integer> numbers = new ArrayList<>();
            try (Scanner reader = new Scanner(file)) {
                while (reader.hasNextInt()) {
                    numbers.add(reader.nextInt());
                }
            }
            Collections.sort(numbers);
            int sum = numbers.stream().mapToInt(Integer::intValue).sum();
            long product = numbers.stream().mapToLong(Integer::longValue).reduce(1, (a, b) -> a * b);
            Map<String, Object> results = new HashMap<>();
            results.put("sortedList", numbers);
            results.put("sum", sum);
            results.put("product", product);
            return results;
        };

        // Task 3: Write results to file
        Callable<Void> writeResultsTask = () -> {
            Map<String, Object> results = executor.submit(computeTask).get();
            try (PrintWriter writer = new PrintWriter(resultFile)) {
                writer.println("Sorted List: " + results.get("sortedList"));
                writer.println("Sum: " + results.get("sum"));
                writer.println("Product: " + results.get("product"));
            }
            return null;
        };

        executor.submit(writeTask).get();
        executor.submit(writeResultsTask).get();

        executor.shutdown();
    }
}
