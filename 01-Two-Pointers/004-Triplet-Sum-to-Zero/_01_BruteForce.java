import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Approach 1: Brute Force
// Time: O(n^3)
// Space: O(m) - output

public class _01_BruteForce {

    public static List<List<Integer>> triplets(int[] arr) {

        List<List<Integer>> result = new ArrayList<>();

        int n = arr.length;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                for (int k = j + 1; k < n; k++) {

                    int sum = arr[i] + arr[j] + arr[k];

                    if (sum == 0) {

                        List<Integer> triplet = new ArrayList<>();

                        triplet.add(arr[i]);
                        triplet.add(arr[j]);
                        triplet.add(arr[k]);

                        Collections.sort(triplet);

                        if (!result.contains(triplet)) {
                            result.add(triplet);
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> result = triplets(arr);

        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}