# Approaches

## Approach 01 — Brute Force — Time: O(n³), Space: O(1)

### Idea

Use three nested loops to generate every possible combination of
three different elements.

For every triplet, calculate its sum.

If the sum is strictly smaller than the target, increment the count.

### Steps

1. Create a `count` variable and initialize it to `0`.
2. Use three nested loops:
   - `i`
   - `j = i + 1`
   - `k = j + 1`
3. Calculate:
   `sum = arr[i] + arr[j] + arr[k]`
4. If `sum < target`, increment `count`.
5. Return `count`.

### Complexity

- Time: O(n³)
- Space: O(1)

### Status

✅ Completed

---

## Approach 02 — Sorting + Two Pointers — Time: O(n²), Space: O(1)

### Idea

Sort the array first.

Fix one element using index `i`, then use two pointers,
`left` and `right`, to find triplets whose sum is smaller
than the target.

The key optimization is:

If:

`arr[i] + arr[left] + arr[right] < target`

then because the array is sorted, every element between `left`
and `right` will also produce a sum smaller than the target
when paired with `arr[i]`.

Therefore, we can count all of those triplets at once instead
of checking them individually.

### Steps

1. Sort the array.
2. Initialize `count = 0`.
3. Iterate `i` from `0` to `n - 3`.
4. Set:
   - `left = i + 1`
   - `right = n - 1`
5. While `left < right`:
   - Calculate the current three-element sum.
   - If the sum is smaller than the target:
     - Count all valid triplets from `left` through `right`.
     - Move `left` forward.
   - Otherwise:
     - Move `right` backward.
6. Return `count`.

### Key Insight

Suppose the sorted array is:

```text
[-2, 0, 1, 3]