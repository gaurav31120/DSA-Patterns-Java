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

## Approach 02 — Sorting — Time: O(n log n), Space: O(1)

### Idea

Sort the array so that duplicate values become adjacent.

Then compare neighboring elements to find the duplicate.

### Steps

1. Sort the array.
2. Traverse the sorted array.
3. Compare each element with the next element.
4. If they are equal, return that value.
5. Return `-1` if no duplicate is found.

### Why It Works

After sorting, equal values are placed next to each other.

Therefore, the duplicate can be found by checking adjacent elements.

### Limitation

Sorting modifies the input array, so this approach violates the
problem's requirement of not modifying the array.

### Complexity

- **Time:** O(n log n)
- **Space:** O(1) auxiliary

### Status

⚠️ Conceptual / Skip