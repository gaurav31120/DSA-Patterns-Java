import java.util.HashSet;
import java.util.Set;

// Approach 01: Brute Force
// Time: O(n²)
// Space: O(k)

public class _01_HashSet {

    static int longestSubstring(String str, int k) {

        int maxLength = 0;

        // Try every starting position.
        for (int i = 0; i < str.length(); i++) {

            Set<Character> set = new HashSet<>();

            // Expand the substring.
            for (int j = i; j < str.length(); j++) {

                set.add(str.charAt(j));

                // More than k distinct characters is invalid.
                if (set.size() > k) {
                    break;
                }

                // Update the longest valid substring.
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String str = "araaci";
        int k = 2;

        int maxLength = longestSubstring(str, k);

        System.out.println("Longest substring length: " + maxLength);
    }
}