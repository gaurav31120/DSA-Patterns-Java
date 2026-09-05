// Approach 02: Sorting + Two Pointers
// Time: O(n²)
// Space: O(1)

import java.util.Arrays;

public class _02_SortingTwoPointers {

    public static int tripletsWithSmallerSum(int[] arr, int target) {

        Arrays.sort(arr);

        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n - 2; i++) {

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                int sum = arr[i] + arr[left] + arr[right];

                if (sum < target) {

                    count += right - left;
                    left++;

                } else {

                    right--;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr = {-2, 0, 1, 3};
        int target = 2;

        int count = tripletsWithSmallerSum(arr, target);

        System.out.println("Count: " + count);
    }
}