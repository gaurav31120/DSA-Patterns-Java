## Approach 01 — Extra Array + Sorting

### Idea

Create an extra array and store the square of every element.
Then sort the squared values using `Arrays.sort()`.

### Steps

1. Create a result array of the same size.
2. Traverse the input array.
3. Store `arr[i] * arr[i]` in `result[i]`.
4. Sort the result array.
5. Return the result array.

### Complexity

- Time: O(n log n)
- Space: O(n)

### Status

✅ Completed