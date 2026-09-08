// Approach 01: Brute Force
// Time: O(n × k)
// Space: O(1)

public class _01_BruteForce {

    static int maxSumSubarray(int[] arr, int k) {

        int maxSum = Integer.MIN_VALUE;

        // Try every possible window.
        for (int i = 0; i <= arr.length - k; i++) {

            int sum = 0;

            // Calculate the sum of the current window.
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }

            // Update maximum sum.
            if (sum > maxSum) {
                maxSum = sum;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        int maxSum = maxSumSubarray(arr, k);

        System.out.println("Maximum sum: " + maxSum);
    }
}