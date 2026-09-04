// Approach 3: Two Pointers
// Time: O(n)
// Space: O(1)

public class _03_TwoPointers {

    public static int removeDuplicates(int[] arr) {

        int j = 0;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] != arr[j]) {
                arr[j + 1] = arr[i];
                j++;
            }
        }

        return j + 1;
    }

    public static void main(String[] args) {

        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int uniqueElements = removeDuplicates(arr);

        System.out.println(uniqueElements);
    }
}