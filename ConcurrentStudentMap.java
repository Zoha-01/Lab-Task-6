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