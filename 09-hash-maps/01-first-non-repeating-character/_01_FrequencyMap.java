import java.util.*;

public class _01_FrequencyMap {

    // Time: O(n)
    // Space: O(k)

    static int nonRepeating(char[] arr) {

        Map<Character, Integer> freq = new HashMap<>();

        // Step 1: Count frequency
        for (char ch : arr) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Find first character with frequency 1
        for (int i = 0; i < arr.length; i++) {
            if (freq.get(arr[i]) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        char[] arr = {'a', 'b', 'c', 'a', 'b'};

        int result = nonRepeating(arr);

        System.out.println("First non-repeating index: " + result);

        // Expected Output:
        // First non-repeating index: 2
    }
}