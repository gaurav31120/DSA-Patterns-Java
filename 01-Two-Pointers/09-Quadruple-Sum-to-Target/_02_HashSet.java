import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Approach 02: HashSet + Three Loops
// Time: O(n³)
// Space: O(n) auxiliary space excluding output

public class _02_HashSet {

    static List<List<Integer>> fourSum(int[] arr, int target) {

        int n = arr.length;

        Set<Long> seen = new HashSet<>();
        Set<List<Integer>> unique = new HashSet<>();

        // Fix the first two elements.
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                seen.clear();

                // Find the remaining two elements.
                for (int k = j + 1; k < n; k++) {

                    long required = (long) target
                            - arr[i]
                            - arr[j]
                            - arr[k];

                    // Check whether the required value was seen.
                    if (seen.contains(required)) {

                        List<Integer> quadruplet = new ArrayList<>();

                        quadruplet.add(arr[i]);
                        quadruplet.add(arr[j]);
                        quadruplet.add(arr[k]);
                        quadruplet.add((int) required);

                        // Keep a consistent order.
                        Collections.sort(quadruplet);

                        // Avoid duplicate quadruplets.
                        unique.add(quadruplet);
                    }

                    // Store the current value for future k values.
                    seen.add((long) arr[k]);
                }
            }
        }

        return new ArrayList<>(unique);
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