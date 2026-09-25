// Time Complexity: O(n)
// Space Complexity: O(1)

public class _02_CountArray {

    // static int longestPalindrome(String text) {
    //     int n = text.length();

    //     int[] freq = new int[52];

    //     for (char ch : text.toCharArray()) {
    //         freq[ch - 'a']++;
    //     }

    //     int count = 0;
    //     boolean oddLength = false;

    //     for (int i = 0; i < 26; i++) {
    //         int charCount = freq[i];
    //         if (charCount % 2 == 0) {
    //             count = count + charCount;
    //         } else {
    //             oddLength = true;
    //             count = count + charCount - 1;
    //         }

    //     }

    //     if (oddLength) {
    //         return count++;
    //     } else {
    //         count++;
    //         return count;
    //     }
    // }

    static int longestPalindrome(String text) {

        int[] characterFrequency = new int[52];

        // Count frequency of every character
        for (char currentCharacter : text.toCharArray()) {

            int index;

            if (currentCharacter >= 'a' && currentCharacter <= 'z') {
                index = currentCharacter - 'a';
            } else {
                index = currentCharacter - 'A' + 26;
            }

            characterFrequency[index]++;
        }

        int palindromeLength = 0;
        boolean hasOddFrequency = false;

        // Process all 52 possible letters
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

        System.out.println("Longest palindrome length: " + result);

        // Expected Output:
        // Longest palindrome length: 7
    }
}