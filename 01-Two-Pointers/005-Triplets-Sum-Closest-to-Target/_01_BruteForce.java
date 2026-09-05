// Approach 01: Brute Force
// Time: O(n³)
// Space: O(1)

public class _01_BruteForce {

    public static int closestSum(int[] arr, int target) {

        int n = arr.length;
        int minDiff = Integer.MAX_VALUE;
        int resultSum = 0;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                for (int k = j + 1; k < n; k++) {

                    int sum = arr[i] + arr[j] + arr[k];

                    if (sum == target) {
                        return sum;
                    }

                    int diff = Math.abs(sum - target);

                    if (diff < minDiff) {
                        minDiff = diff;
                        resultSum = sum;
                    }
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