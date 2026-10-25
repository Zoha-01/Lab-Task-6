import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SynchronizedStudentMap {
    public static void main(String[] args) {
        // Step 1: Initialize Synchronized Map
        Map<String, Integer> syncMap = Collections.synchronizedMap(new HashMap<>());
        System.out.println("Synchronized Map initialized successfully with size: " + syncMap.size());
    }
}