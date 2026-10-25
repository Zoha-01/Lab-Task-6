import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentStudentMap {
    public static void main(String[] args) {
        // 1. Create a ConcurrentHashMap
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();

        int numberOfThreads = 5;
        int recordsPerThread = 1000;
        int expectedEntries = numberOfThreads * recordsPerThread;
        // 2. Create an ExecutorService with five threads
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        // Record start time to measure execution time
        long startTime = System.currentTimeMillis();
        // 3. Make each thread insert 1,000 unique student records
        for (int i = 1; i <= numberOfThreads; i++) {
            final int threadId = i;
            executor.submit(() -> {
                for (int j = 1; j <= recordsPerThread; j++) {
                    String studentKey = "Student_T" + threadId + "_" + j;
                    concurrentMap.put(studentKey, 60 + (j % 40));
                }
            });
        }
        // Wait for all threads to finish execution
        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
        // 4. Retrieve values associated with inserted keys
        int sampleVal1 = concurrentMap.get("Student_T1_1");
        int sampleVal2 = concurrentMap.get("Student_T5_1000");

        // Record end time
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        // 5 & 6. Display metrics
        System.out.println("--- ConcurrentHashMap Execution Summary ---");
        System.out.println("Number of Threads: " + numberOfThreads);
        System.out.println("Expected Entries: " + expectedEntries);
        System.out.println("Actual Entries: " + concurrentMap.size());
        System.out.println("Sample Retrieval T1_1 Marks: " + sampleVal1);
        System.out.println("Sample Retrieval T5_1000 Marks: " + sampleVal2);
        System.out.println("Total Execution Time: " + executionTime + " ms");
    }
}