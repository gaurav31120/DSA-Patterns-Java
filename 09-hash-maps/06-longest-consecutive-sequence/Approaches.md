# P006 — Longest Consecutive Sequence

## Approach 01 — HashSet

### Idea

Store all numbers in a `HashSet`.

For every distinct number, check whether the previous number exists.

If:

    currentNumber - 1

does not exist, then `currentNumber` is the beginning of a consecutive
sequence.

From that starting number, keep checking:

    currentNumber + 1
    currentNumber + 2
    currentNumber + 3
    ...

until the next number does not exist.

Keep track of the longest sequence found.

### Example

Input:

    [100, 4, 200, 1, 3, 2]

HashSet:

    {100, 4, 200, 1, 3, 2}

Check `1`:

    0 does not exist

Therefore, `1` is the beginning of a sequence.

Then:

    1 → 2 → 3 → 4

Sequence length:

    4

Check `2`:

    1 exists

Therefore, `2` is not the beginning of a sequence.

Check `3`:

    2 exists

Therefore, `3` is not the beginning.

Check `4`:

    3 exists

Therefore, `4` is not the beginning.

Answer:

    4

### Important Optimization

Iterate over the `HashSet` instead of the original array:

    for (int currentNumber : numbers)

This ensures each distinct number is considered only once.

This is especially important when the input contains duplicates.

### Java Implementation

    // Time Complexity: O(n)
    // Space Complexity: O(n)

    import java.util.HashSet;
    import java.util.Set;

    public class _01_HashSet {

        static int longestConsecutive(int[] arr) {

            Set<Integer> numbers = new HashSet<>();

            // Store all numbers
            for (int number : arr) {
                numbers.add(number);
            }

            int longestLength = 0;

            // Process each distinct number
            for (int currentNumber : numbers) {

                // Check whether this is a sequence start
                if (!numbers.contains(currentNumber - 1)) {

                    int sequenceLength = 1;
                    int nextNumber = currentNumber + 1;

                    // Find consecutive numbers
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

            int[] arr = {
                    100, 4, 200, 1, 3, 2
            };

            int result = longestConsecutive(arr);

            System.out.println(
                    "Longest consecutive sequence length: " + result
            );

            // Expected Output:
            // Longest consecutive sequence length: 4
        }
    }

### Complexity

- Time Complexity: O(n)
- Space Complexity: O(n)

### Key Learning

For consecutive sequence problems:

    Put numbers in a HashSet.

Then:

    Find only sequence starting points.

A number is a starting point when:

    currentNumber - 1

does not exist.

Then keep checking:

    currentNumber + 1

until the sequence ends.

The important pattern is:

    HashSet
       ↓
    find sequence start
       ↓
    expand forward
       ↓
    update longest length