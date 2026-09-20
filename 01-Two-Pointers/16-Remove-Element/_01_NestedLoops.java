/*
 * P016 — Remove Element
 * LeetCode #27
 * Approach 01 — Nested Loops / Shifting
 *
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 */

public class _01_NestedLoops {

    static int remove(int[] arr, int val) {

        int n = arr.length;
        int k = n;
        int i = 0;

        while (i < k) {

            if (arr[i] == val) {

                // Shift elements one position to the left.
                for (int j = i; j < k - 1; j++) {
                    arr[j] = arr[j + 1];
                }

                // One element has been removed.
                k--;

            } else {
                i++;
            }
        }

        return k;
    }

    public static void main(String[] args) {

        int[] arr = {3, 2, 2, 3};
        int val = 3;

        int k = remove(arr, val);

        System.out.println("Remaining count: " + k);

        // Output:
        // Remaining count: 2
    }
}