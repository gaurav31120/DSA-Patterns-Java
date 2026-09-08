// Approach 02: Sliding Window
// Time: O(n)
// Space: O(1)

public class _02_SlidingWindow {

    static int smallestSubarray(int[] arr, int target) {

        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        // Expand the window.
        for (int right = 0; right < arr.length; right++) {

            sum += arr[right];

            // Shrink while the target is reached.
            while (sum >= target) {

                int length = right - left + 1;

                // Update minimum length.
                minLength = Math.min(minLength, length);

                sum -= arr[left];
                left++;
            }
        }

        // No valid subarray found.
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {

        int[] arr = {2, 1, 5, 2, 3, 2};
        int target = 7;

        int minLength = smallestSubarray(arr, target);

        System.out.println("Smallest subarray length: " + minLength);
    }
}