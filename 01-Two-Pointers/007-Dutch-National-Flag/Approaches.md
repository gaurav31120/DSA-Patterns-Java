## Approach 01 — Counting — Time: O(n), Space: O(1)

### Idea

Since the array contains only `0`, `1`, and `2`, count how many times
each value appears.

Then overwrite the original array in sorted order.

### Steps

1. Count the number of `0`s, `1`s, and `2`s.
2. Start from index `0`.
3. Fill `count0` positions with `0`.
4. Fill `count1` positions with `1`.
5. Fill `count2` positions with `2`.

### Why It Works

After counting all elements, we know exactly how many `0`s, `1`s,
and `2`s are present. Therefore, we can safely overwrite the array
in sorted order.

### Complexity

* **Time:** O(n)
* **Space:** O(1)

### Status

✅ Completed


## Approach 02 — Two Passes / Overwrite — Time: O(n), Space: O(1)

### Idea

Use two passes over the array.

The first pass places all `0`s at the beginning. The second pass
places all `1`s immediately after the `0`s. Since the array contains
only `0`, `1`, and `2`, all remaining elements are `2`s.

### Steps

1. Maintain a pointer `j` representing the next position for placement.
2. Traverse the array and swap every `0` with `arr[j]`.
3. Increment `j` after placing each `0`.
4. Traverse the array again and swap every `1` with `arr[j]`.
5. Increment `j` after placing each `1`.
6. The remaining positions automatically contain `2`s.

### Why It Works

After the first pass, all `0`s are placed at the beginning.

After the second pass, all `1`s are placed immediately after the `0`s.

Because the array contains only `0`, `1`, and `2`, all remaining
elements must be `2`.

### Complexity

* **Time:** O(n)
* **Space:** O(1)

### Status

✅ Completed
