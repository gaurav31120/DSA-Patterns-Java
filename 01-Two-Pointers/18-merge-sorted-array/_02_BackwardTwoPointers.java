/*
 * Approach: Backward Two Pointers
 * Time Complexity: O(m + n)
 * Space Complexity: O(1)
 */

import java.util.Arrays;

public class _02_BackwardTwoPointers {

    static int[] merge(int[] arr1, int[] arr2, int m, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        // Merge from the end
        while (i >= 0 && j >= 0) {

            if (arr1[i] > arr2[j]) {
                arr1[k] = arr1[i];
                i--;
            } else {
                arr1[k] = arr2[j];
                j--;
            }

            k--;
        }

        // Copy remaining elements from arr2
        while (j >= 0) {
            arr1[k] = arr2[j];
            j--;
            k--;
        }

        return arr1;
    }

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 0, 0, 0};
        int[] arr2 = {2, 5, 6};

        int m = 3;
        int n = 3;

        int[] result = merge(arr1, arr2, m, n);

        System.out.println("Merged array: " + Arrays.toString(result));

        // Expected Output:
        // Merged array: [1, 2, 2, 3, 5, 6]
    }
}