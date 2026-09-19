// Approach 03: Two Pointers
// Time: O(n)
// Space: O(1)

public class _03_TwoPointers {

    static int[] twoSum(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        // Move pointers based on the current sum.
        while (left < right) {

            int sum = arr[left] + arr[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }

            if (sum < target) {
                left++;
            } else {
                right--;
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