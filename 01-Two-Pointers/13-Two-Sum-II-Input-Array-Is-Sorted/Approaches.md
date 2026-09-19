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

## Approach 02 — HashMap — Time: O(n), Space: O(n)

### Idea

For each element, calculate the complement required to reach the target.

Store previously seen values in a `HashMap` along with their indices.

If the complement is already present, the required pair has been found.

### Steps

1. Create a `HashMap` of value → index.
2. Traverse the array.
3. Calculate `complement = target - arr[i]`.
4. Check whether the complement exists in the map.
5. If it exists, return both 1-based indices.
6. Otherwise, store the current value and index.
7. Return `[-1, -1]` if no pair is found.

### Why It Works

For every current value, we know exactly which value is required to
reach the target.

The `HashMap` lets us check whether that value has already appeared in
constant average time.

### Complexity

- **Time:** O(n)
- **Space:** O(n)

### Status

✅ Completed — Solved