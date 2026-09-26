// Time Complexity: O(n * k log k)
// Space Complexity: O(n * k)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _02_SortedKey {

    static List<List<String>> groupAnagrams(String[] words) {

        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String word : words) {

            // Convert word into character array
            char[] characters = word.toCharArray();

            // Sort characters to create the anagram key
            Arrays.sort(characters);

            String sortedKey = new String(characters);

            // Create a group if the key does not exist
            anagramGroups.putIfAbsent(
                    sortedKey,
                    new ArrayList<>()
            );

            // Add the original word to its group
            anagramGroups.get(sortedKey).add(word);
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