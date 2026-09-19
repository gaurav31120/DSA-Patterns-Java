## Approach 01 — Nested Loops — Time: O(n²), Space: O(1)

### Idea

Check every possible starting position and expand the subarray using
a second loop.

Maintain the product of the current subarray and count it whenever the
product is strictly less than the target.

### Steps

1. Start from every index `i`.
2. Set `product = 1`.
3. Expand the subarray using `j`.
4. Multiply `arr[j]` into `product`.
5. If `product < target`, increment the count.
6. If `product >= target`, stop for the current starting position.
7. Return the total count.

### Why It Works

Every contiguous subarray is considered exactly once.

Since all elements are positive, once the product becomes greater than
or equal to the target, adding more elements cannot make the product
smaller.

Therefore, we can stop expanding from that starting position.

### Complexity

- **Time:** O(n²)
- **Space:** O(1)

### Status

✅ Completed