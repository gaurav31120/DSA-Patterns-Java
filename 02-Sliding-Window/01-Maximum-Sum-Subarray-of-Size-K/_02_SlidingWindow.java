// Approach 02: Sliding Window
// Time: O(n)
// Space: O(1)

public class _02_SlidingWindow {

    static int maxSumSubarray(int[] arr, int k) {

        int sum = 0;

        // Calculate the first window.
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int maxSum = sum;

        // Slide the window one position at a time.
        for (int i = k; i < arr.length; i++) {

            // Remove outgoing and add incoming element.
            sum = sum - arr[i - k] + arr[i];

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