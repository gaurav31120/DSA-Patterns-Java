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

## Approach 02 — Sliding Window / Two Pointers — Time: O(n), Space: O(1)

### Idea

Maintain a variable-size sliding window using `left` and `right`.

Expand the window by multiplying `arr[right]`.

When the product becomes greater than or equal to `target`, shrink the
window from the left until the product becomes valid again.

For every valid window ending at `right`, all starting positions from
`left` to `right` form valid subarrays.

### Steps

1. Handle `target <= 1` by returning `0`.
2. Start with `left = 0` and `product = 1`.
3. Move `right` through the array.
4. Multiply `arr[right]` into the product.
5. While `product >= target`, divide by `arr[left]` and move `left`.
6. Add `right - left + 1` to the count.
7. Return the total count.

### Important Formula

For a valid window `[left ... right]`:

`count += right - left + 1`

This counts all valid subarrays ending at `right`.

### Why It Works

All array elements are positive.

Therefore, expanding the window can only increase the product, while
shrinking the window can only decrease the product.

This allows the two pointers to move only forward, giving O(n) time.

### Complexity

- **Time:** O(n)
- **Space:** O(1)

### Status

⚠️ Completed — Stuck