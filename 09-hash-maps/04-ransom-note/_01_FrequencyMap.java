// Time Complexity: O(n + m)
// Space Complexity: O(k)

import java.util.HashMap;
import java.util.Map;

public class _01_FrequencyMap {

    static boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> freq = new HashMap<>();

        // Count characters in magazine
        for (char ch : magazine.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        // Use characters for ransom note
        for (char required : ransomNote.toCharArray()) {

            int available = freq.getOrDefault(required, 0);

            if (available == 0) {
                return false;
            }

            freq.put(required, available - 1);
        }

        return true;
    }

    public static void main(String[] args) {

        String ransomNote = "aa";
        String magazine = "aab";

        boolean result = canConstruct(ransomNote, magazine);

        System.out.println("Can construct ransom note: " + result);

        // Expected Output:
        // Can construct ransom note: true
    }
}