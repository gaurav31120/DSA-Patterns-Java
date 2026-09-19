import java.util.HashMap;
import java.util.Map;

// Approach 02: HashMap
// Time: O(n)
// Space: O(n)

public class _02_HashMap {

    static int[] twoSum(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        // Check each value with its required complement.
        for (int i = 0; i < arr.length; i++) {

            int complement = target - arr[i];

            // Complement was seen earlier.
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement) + 1, i + 1};
            }

            // Store value with its index.
            map.put(arr[i], i);
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