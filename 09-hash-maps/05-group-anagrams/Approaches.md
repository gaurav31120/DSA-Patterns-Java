# P005 — Group Anagrams

## Approach 01 — Frequency Map

### Idea

Anagrams contain exactly the same characters with the same frequencies.

For example:

    "eat"
    "tea"
    "ate"

All three contain:

    a → 1
    e → 1
    t → 1

Therefore, they can use the same key.

For every word:

1. Create a frequency array of size `26`.
2. Count every character.
3. Convert the frequency array into a `String` key.
4. Use that key in a `HashMap`.
5. Store all words with the same key in the same list.

### HashMap Structure

    Map<String, List<String>>

The key represents the character-frequency pattern.

The value contains all words having that same pattern.

### Example

Input:

    ["eat", "tea", "tan", "ate", "nat", "bat"]

For `eat`:

    a → 1
    e → 1
    t → 1

For `tea`:

    a → 1
    e → 1
    t → 1

Both have the same frequency pattern, so both use the same key.

The resulting groups are:

    ["eat", "tea", "ate"]
    ["tan", "nat"]
    ["bat"]

### Java Implementation

    // Time Complexity: O(n * k)
    // Space Complexity: O(n * k)

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

    public class _01_FrequencyMap {

        static List<List<String>> groupAnagrams(String[] words) {

            Map<String, List<String>> groups = new HashMap<>();

            for (String word : words) {

                int[] characterFrequency = new int[26];

                // Count frequency of each character
                for (char ch : word.toCharArray()) {
                    characterFrequency[ch - 'a']++;
                }

                // Create key from frequency pattern
                String key = Arrays.toString(characterFrequency);

                // Create group if key does not exist
                groups.putIfAbsent(key, new ArrayList<>());

                // Add word to the group
                groups.get(key).add(word);
            }

            return new ArrayList<>(groups.values());
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

            System.out.println(
                    "Grouped Anagrams: " + result
            );

            // Expected Output:
            // Grouped Anagrams: [[eat, tea, ate], [tan, nat], [bat]]
            // Order may be different.
        }
    }

### Complexity

- Time Complexity: O(n * k)
- Space Complexity: O(n * k)

where:

- `n` = number of words
- `k` = maximum/average word length

### Key Learning

Anagrams can be identified by their character frequencies.

The important pattern is:

    word
      ↓
    frequency
      ↓
    common key
      ↓
    HashMap
      ↓
    group anagrams

### Important Java Syntax

    Map<String, List<String>>

means:

    String key → List<String> value

`putIfAbsent()` creates the list only when the key does not already exist.

`map.get(key).add(word)` adds the current word to the existing group.