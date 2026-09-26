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

------------------------------------

# P005 — Group Anagrams

## Approach 01 — Frequency Map

### Idea

Anagrams contain the same characters with the same frequencies.

For example:

    "eat"
    "tea"
    "ate"

All three contain:

    a → 1
    e → 1
    t → 1

So we create a frequency-based key for every word.

### Steps

1. Create an integer array of size `26`.
2. Count every character in the current word.
3. Convert the frequency array into a String key.
4. Use the key in a `HashMap`.
5. Add the original word to the list associated with that key.
6. Return all groups.

### HashMap Structure

    Map<String, List<String>>

The key represents the character-frequency pattern.

The value contains all words with that pattern.

### Example

    "eat" → frequency pattern
    "tea" → same frequency pattern
    "ate" → same frequency pattern

Therefore:

    same key → same group

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

            Map<String, List<String>> anagramGroups =
                    new HashMap<>();

            for (String word : words) {

                int[] characterFrequency = new int[26];

                for (char ch : word.toCharArray()) {
                    characterFrequency[ch - 'a']++;
                }

                String frequencyKey =
                        Arrays.toString(characterFrequency);

                anagramGroups.putIfAbsent(
                        frequencyKey,
                        new ArrayList<>()
                );

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

            List<List<String>> result =
                    groupAnagrams(words);

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
- `k` = average word length

### Key Learning

Anagrams have the same character frequencies.

    word
      ↓
    character frequencies
      ↓
    same key
      ↓
    same HashMap group


---

## Approach 02 — Sorted Key

### Idea

Instead of building a frequency key, sort the characters of every word.

Anagrams become identical after sorting.

For example:

    eat → aet
    tea → aet
    ate → aet

Therefore, `aet` can be used as the key for all three words.

### Steps

1. Convert the word to a character array.
2. Sort the character array.
3. Convert the sorted array back to a String.
4. Use the sorted String as the HashMap key.
5. Add the original word to that key's list.
6. Return all groups.

### Example

Input:

    ["eat", "tea", "tan", "ate", "nat", "bat"]

Sorted keys:

    eat → aet
    tea → aet
    tan → ant
    ate → aet
    nat → ant
    bat → abt

Groups:

    aet → ["eat", "tea", "ate"]
    ant → ["tan", "nat"]
    abt → ["bat"]

### Important Java Syntax

Convert String to character array:

    char[] characters = word.toCharArray();

Sort the characters:

    Arrays.sort(characters);

Convert the sorted character array back to String:

    String sortedKey = new String(characters);

### Java Implementation

    // Time Complexity: O(n * k log k)
    // Space Complexity: O(n * k)

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

    public class _02_SortedKey {

        static List<List<String>> groupAnagrams(String[] words) {

            Map<String, List<String>> anagramGroups =
                    new HashMap<>();

            for (String word : words) {

                char[] characters = word.toCharArray();

                Arrays.sort(characters);

                String sortedKey = new String(characters);

                anagramGroups.putIfAbsent(
                        sortedKey,
                        new ArrayList<>()
                );

                anagramGroups.get(sortedKey).add(word);
            }

            return new ArrayList<>(
                    anagramGroups.values()
            );
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

            List<List<String>> result =
                    groupAnagrams(words);

            System.out.println(
                    "Grouped Anagrams: " + result
            );

            // Expected Output:
            // Grouped Anagrams: [[eat, tea, ate], [tan, nat], [bat]]
            // Order may be different.
        }
    }

### Complexity

- Time Complexity: O(n * k log k)
- Space Complexity: O(n * k)

where:

- `n` = number of words
- `k` = average word length

### Key Learning

The important idea is:

    Anagrams
       ↓
    sort characters
       ↓
    same sorted string
       ↓
    same HashMap key
       ↓
    same group