// Approach 02: Sliding Window
// Time: O(n)
// Space: O(1)

public class _02_SlidingWindow {

    static int maxSumSubarray(int[] arr, int k) {

        int low = 0;
        int high = k - 1;
        int n = arr.length;

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        // Calculate the first window sum.
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        maxSum = sum;

        // Slide the window.
        while (high < n - 1) {

            low++;
            high++;

            sum = sum - arr[low - 1] + arr[high];

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