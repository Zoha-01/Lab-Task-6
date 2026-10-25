import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedStudentMap {
    public static void main(String[] args) {
        // 1. Create HashMap and convert it into a synchronized map
        Map<String, Integer> syncMap = Collections.synchronizedMap(new HashMap<>());
        // 2. Create an ExecutorService with three threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 3. Make each thread insert 100 unique student records
        for (int i = 1; i <= 3; i++) {
            final int threadId = i;
            executor.submit(() -> {
                for (int j = 1; j <= 100; j++) {
                    String studentKey = "Student_T" + threadId + "_" + j;
                    syncMap.put(studentKey, 50 + (j % 50));
                }
            });
        }