import java.util.Arrays;

// Approach 1: Extra Array + Sorting
// Time: O(n log n)
// Space: O(n)

public class _01_ExtraArraySorting {

    public static int[] squareOfSortedArray(int[] arr) {

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i] * arr[i];
        }

        Arrays.sort(result);

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