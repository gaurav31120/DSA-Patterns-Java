// Complexity
// Time: O(n)
// Space: O(n)

public class _01_ExtraArray {

    public static int removeDuplicates(int[] arr) {

        int[] result = new int[arr.length];

        int j = 1;
        result[0] = arr[0];

        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] != arr[i + 1]) {
                result[j] = arr[i + 1];
                j++;
            }
        }

        return j;
    }

    public static void main(String[] args) {

        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int uniqueElements = removeDuplicates(arr);

        System.out.println(uniqueElements);
    }
}

// output : 4