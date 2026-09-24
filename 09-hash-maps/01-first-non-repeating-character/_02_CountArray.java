public class _02_CountArray {

    // Time: O(n)
    // Space: O(1)

    static int nonRepeating(char[] arr) {

        int[] freq = new int[26];

        // Count frequency
        for (char ch : arr) {
            freq[ch - 'a']++;
        }

        // Find first non-repeating character
        for (int i = 0; i < arr.length; i++) {
            if (freq[arr[i] - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        char[] arr = {'a', 'b', 'c', 'a', 'b'};

        int result = nonRepeating(arr);

        System.out.println("First non-repeating index: " + result);

        // Expected Output:
        // First non-repeating index: 2
    }
}