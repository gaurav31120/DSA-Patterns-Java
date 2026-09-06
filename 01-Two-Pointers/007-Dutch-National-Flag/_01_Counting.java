// Approach 01: Counting
// Time: O(n)
// Space: O(1)

public class _01_Counting {

    public static int[] dutch(int[] arr) {

        int n = arr.length;

        int count0 = 0, count1 = 0, count2 = 0;

        for (int i = 0; i < n; i++) {

            if (arr[i] == 0) {
                count0++;
            } else if (arr[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        int index = 0;

        for (int i = 0; i < count0; i++) {
            arr[index] = 0;
            index++;
        }

        for (int i = 0; i < count1; i++) {
            arr[index] = 1;
            index++;
        }

        for (int i = 0; i < count2; i++) {
            arr[index] = 2;
            index++;
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