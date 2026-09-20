
/*
 * P017 — Is Subsequence
 * LeetCode #392
 * Approach 01 — Nested Loops / Searching Forward
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(1)
 */

public class _01_NestedLoops {

    static boolean subsequence(String s, String t) {

        int j = 0;
        int i = 0;
        while (i < s.length()) {

            while (j < t.length()) {

                if (s.charAt(i) == t.charAt(j)) {
                    i++;
                    j++;
                    break;
                }

                j++;

            }

            if (j == t.length() && i < s.length()) {
                return false;
            }

        }

        if (i == s.length()) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {

        String s = "abc";
        String t = "ahbgdc";

        boolean subsequence = subsequence(s, t);

        System.out.println(subsequence);

    }

}

// Output:
// Is subsequence: true
