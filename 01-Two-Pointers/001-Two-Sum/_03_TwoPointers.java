// Approach 3: Two Pointers
// Time: O(n log n)
// Space: O(n)

import java.util.Arrays;

public class _03_TwoPointers {

    public static int[] twoSum(int[] arr, int target) {
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        int left = 0;
        int right = sortedArr.length - 1;
        while (left < right) {
            int sum = sortedArr[left] + sortedArr[right];
            if (sum == target) {
                int firstIndex = getOriginalIndex(arr, sortedArr[left], -1);
                int secondIndex = getOriginalIndex(arr, sortedArr[right], firstIndex);
                return new int[] { firstIndex, secondIndex };
            } else if (sum < target) {
                left++;

            } else {
                right--;
            }

        }
        return new int[] { -1, -1 };
    }

    public static int getOriginalIndex(int[] arr, int value, int usedIndex) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value && i != usedIndex) {
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) {

        int[] arr = { 11, 2, 15, 7 };
        int target = 9;

        int[] result = twoSum(arr, target);

        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }

}


// Another way -- using 2D array

// import java.util.Arrays;

// // Approach 3: Two Pointers
// // Time: O(n log n)
// // Space: O(n)

// public class _03_TwoPointers {

//     public static int[] twoSum(int[] arr, int target) {

//         int[][] pairs = new int[arr.length][2];

//         for (int i = 0; i < arr.length; i++) {
//             pairs[i][0] = arr[i];
//             pairs[i][1] = i;
//         }

//         Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

//         int left = 0;
//         int right = pairs.length - 1;

//         while (left < right) {

//             int sum = pairs[left][0] + pairs[right][0];

//             if (sum == target) {
//                 return new int[]{
//                     pairs[left][1],
//                     pairs[right][1]
//                 };
//             }

//             if (sum < target) {
//                 left++;
//             } else {
//                 right--;
//             }
//         }

//         return new int[]{-1, -1};
//     }

//     public static void main(String[] args) {

//         int[] arr = {11, 2, 15, 7};
//         int target = 9;

//         int[] result = twoSum(arr, target);

//         System.out.println(
//             "Indices: " + result[0] + ", " + result[1]
//         );
//     }
// }
