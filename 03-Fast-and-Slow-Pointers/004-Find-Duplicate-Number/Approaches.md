## Approach 01 — Brute Force — Time: O(n²), Space: O(1)

### Idea

Compare every pair of elements.

If two elements are equal, that value is the duplicate.

### Steps

1. Start with the first element.
2. Compare it with every element after it.
3. If both values are equal, return the value.
4. Repeat for all elements.
5. Return `-1` if no duplicate is found.

### Why It Works

Since the array contains one repeated number, comparing every pair
will eventually find the duplicate.

### Complexity

- **Time:** O(n²)
- **Space:** O(1)

### Status

✅ Completed