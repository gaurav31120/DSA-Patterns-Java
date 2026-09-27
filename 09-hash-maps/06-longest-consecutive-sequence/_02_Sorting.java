// Time Complexity: O(n log n)
// Space Complexity: O(1) auxiliary space

import java.util.Arrays;

public class _02_Sorting {

    static int longestConsecutive(int[] arr) {

        if (arr.length == 0) {
            return 0;
        }

        Arrays.sort(arr);

        int currentLength = 1;
        int longestLength = 1;

        for (int i = 1; i < arr.length; i++) {

            // Ignore duplicate values
            if (arr[i] == arr[i - 1]) {
                continue;
            }

            // Consecutive numbers
            if (arr[i] == arr[i - 1] + 1) {
                currentLength++;
            } else {
                // Start a new sequence
                currentLength = 1;
            }

            if (currentLength > longestLength) {
                longestLength = currentLength;
            }
        }

        return longestLength;
    }

    public static void main(String[] args) {

        int[] arr = {100, 4, 200, 1, 3, 2};

        int result = longestConsecutive(arr);

        System.out.println(
                "Longest consecutive sequence length: " + result
        );

        // Expected Output:
        // Longest consecutive sequence length: 4
    }
}