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