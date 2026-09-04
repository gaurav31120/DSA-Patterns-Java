// Approach 1: Brute Force -- TC - O(n^2) SC - O(1)

public class _01_BruteForce {

    static public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[] { i, j };

            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {

        int[] arr = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = twoSum(arr, target);

        System.out.println("Indices: " + result[0] + " " + result[1]);
    }

}