## Approach 01 — Nested Loops — Time: O(n²), Space: O(1)

### Idea

Check every possible pair of elements using two nested loops.

When the sum of two elements equals the target, return their 1-based
indices.

### Steps

1. Fix the first element using `i`.
2. Check every element after `i` using `j`.
3. Calculate `arr[i] + arr[j]`.
4. If the sum equals the target, return `i + 1` and `j + 1`.
5. Return `[-1, -1]` if no pair is found.

### Complexity

- **Time:** O(n²)
- **Space:** O(1)

### Status

✅ Completed — Solved