/*
 * P016 — Remove Element
 * LeetCode #27
 * Approach 03 — Two Pointers / Swap
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class _03_TwoPointers {

    static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    static int remove(int[] arr, int val) {

        int left = 0;
        int right = arr.length - 1;
        int k = 0;

        while (left <= right) {

            if (arr[left] == val) {

                // Replace the unwanted element with an element from the end.
                swap(arr, left, right);
                right--;

            } else {

                // Current element is valid.
                left++;
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {

        int[] arr = {3, 2, 2, 3};
        int val = 3;

        int k = remove(arr, val);

        System.out.println("Remaining count: " + k);

        System.out.print("Valid elements: [");
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i]);

            if (i < k - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        // Output:
        // Remaining count: 2
        // Valid elements: [2, 2]
    }
}