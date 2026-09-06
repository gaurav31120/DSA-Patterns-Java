// Approach 03: Dutch National Flag / Three Pointers
// Time: O(n)
// Space: O(1)

public class _03_DutchNationalFlag {

    public static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] dutch(int[] arr) {

        int i = 0;
        int left = 0;
        int right = arr.length - 1;

        while (i <= right) {

            if (arr[i] == 0) {

                swap(arr, i, left);
                left++;
                i++;

            } else if (arr[i] == 1) {

                i++;

            } else {

                swap(arr, i, right);
                right--;
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