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

        // One odd character can be placed in the center
        if (hasOddFrequency) {
            palindromeLength++;
        }

        return palindromeLength;
    }

    public static void main(String[] args) {

        String text = "abccccdd";

        int result = longestPalindrome(text);

        System.out.println("Longest palindrome length: " + result);

        // Expected Output:
        // Longest palindrome length: 7
    }
}