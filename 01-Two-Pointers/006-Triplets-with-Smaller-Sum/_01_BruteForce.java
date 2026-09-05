// Approach 01: Brute Force
// Time: O(n³)
// Space: O(1)

public class _01_BruteForce {

    public static int tripletsWithSmallerSum(int[] arr, int target) {

        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n - 2; i++) {

            for (int j = i + 1; j < n; j++) {

                for (int k = j + 1; k < n; k++) {

                    int sum = arr[i] + arr[j] + arr[k];

                    if (sum < target) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr = {-2, 0, 1, 3};
        int target = 2;

        int count = tripletsWithSmallerSum(arr, target);

        System.out.println("Count: " + count);
    }
}