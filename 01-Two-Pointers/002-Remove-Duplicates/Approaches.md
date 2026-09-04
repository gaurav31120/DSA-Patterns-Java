# Approaches

## Approach 01 — Extra Array

### Idea

Use an additional array to store unique elements.

Since the input array is sorted, duplicate values are adjacent. Compare each element with the next element. If they are different, the next element is unique and is added to the result array.

`j` represents the number of unique elements found.

### Steps

1. Create an extra array of the same size.
2. Store the first element.
3. Traverse the sorted array.
4. Compare `arr[i]` with `arr[i + 1]`.
5. If they are different, store `arr[i + 1]` in the result array.
6. Increment `j`.
7. Return `j`.

### Complexity

- Time: O(n)
- Space: O(n)

### Status

✅ Completed

This approach is useful for understanding the duplicate-detection logic, but it uses extra space and does not satisfy the strict in-place requirement of the original problem.