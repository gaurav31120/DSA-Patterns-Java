// Approach 01: Brute Force
// Time: O(n²)
// Space: O(1)

public class _01_BruteForce {

    static int findDuplicate(int[] arr) {

        // Compare every pair of elements.
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                // Same value means duplicate found.
                if (arr[i] == arr[j]) {
                    return arr[i];
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 2, 2};

        int duplicate = findDuplicate(arr);

        // Print the duplicate number.
        System.out.println("Duplicate number: " + duplicate);
    }
}