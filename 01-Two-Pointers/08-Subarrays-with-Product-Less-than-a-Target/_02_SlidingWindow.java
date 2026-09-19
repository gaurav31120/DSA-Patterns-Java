// Approach 02: Sliding Window / Two Pointers
// Time: O(n)
// Space: O(1)

public class _02_SlidingWindow {

    static int subarrayProduct(int[] arr, int target) {

        if (target <= 1) {
            return 0;
        }

        int left = 0;
        int count = 0;
        long product = 1;

        // Expand the window.
        for (int right = 0; right < arr.length; right++) {

            product *= arr[right];

            // Shrink until the product is valid.
            while (product >= target) {
                product /= arr[left];
                left++;
            }

            // Count all valid subarrays ending at right.
            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr = {10, 5, 2, 6};
        int target = 100;

        int count = subarrayProduct(arr, target);

        System.out.println("Number of valid subarrays: " + count);
    }
}

// Output:
// Number of valid subarrays: 8