/*
 * P015 — Trapping Rain Water
 * LeetCode #42
 * Approach 01 — Prefix/Suffix Max Arrays
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class _01_PrefixSuffixMax {

    static int trap(int[] arr) {

        int n = arr.length;

        if (n < 2) {
            return 0;
        }

        // Stores the maximum height from the left up to each index.
        int[] leftMax = new int[n];

        // Stores the maximum height from the right up to each index.
        int[] rightMax = new int[n];

        leftMax[0] = arr[0];
        rightMax[n - 1] = arr[n - 1];

        // Build leftMax array.
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        // Build rightMax array.
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        int waterStored = 0;

        // Calculate water stored at every index.
        for (int i = 0; i < n; i++) {
            int waterAtIndex = Math.min(leftMax[i], rightMax[i]) - arr[i];
            waterStored += waterAtIndex;
        }

        return waterStored;
    }

    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        int waterStored = trap(arr);

        System.out.println("Water stored: " + waterStored);

        // Output:
        // Water stored: 6
    }
}