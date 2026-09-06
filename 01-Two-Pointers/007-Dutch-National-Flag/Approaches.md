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

## Approach 03 — Dutch National Flag / Three Pointers — Time: O(n), Space: O(1)

### Idea

Use three pointers to divide the array into four regions:

```text
[ 0s ][ 1s ][ Unknown ][ 2s ]
       ↑      ↑         ↑
      left    i        right
```

The pointer `i` processes the unknown region.

### Steps

1. Initialize `left = 0`, `i = 0`, and `right = n - 1`.
2. If `arr[i] == 0`, swap it with `arr[left]`, then increment
   `left` and `i`.
3. If `arr[i] == 1`, it is already in the correct region, so
   increment `i`.
4. If `arr[i] == 2`, swap it with `arr[right]` and decrement
   `right`.
5. Do not increment `i` when processing `2`, because the element
   swapped from the right is still unknown.
6. Continue while `i <= right`.

### Why It Works

At every step:

* Elements before `left` are `0`.
* Elements between `left` and `i - 1` are `1`.
* Elements after `right` are `2`.
* Elements from `i` to `right` are still unknown.

The algorithm keeps shrinking the unknown region until every element
is placed in its correct region.

### Complexity

* **Time:** O(n)
* **Space:** O(1)

### Status

✅ Completed

