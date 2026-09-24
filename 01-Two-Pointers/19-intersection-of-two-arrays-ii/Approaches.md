# P019 — Intersection of Two Arrays II

## Approach 01 — HashMap / Frequency Counting

### Idea

Use a `HashMap` to store the frequency of each element in one array.

Then traverse the other array:

1. Check whether the current element has a remaining frequency.
2. If yes, add it to the result.
3. Decrease its frequency by `1`.
4. Continue until the array is processed.

Duplicates are automatically handled because every match consumes one occurrence.

### Example

arr1 = [1,2,2,3]  
arr2 = [2,2,2,4]

Frequency map:

1 → 1  
2 → 2  
3 → 1

Traverse arr2:

2 → add, remaining frequency = 1  
2 → add, remaining frequency = 0  
2 → cannot add  
4 → not present

Result:

[2,2]

### Java Implementation

    import java.util.*;

    public class _01_HashMap {

        // Time: O(n + m)
        // Space: O(min(n, m) + k)
        // k = size of result

        static int[] intersection(int[] arr1, int[] arr2) {

            // Always build the map from the smaller array
            if (arr1.length > arr2.length) {
                int[] temp = arr1;
                arr1 = arr2;
                arr2 = temp;
            }

            // Store frequency of elements
            Map<Integer, Integer> freq = new HashMap<>();

            for (int num : arr1) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }

            // Store common elements
            List<Integer> result = new ArrayList<>();

            for (int num : arr2) {

                int count = freq.getOrDefault(num, 0);

                if (count > 0) {
                    result.add(num);

                    // Consume one occurrence
                    freq.put(num, count - 1);
                }
            }

            // Convert List<Integer> to int[]
            int[] ans = new int[result.size()];

            for (int i = 0; i < result.size(); i++) {
                ans[i] = result.get(i);
            }

            return ans;
        }
    }

### Complexity

- Time: O(n + m)
- Space: O(min(n, m) + k)

### Key Interview Point

This approach is useful when we need to preserve duplicate frequencies.

The important distinction is:

    Set → only checks whether a value exists

    Frequency Map → checks how many occurrences are available

---

## Approach 02 — Sorting + Two Pointers

Coming next.