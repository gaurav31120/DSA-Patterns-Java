// Approach 01: Nested Loops
// Time: O(n²)
// Space: O(1)

public class _01_NestedLoops {

    static int[] twoSum(int[] arr, int target) {

        // Check every possible pair.
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                int sum = arr[i] + arr[j];

                // Return 1-based indices when target is found.
                if (sum == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] arr = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(arr, target);

        System.out.println("Indices:");

        for (int index : result) {
            System.out.print(index + " ");
        }
    }
}

// Output:
// Indices:
// 1 2