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

## Approach 02 — HashSet

### Idea

Use a HashSet to keep track of values that have already been seen.

When a value is encountered for the first time, write it into the original array at index `j` and increment `j`.

### Steps

1. Create a HashSet.
2. Initialize `j = 0`.
3. Traverse the array.
4. Add each value to the set.
5. If the value is newly added, write it to `arr[j]`.
6. Increment `j`.
7. Return `j`.

### Complexity

- Time: O(n)
- Space: O(n)

### Status

✅ Completed

This approach modifies the original array but uses O(n) extra space for the HashSet.