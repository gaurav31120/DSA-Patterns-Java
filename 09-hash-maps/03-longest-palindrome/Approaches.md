# P003 — Longest Palindrome

## Approach 01 — Frequency Map

### Idea

Use a `HashMap` to count how many times each character appears.

A palindrome needs characters in pairs.

For every character frequency:

- If the frequency is even, use the complete frequency.
- If the frequency is odd, use `frequency - 1`.
- If at least one odd frequency exists, one character can be placed in the center.

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

There are odd frequencies, so one character can be placed in the center.

Final answer:

    7

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

            // Process each distinct character once
            for (int currentFrequency : characterFrequency.values()) {

                if (currentFrequency % 2 == 0) {
                    palindromeLength += currentFrequency;
                } else {
                    palindromeLength += currentFrequency - 1;
                    hasOddFrequency = true;
                }
            }

            if (hasOddFrequency) {
                palindromeLength++;
            }

            return palindromeLength;
        }
    }

### Complexity

- Time: O(n)
- Space: O(k)

### Key Learning

When a `HashMap` stores:

    character → frequency

and we need each distinct character's frequency exactly once, use:

    map.values()

For palindrome construction:

    even frequency → use all
    odd frequency  → use frequency - 1
    one odd character can be used in the center