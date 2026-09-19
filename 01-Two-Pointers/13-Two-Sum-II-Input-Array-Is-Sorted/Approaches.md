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

## Approach 03 — Two Pointers — Time: O(n), Space: O(1)

### Idea

Use two pointers because the array is already sorted.

Start one pointer at the beginning and the other at the end.

Compare their sum with the target and move the appropriate pointer.

### Steps

1. Set `left = 0`.
2. Set `right = n - 1`.
3. Calculate `arr[left] + arr[right]`.
4. If the sum equals the target, return the 1-based indices.
5. If the sum is smaller than the target, move `left` forward.
6. If the sum is larger than the target, move `right` backward.
7. Continue until the pair is found.

### Why It Works

Because the array is sorted:

- Moving `left` forward increases the sum.
- Moving `right` backward decreases the sum.

Therefore, each pointer only moves forward or backward once through
the array, giving a linear-time solution.

### Complexity

- **Time:** O(n)
- **Space:** O(1)

### Status

✅ Completed — Solved