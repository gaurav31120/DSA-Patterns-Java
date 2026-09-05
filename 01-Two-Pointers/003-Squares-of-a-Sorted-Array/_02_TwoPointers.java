// Approach 2: Two Pointers
// Time: O(n)
// Space: O(n)

public class _02_TwoPointers {

    public static int[] squareOfSortedArray(int[] arr) {

        int[] result = new int[arr.length];

        int left = 0;
        int right = arr.length - 1;
        int k = arr.length - 1;

        while (left <= right) {

            if (Math.abs(arr[left]) > Math.abs(arr[right])) {
                result[k] = arr[left] * arr[left];
                left++;
            } else {
                result[k] = arr[right] * arr[right];
                right--;
            }

            k--;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {-4, -1, 0, 3, 10};

        int[] result = squareOfSortedArray(arr);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}