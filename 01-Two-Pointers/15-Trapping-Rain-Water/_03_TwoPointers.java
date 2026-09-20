/*
 * P015 — Trapping Rain Water
 * LeetCode #42
 * Approach 03 — Two Pointers
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class _03_TwoPointers {

    static int trap(int[] arr) {

        int n = arr.length;

        int left = 0;
        int right = n - 1;

        int leftMax = 0;
        int rightMax = 0;

        int waterStored = 0;
        int waterStoredAtIndex = 0;

        while (left < right) {

            if (arr[left] <= arr[right]) {

                leftMax = Math.max(leftMax, arr[left]);

                waterStoredAtIndex = leftMax - arr[left];
                waterStored += waterStoredAtIndex;

                left++;

            } else {

                rightMax = Math.max(rightMax, arr[right]);

                waterStoredAtIndex = rightMax - arr[right];
                waterStored += waterStoredAtIndex;

                right--;
            }
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