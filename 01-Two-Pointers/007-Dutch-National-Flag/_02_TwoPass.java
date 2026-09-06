// Approach 02: Two Passes / Overwrite
// Time: O(n)
// Space: O(1)

public class _02_TwoPass {

    public static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] dutch(int[] arr) {

        int n = arr.length;
        int j = 0;

        // First pass: place all 0s
        for (int i = 0; i < n; i++) {

            if (arr[i] == 0) {
                swap(arr, i, j);
                j++;
            }
        }

        // Second pass: place all 1s
        for (int i = 0; i < n; i++) {

            if (arr[i] == 1) {
                swap(arr, i, j);
                j++;
            }
        }

        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {2, 0, 2, 1, 1, 0};

        int[] result = dutch(arr);

        for (int i : result) {
            System.out.print(i + "  ");
        }
    }
}