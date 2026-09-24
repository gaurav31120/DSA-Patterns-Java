import java.util.*;

public class _01_HashMap {

    static int[] intersection(int[] arr1, int[] arr2) {

        // Step 1: Store frequency of arr1
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : arr1) {

            if (freq.containsKey(num)) {
                int oldCount = freq.get(num);
                freq.put(num, oldCount + 1);
            } else {
                freq.put(num, 1);
            }
        }

        // Step 2: Store common elements
        List<Integer> result = new ArrayList<>();

        // Check every element of arr2
        for (int num : arr2) {

            if (freq.containsKey(num)) {

                int count = freq.get(num);

                if (count > 0) {

                    // Add common element
                    result.add(num);

                    // One occurrence has been used
                    freq.put(num, count - 1);
                }
            }
        }

        // Step 3: Convert List to int[]
        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 2, 3};
        int[] arr2 = {2, 2, 2, 4};

        int[] result = intersection(arr1, arr2);

        System.out.println("Intersection: " + Arrays.toString(result));

        // Expected Output:
        // Intersection: [2, 2]
    }
}