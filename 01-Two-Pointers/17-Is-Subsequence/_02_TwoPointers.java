/*
 * P017 — Is Subsequence
 * LeetCode #392
 * Approach 02 — Two Pointers
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(1)
 */

public class _02_TwoPointers {

    static boolean isSubsequence(String s, String t) {

        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {

            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }

            j++;
        }

        return i == s.length();
    }

    public static void main(String[] args) {

        String s = "abc";
        String t = "ahbgdc";

        boolean result = isSubsequence(s, t);

        System.out.println("Is subsequence: " + result);

        // Output:
        // Is subsequence: true
    }
}