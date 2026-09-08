## Approach 01 — Brute Force — Time: O(n²), Space: O(1)

### Idea

Try every possible starting position and expand the subarray until
its sum becomes greater than or equal to the target.

Track the smallest valid subarray length.

### Steps

1. Start from every index.
2. Reset the sum to `0`.
3. Keep adding elements to the current subarray.
4. When `sum >= target`, calculate its length.
5. Update the minimum length.
6. Stop expanding from that starting position.
7. Return `0` if no valid subarray exists.

### Why It Works

Every possible starting position is checked, and the inner loop finds
the first valid subarray for that starting position.

Because all elements are positive, once the sum reaches the target,
adding more elements can only make the window larger.

### Complexity

- **Time:** O(n²)
- **Space:** O(1)

### Status

✅ Completed