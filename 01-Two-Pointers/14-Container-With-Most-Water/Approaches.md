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

## Approach 02 — Two Pointers — Time: O(n), Space: O(1)

### Idea

Start with the widest possible container using one pointer at the
beginning and one pointer at the end.

Calculate the area and then move the pointer pointing to the shorter
line.

### Steps

1. Set `left = 0`.
2. Set `right = n - 1`.
3. Calculate the width.
4. Calculate the smaller height.
5. Calculate the area.
6. Update the maximum area.
7. Move the shorter pointer.
8. Continue until `left >= right`.

### Formula

    width = right - left

    height = min(arr[left], arr[right])

    area = width × height

### Why It Works

The current area is limited by the shorter line.

When moving inward, the width always decreases. Therefore, moving the
longer line cannot improve the area while the shorter line remains the
limiting height.

So we move the shorter line in an attempt to find a taller boundary.

### Complexity

- **Time:** O(n)
- **Space:** O(1)

### Status

✅ Completed — Solved