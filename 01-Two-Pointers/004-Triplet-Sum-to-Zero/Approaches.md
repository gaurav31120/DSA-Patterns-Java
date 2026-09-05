# Approaches

## Approach 01 — Brute Force — Time: O(n³), Space: O(m)

### Idea

Use three nested loops to generate every possible combination of
three different elements.

For every combination, check whether the sum of the three elements
is zero.

When a valid triplet is found:

1. Store the three values in a list.
2. Sort the triplet so that the same value combination always has
   the same representation.
3. Check whether the triplet already exists in the result.
4. Add it only if it is not already present.

### Steps

1. Create a result list to store all unique triplets.
2. Use three nested loops:
   - `i`
   - `j = i + 1`
   - `k = j + 1`
3. Calculate:
   `arr[i] + arr[j] + arr[k]`
4. If the sum is `0`, create a triplet.
5. Sort the triplet.
6. Check `result.contains(triplet)`.
7. Add the triplet if it is not already present.
8. Return the result.

### Status

✅ Completed

---

## Approach 02 — Sorting + Two Pointers — Time: O(n²), Space: O(m)

### Idea

Sort the array first.

Then fix one element using index `i` and use two pointers
(`left` and `right`) to find two additional elements whose sum
equals `-arr[i]`.

Because the array is sorted:

- If the sum is too small, move `left` forward.
- If the sum is too large, move `right` backward.
- If the sum is zero, store the triplet and move both pointers.

Duplicate values are skipped to ensure that only unique triplets
are returned.

### Steps

1. Sort the array.
2. Iterate `i` from `0` to `n - 3`.
3. Skip duplicate values of `arr[i]`.
4. Set `left = i + 1`.
5. Set `right = n - 1`.
6. While `left < right`:
   - Calculate the sum of `arr[i]`, `arr[left]`, and `arr[right]`.
   - If sum is `0`, store the triplet.
   - If sum is less than `0`, increment `left`.
   - If sum is greater than `0`, decrement `right`.
7. After finding a valid triplet, skip duplicate `left` values.
8. Skip duplicate `right` values.
9. Return the result.

### Why Two Pointers Work

After sorting:

```text
[-4, -1, -1, 0, 1, 2]