// Approach 01: Nested Loops
// Time: O(n²)
// Space: O(1)

public class _01_NestedLoops {

    static int subarrayProduct(int[] arr, int target) {

        int count = 0;

        // Try every starting position.
        for (int i = 0; i < arr.length; i++) {

            int product = 1;

            // Expand the subarray.
            for (int j = i; j < arr.length; j++) {

                product *= arr[j];

                // Count valid subarrays.
                if (product < target) {
                    count++;
                } else {
                    break;
                }
            }
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