/*
 * Approach: Extra Array
 * Time Complexity: O(m + n)
 * Space Complexity: O(m + n)
 */

import java.util.Arrays;

public class _01_ExtraArray {

    static int[] merge(int[] arr1, int[] arr2, int m, int n) {

        int[] result = new int[m + n];

        int i = 0;
        int j = 0;
        int k = 0;

        // Merge both sorted portions
        while (i < m && j < n) {

            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // Remaining elements from arr1
        while (i < m) {
            result[k++] = arr1[i++];
        }

        // Remaining elements from arr2
        while (j < n) {
            result[k++] = arr2[j++];
        }

        // Copy merged result back to arr1
        for (int index = 0; index < m + n; index++) {
            arr1[index] = result[index];
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