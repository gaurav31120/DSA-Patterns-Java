# Approaches

## Approach 01 — Brute Force — Time: O(n³), Space: O(1)

### Idea

Use three nested loops to generate every possible combination of
three different elements.

For every triplet, calculate its sum and compare its distance from
the target with the closest sum found so far.

### Steps

1. Create `minDiff` and initialize it to `Integer.MAX_VALUE`.
2. Create `resultSum` to store the closest sum.
3. Use three nested loops:
   - `i`
   - `j = i + 1`
   - `k = j + 1`
4. Calculate:
   `sum = arr[i] + arr[j] + arr[k]`
5. If `sum == target`, return immediately.
6. Calculate:
   `diff = Math.abs(sum - target)`
7. If `diff < minDiff`, update:
   - `minDiff`
   - `resultSum`
8. Return `resultSum`.

### Status

✅ Completed

---

## Approach 02 — Sorting + Two Pointers — Time: O(n²), Space: O(1)

### Idea

Sort the array first.

Then fix one element using index `i` and use two pointers,
`left` and `right`, to search for the remaining two elements.

For every triplet, calculate how far its sum is from the target.

If the current sum is closer than the previous best sum, update
the answer.

Because the array is sorted:

- If `sum < target`, move `left` forward.
- If `sum > target`, move `right` backward.
- If `sum == target`, return immediately.

### Steps

1. Sort the array.
2. Initialize `minDiff` to `Integer.MAX_VALUE`.
3. Initialize `resultSum`.
4. Iterate `i` from `0` to `n - 3`.
5. Set:
   - `left = i + 1`
   - `right = n - 1`
6. While `left < right`:
   - Calculate the three-element sum.
   - Calculate the absolute difference from the target.
   - Update the closest answer if necessary.
   - If the sum equals the target, return it.
   - If the sum is smaller than the target, increment `left`.
   - Otherwise decrement `right`.
7. Return the closest sum.

### Key Pattern

```text
Sort
  ↓
Fix i
  ↓
left = i + 1
right = n - 1
  ↓
Calculate 3Sum
  ↓
Track closest difference
  ↓
sum < target → left++
sum > target → right--
sum == target → return