// Approach 02: Sorting + Two Pointers
// Time: O(n²)
// Space: O(1)

import java.util.Arrays;

public class _02_SortingTwoPointers {

    public static int closestSum(int[] arr, int target) {

        Arrays.sort(arr);

        int n = arr.length;
        int minDiff = Integer.MAX_VALUE;
        int resultSum = 0;

        for (int i = 0; i < n - 2; i++) {

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                int sum = arr[i] + arr[left] + arr[right];

                int diff = Math.abs(sum - target);

                if (diff < minDiff) {
                    minDiff = diff;
                    resultSum = sum;
                }

                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return resultSum;
    }

    public static void main(String[] args) {

        int[] arr = {-1, 2, 1, -4};
        int target = 1;

        int resultSum = closestSum(arr, target);

        System.out.println("Closest sum is: " + resultSum);
    }
}