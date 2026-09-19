import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Approach 03: Sorting + Two Pointers
// Time: O(n³)
// Space: O(1) auxiliary space excluding output

public class _03_SortingAndTwoPointers {

    static List<List<Integer>> fourSum(int[] arr, int target) {

        Arrays.sort(arr);

        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();

        // Fix the first element.
        for (int i = 0; i < n - 3; i++) {

            // Skip duplicate first elements.
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            // Fix the second element.
            for (int j = i + 1; j < n - 2; j++) {

                // Skip duplicate second elements.
                if (j > i + 1 && arr[j] == arr[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = n - 1;

                // Find the remaining two elements.
                while (left < right) {

                    long sum = (long) arr[i] + arr[j] + arr[left] + arr[right];

                    if (sum == target) {

                        List<Integer> quadruplet = new ArrayList<>();

                        quadruplet.add(arr[i]);
                        quadruplet.add(arr[j]);
                        quadruplet.add(arr[left]);
                        quadruplet.add(arr[right]);

                        result.add(quadruplet);

                        left++;
                        right--;

                        // Skip duplicate third elements.
                        while (left < right && arr[left] == arr[left - 1]) {
                            left++;
                        }

                        // Skip duplicate fourth elements.
                        while (left < right && arr[right] == arr[right + 1]) {
                            right--;
                        }

                    } else if (sum < target) {
                        left++;

                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {1, 0, -1, 0, -2, 2};
        int target = 0;

        List<List<Integer>> result = fourSum(arr, target);

        System.out.println("Quadruplets:");

        for (List<Integer> quadruplet : result) {
            System.out.println(quadruplet);
        }
    }
}

// Output:
// Quadruplets:
// [-2, -1, 1, 2]
// [-2, 0, 0, 2]
// [-1, 0, 0, 1]