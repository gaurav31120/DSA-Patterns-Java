// Time Complexity: O(n * k)
// Space Complexity: O(n * k)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _01_FrequencyMap {

    static List<List<String>> groupAnagrams(String[] words) {

        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String word : words) {

            int[] characterFrequency = new int[26];

            // Count characters in the current word
            for (char ch : word.toCharArray()) {
                characterFrequency[ch - 'a']++;
            }

            // Frequency pattern becomes the key
            String frequencyKey = Arrays.toString(characterFrequency);

            // Create a group if this key does not exist
            anagramGroups.putIfAbsent(
                    frequencyKey,
                    new ArrayList<>()
            );

            // Add word to its anagram group
            anagramGroups.get(frequencyKey).add(word);
        }

        return new ArrayList<>(anagramGroups.values());
    }

    public static void main(String[] args) {

        String[] words = {
                "eat",
                "tea",
                "tan",
                "ate",
                "nat",
                "bat"
        };

        List<List<String>> result = groupAnagrams(words);

        System.out.println("Grouped Anagrams: " + result);

        // Expected Output:
        // Grouped Anagrams: [[eat, tea, ate], [tan, nat], [bat]]
        // Order may be different.
    }
}