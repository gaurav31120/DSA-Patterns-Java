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

## Approach 02 — Sliding Window — Time: O(n), Space: O(1)

### Idea

Use a variable-size sliding window.

Expand the window using `right` until the sum becomes greater than
or equal to the target.

Then shrink the window from the left while it remains valid to find
the smallest possible length.

### Steps

1. Start `left = 0` and `sum = 0`.
2. Move `right` through the array.
3. Add `arr[right]` to the sum.
4. When `sum >= target`, calculate the window length.
5. Update the minimum length.
6. Remove `arr[left]` and move `left`.
7. Keep shrinking while the window is valid.
8. Return `0` if no valid subarray exists.

### Why It Works

All array elements are positive.

Therefore:

- Expanding the window increases the sum.
- Shrinking the window decreases the sum.

Once the target is reached, we can safely shrink from the left and
find the smallest valid window.

### Complexity

- **Time:** O(n)
- **Space:** O(1)

### Status

✅ Completed