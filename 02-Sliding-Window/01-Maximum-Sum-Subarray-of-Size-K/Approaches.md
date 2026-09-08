## Approach 01 — Brute Force — Time: O(n × k), Space: O(1)

### Idea

Check every contiguous subarray of size `K`.

For each starting position, calculate the complete sum of `K` elements and keep track of the maximum sum.

### Steps

1. Start from the first possible window.
2. Calculate the sum of `K` consecutive elements.
3. Compare the sum with `maxSum`.
4. Move the window start to the next position.
5. Repeat until all possible windows are checked.

### Example

For:

`arr = [2, 1, 5, 1, 3, 2]`, `K = 3`

Window sums:

- `[2, 1, 5]` → `8`
- `[1, 5, 1]` → `7`
- `[5, 1, 3]` → `9`
- `[1, 3, 2]` → `6`

Maximum sum = `9`

### Complexity

- **Time:** O(n × k)
- **Space:** O(1)

### Status

✅ Completed