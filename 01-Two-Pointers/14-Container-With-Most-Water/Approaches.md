## Approach 01 — Nested Loops — Time: O(n²), Space: O(1)

### Idea

Check every pair of lines and calculate the amount of water they can
contain.

The area depends on the distance between the two lines and the shorter
of their heights.

### Steps

1. Choose the first line using `i`.
2. Choose every line after it using `j`.
3. Calculate the width: `j - i`.
4. Find the smaller height.
5. Calculate the area.
6. Update the maximum area.

### Formula

    width = j - i

    height = min(arr[i], arr[j])

    area = width × height

### Example

For:

    arr = [1, 8, 6, 2, 5, 4, 8, 3, 7]

Using indices `1` and `8`:

    width = 8 - 1 = 7

    height = min(8, 7) = 7

    area = 7 × 7 = 49

### Complexity

- **Time:** O(n²)
- **Space:** O(1)

### Status

✅ Completed — Solved