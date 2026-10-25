import java.util.HashMap;
import java.util.Map;

public class StudentMarks {
    public static void main(String[] args) {
        // Step 1: HashMap declaration
        HashMap<String, Integer> studentMap = new HashMap<>();
        // Step 2: Insert records
        studentMap.put("Ali", 85);
        studentMap.put("Ahmed", 90);
        studentMap.put("Sara", 78);
        studentMap.put("Usman", 92);
        studentMap.put("Zainab", 88);
        // Step 3: Print header
        System.out.println("--- All Student Records ---");
        // Step 4: Loop through records
        for (Map.Entry<String, Integer> entry : studentMap.entrySet()) {
            System.out.println("Student: " + entry.getKey() + " | Marks: " + entry.getValue());
        // Step 4: Loop through records
        for (Map.Entry<String, Integer> entry : studentMap.entrySet()) {
            System.out.println("Student: " + entry.getKey() + " | Marks: " + entry.getValue());
        }
        }

    }
}