/*
 * P016 — Remove Element
 * LeetCode #27
 * Approach 02 — Extra Array
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class _02_ExtraArray {

    static int remove(int[] arr, int val) {

        int k = 0;
        int[] res = new int[arr.length];

        // Store only elements that should be kept.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                res[k] = arr[i];
                k++;
            }
        }

        // Copy valid elements back to the original array.
        for (int i = 0; i < k; i++) {
            arr[i] = res[i];
        }

        return k;
    }

    public static void main(String[] args) {

        int[] arr = {3, 2, 2, 3};
        int val = 3;

        int k = remove(arr, val);

        System.out.println("Remaining count: " + k);

        // Output:
        // Remaining count: 2
    }
}