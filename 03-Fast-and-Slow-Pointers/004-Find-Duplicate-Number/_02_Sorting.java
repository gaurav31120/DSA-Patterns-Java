// Approach 02: Sorting
// Time: O(n log n)
// Space: O(1)

import java.util.Arrays;

public class _02_Sorting {

    static int findDuplicate(int[] arr) {

        // Sort the array so duplicates become adjacent.
        Arrays.sort(arr);

        // Check adjacent elements.
        for (int i = 0; i < arr.length - 1; i++) {

            // Same adjacent values mean duplicate found.
            if (arr[i] == arr[i + 1]) {
                return arr[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 2, 2};

        int duplicate = findDuplicate(arr);

        // Print the duplicate number.
        System.out.println("Duplicate number: " + duplicate);
    }
}