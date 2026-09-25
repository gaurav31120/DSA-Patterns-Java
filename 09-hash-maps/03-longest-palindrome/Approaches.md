# P003 — Longest Palindrome

## Approach 01 — Frequency Map

### Idea

Use a `HashMap` to count the frequency of every character.

A palindrome needs characters in pairs.

For every character:

- If the frequency is even, we can use all of them.
- If the frequency is odd, we can use `frequency - 1`.
- If there is at least one odd frequency, one character can be placed in the center.

### Example

Input:

    "abccccdd"

Frequency:

    a → 1
    b → 1
    c → 4
    d → 2

Usable characters:

    a → 0
    b → 0
    c → 4
    d → 2

Total:

    6

Since there is an odd frequency, one character can be placed in the center.

Final answer:

    7

### Steps

1. Create a `HashMap<Character, Integer>`.
2. Count the frequency of every character.
3. Traverse `map.values()`.
4. Add the complete frequency when it is even.
5. Add `frequency - 1` when it is odd.
6. Remember that at most one odd character can be used in the center.

### Java Implementation

    // Time Complexity: O(n)
    // Space Complexity: O(k)

    import java.util.HashMap;
    import java.util.Map;

    public class _01_FrequencyMap {

        static int longestPalindrome(String text) {

            Map<Character, Integer> characterFrequency = new HashMap<>();

            // Count frequency of every character
            for (char currentCharacter : text.toCharArray()) {

                if (characterFrequency.containsKey(currentCharacter)) {
                    int currentFrequency =
                            characterFrequency.get(currentCharacter);

                    characterFrequency.put(
                            currentCharacter,
                            currentFrequency + 1
                    );
                } else {
                    characterFrequency.put(currentCharacter, 1);
                }
            }

            int palindromeLength = 0;
            boolean hasOddFrequency = false;

            // Process every distinct character once
            for (int currentFrequency : characterFrequency.values()) {

                if (currentFrequency % 2 == 0) {
                    palindromeLength += currentFrequency;
                } else {
                    palindromeLength += currentFrequency - 1;
                    hasOddFrequency = true;
                }
            }

            // One odd character can be placed in the center
            if (hasOddFrequency) {
                palindromeLength++;
            }

            return palindromeLength;
        }

        public static void main(String[] args) {

            String text = "abccccdd";

            int result = longestPalindrome(text);

            System.out.println(
                    "Longest palindrome length: " + result
            );

            // Expected Output:
            // Longest palindrome length: 7
        }
    }

### Complexity

- Time Complexity: O(n)
- Space Complexity: O(k)

where `k` is the number of distinct characters.

### Key Learning

When a `HashMap` stores:

    character → frequency

and we need every distinct character's frequency exactly once:

    map.values()

For palindrome construction:

    even frequency → use all
    odd frequency  → use frequency - 1
    one odd character → can be placed in the center


---

## Approach 02 — Count Array

### Idea

Use a fixed-size array instead of a `HashMap`.

The problem contains:

    26 lowercase letters
    26 uppercase letters

Therefore, we need:

    int[52]

Each character is converted into an array index.

### Character Mapping

Lowercase letters:

    'a' → 0
    'b' → 1
    ...
    'z' → 25

Uppercase letters:

    'A' → 26
    'B' → 27
    ...
    'Z' → 51

### Steps

1. Create `int[52]`.
2. Convert every character into its corresponding array index.
3. Increase the frequency at that index.
4. Traverse all frequencies.
5. Use the full frequency when it is even.
6. Use `frequency - 1` when it is odd.
7. If any odd frequency exists, add one character in the center.

### Java Implementation

    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public class _02_CountArray {

        static int longestPalindrome(String text) {

            int[] characterFrequency = new int[52];

            // Count frequency of every character
            for (char currentCharacter : text.toCharArray()) {

                int index;

                if (currentCharacter >= 'a'
                        && currentCharacter <= 'z') {

                    index = currentCharacter - 'a';

                } else {

                    index = currentCharacter - 'A' + 26;
                }

                characterFrequency[index]++;
            }

            int palindromeLength = 0;
            boolean hasOddFrequency = false;

            // Process all 52 character frequencies
            for (int currentFrequency : characterFrequency) {

                if (currentFrequency % 2 == 0) {
                    palindromeLength += currentFrequency;
                } else {
                    palindromeLength += currentFrequency - 1;
                    hasOddFrequency = true;
                }
            }

            // One odd character can be placed in the center
            if (hasOddFrequency) {
                palindromeLength++;
            }

            return palindromeLength;
        }

        public static void main(String[] args) {

            String text = "abccccdd";

            int result = longestPalindrome(text);

            System.out.println(
                    "Longest palindrome length: " + result
            );

            // Expected Output:
            // Longest palindrome length: 7
        }
    }

### Complexity

- Time Complexity: O(n)
- Space Complexity: O(1)

### Key Learning

When the possible characters come from a small fixed range, a count array can replace a `HashMap`.

For this problem:

    lowercase letters → 26
    uppercase letters → 26

Therefore:

    int[52]

The palindrome rule remains the same:

    even frequency → use all
    odd frequency  → use frequency - 1
    any odd frequency → add 1 for the center