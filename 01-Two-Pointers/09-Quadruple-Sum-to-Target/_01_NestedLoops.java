import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Approach 01: Nested Loops
// Time: O(n⁴)
// Space: O(1) extra space excluding output

public class _01_NestedLoops {

    static List<List<Integer>> fourSum(int[] arr, int target) {

        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();

        // Choose the first element.
        for (int i = 0; i < n; i++) {

            // Choose the second element.
            for (int j = i + 1; j < n; j++) {

                // Choose the third element.
                for (int k = j + 1; k < n; k++) {

                    // Choose the fourth element.
                    for (int l = k + 1; l < n; l++) {

                        long sum = (long) arr[i] + arr[j] + arr[k] + arr[l];

                        if (sum == target) {

                            List<Integer> quadruplet = new ArrayList<>();

                            quadruplet.add(arr[i]);
                            quadruplet.add(arr[j]);
                            quadruplet.add(arr[k]);
                            quadruplet.add(arr[l]);

                            // Keep quadruplet in a consistent order.
                            Collections.sort(quadruplet);

                            // Avoid duplicate quadruplets.
                            if (!result.contains(quadruplet)) {
                                result.add(quadruplet);
                            }
                        }
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
// [-2, -1, 0, 3]  ← depends on input; for the given input:
// [-2, -1, 1, 2]
// [-2, 0, 0, 2]
// [-1, 0, 0, 1]