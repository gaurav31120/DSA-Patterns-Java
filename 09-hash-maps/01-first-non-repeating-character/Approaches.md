# P001 — First Non-repeating Character

## Approach 01 — Frequency Map

### Idea

Use a `HashMap<Character, Integer>` to store the frequency of every character.

Then traverse the array again from left to right.

The first character whose frequency is exactly `1` is the first non-repeating character.

### Steps

1. Create a frequency map.
2. Traverse the array and count each character.
3. Traverse the array again.
4. If `frequency == 1`, return that index.
5. If no such character exists, return `-1`.

### Example

Input:

    ['a', 'b', 'c', 'a', 'b']

Frequency map:

    a → 2
    b → 2
    c → 1

Second traversal:

    index 0 → a → frequency 2
    index 1 → b → frequency 2
    index 2 → c → frequency 1

Answer:

    2

### Java Implementation

    import java.util.*;

    public class _01_FrequencyMap {

        // Time: O(n)
        // Space: O(k)

        static int nonRepeating(char[] arr) {

            Map<Character, Integer> freq = new HashMap<>();

            // Count frequency
            for (char ch : arr) {
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            }

            // Find first non-repeating character
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

### Complexity

- Time: O(n)
- Space: O(k)

where `k` is the number of distinct characters.

### Key Pattern

When the problem asks about:

- frequency
- duplicates
- occurrences
- counting

think:

    HashMap → value/character → frequency

And when the problem asks for the **first** occurrence satisfying a frequency condition, usually:

    First pass → count
    Second pass → preserve original order and find answer

    ----------------------------------------------------


## Approach 02 — Count Array

### Idea

Use a fixed-size frequency array instead of a `HashMap`.

Because the input contains lowercase English letters, there are only 26 possible characters.

Character-to-index mapping:

    'a' → 0
    'b' → 1
    'c' → 2
    ...
    'z' → 25

The conversion is:

    ch - 'a'

### Steps

1. Create `int[26]`.
2. Count the frequency of every character.
3. Traverse the original array from left to right.
4. Check whether the current character has frequency `1`.
5. Return its original index.
6. Return `-1` if no such character exists.

### Example

Input:

    ['a', 'b', 'c', 'a', 'b']

Frequency:

    a → 2
    b → 2
    c → 1

Second traversal:

    index 0 → a → 2
    index 1 → b → 2
    index 2 → c → 1

Answer:

    2

### Java Implementation

    public class _02_CountArray {

        // Time: O(n)
        // Space: O(1)

        static int nonRepeating(char[] arr) {

            int[] freq = new int[26];

            // Count frequency
            for (char ch : arr) {
                freq[ch - 'a']++;
            }

            // Find first non-repeating character
            for (int i = 0; i < arr.length; i++) {
                if (freq[arr[i] - 'a'] == 1) {
                    return i;
                }
            }

            return -1;
        }
    }

### Complexity

- Time: O(n)
- Space: O(1)

### Key Learning

Use a frequency array when the possible values/characters come from a small fixed range.

HashMap:

    character → frequency

Count Array:

    character → array index → frequency