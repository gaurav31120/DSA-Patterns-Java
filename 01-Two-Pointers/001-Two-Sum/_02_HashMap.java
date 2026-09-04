import java.util.HashMap;
import java.util.Map;

// Approach 2: HashMap
// Time: O(n)
// Space: O(n)

public class _02_HashMap {

    public static int[] twoSum(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            int complement = target - arr[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(arr[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] arr = {11, 2, 15, 7};
        int target = 9;

        int[] result = twoSum(arr, target);

        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}