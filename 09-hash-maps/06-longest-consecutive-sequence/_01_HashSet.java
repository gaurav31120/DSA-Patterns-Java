// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.HashSet;
import java.util.Set;

public class _01_HashSet {

    static int longestConsecutive(int[] arr) {

        Set<Integer> numbers = new HashSet<>();

        // Store all numbers in the HashSet
        for (int number : arr) {
            numbers.add(number);
        }

        int longestLength = 0;

        // Process each distinct number once
        for (int currentNumber : numbers) {

            // Start only if this is the beginning of a sequence
            if (!numbers.contains(currentNumber - 1)) {

                int sequenceLength = 1;
                int nextNumber = currentNumber + 1;

                // Continue while consecutive numbers exist
                while (numbers.contains(nextNumber)) {
                    sequenceLength++;
                    nextNumber++;
                }

                // Update longest sequence
                if (sequenceLength > longestLength) {
                    longestLength = sequenceLength;
                }
            }
        }

        return longestLength;
    }

    public static void main(String[] args) {

        int[] arr = {100, 4, 200, 1, 3, 2};

        int result = longestConsecutive(arr);

        System.out.println(
                "Longest consecutive sequence length: " + result
        );

        // Expected Output:
        // Longest consecutive sequence length: 4
    }
}