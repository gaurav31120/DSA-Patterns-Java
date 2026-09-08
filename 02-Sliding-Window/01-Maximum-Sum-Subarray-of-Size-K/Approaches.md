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

## Approach 02 — Sliding Window — Time: O(n), Space: O(1)

### Idea

Instead of recalculating the sum of every window, maintain the current window sum.

When the window moves one position:

- Remove the element leaving the window.
- Add the element entering the window.

This allows each element to be processed only once.

### Steps

1. Calculate the sum of the first `K` elements.
2. Store it as `maxSum`.
3. Start sliding the window from index `K`.
4. Remove the outgoing element using `arr[i - k]`.
5. Add the incoming element using `arr[i]`.
6. Update `maxSum`.
7. Continue until the array ends.

### Example

For:

`arr = [2, 1, 5, 1, 3, 2]`, `K = 3`

First window:

`[2, 1, 5]` → `8`

Slide:

`8 - 2 + 1 = 7`

Slide:

`7 - 1 + 3 = 9`

Slide:

`9 - 5 + 2 = 6`

Maximum sum = `9`

### Why It Is Better

Brute Force recalculates all `K` elements for every window.

Sliding Window reuses the previous window's sum.

Therefore:

`O(n × k) → O(n)`

### Complexity

- **Time:** O(n)
- **Space:** O(1)

### Status

✅ Completed