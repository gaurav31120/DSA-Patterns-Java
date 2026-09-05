# Approaches

## Approach 01 — Brute Force

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

### Complexity

- Time: O(n³)
- Space: O(m), where `m` is the number of unique triplets stored

### Status

✅ Completed

---

## Approach 02 — Sorting + Two Pointers

### Idea

Sort the array first.

Fix one element using index `i`, then use two pointers to find
two additional elements whose sum is equal to `-arr[i]`.

### Complexity

- Time: O(n²)
- Space: O(m), excluding the output list

### Status

⏳ Pending

---

# Approach Comparison

| Approach | Time | Space | Key Idea |
|----------|------|-------|----------|
| Brute Force | O(n³) | O(m) | Check every combination of 3 elements |
| Sorting + Two Pointers | O(n²) | O(m) | Fix one element and search the remaining array with two pointers |

## ⭐ Best Approach

**Approach 02 — Sorting + Two Pointers**

It reduces the search from O(n³) to O(n²) by using the sorted
property of the array and two pointers.