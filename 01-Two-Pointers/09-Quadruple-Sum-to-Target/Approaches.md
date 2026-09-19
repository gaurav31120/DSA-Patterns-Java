## Approach 01 — Nested Loops — Time: O(n⁴), Space: O(1) extra space excluding output

### Idea

Use four nested loops to examine every combination of four different
indices.

When the four elements sum to the target, create the quadruplet,
sort it, and check whether it has already been added.

### Steps

1. Choose the first index `i`.
2. Choose the second index `j`.
3. Choose the third index `k`.
4. Choose the fourth index `l`.
5. Calculate the four-element sum.
6. If the sum equals the target, create the quadruplet.
7. Sort the quadruplet so its order is consistent.
8. Add it only if it is not already present.

### Why It Works

The four loops examine every possible combination of four distinct
indices.

Sorting each matching quadruplet gives it a consistent order, allowing
duplicate quadruplets to be detected.

### Complexity

- **Time:** O(n⁴)
- **Space:** O(1) extra space excluding the returned result.

### Status

✅ Completed — Solved

## Approach 02 — HashSet + Three Loops — Time: O(n³), Space: O(n) auxiliary space excluding output

### Idea

Fix the first two elements and use a third loop to examine the remaining
elements.

For the current `arr[k]`, calculate the fourth value required to reach
the target.

Use a `HashSet` to check whether that required value has already been
seen.

### Steps

1. Fix the first index `i`.
2. Fix the second index `j`.
3. Create an empty `HashSet` for the current pair.
4. Move `k` from `j + 1` to the end.
5. Calculate the required fourth value.
6. Check whether the required value exists in the set.
7. Create and store the quadruplet when found.
8. Add `arr[k]` to the set.

### Complexity

- **Time:** O(n³)
- **Space:** O(n) auxiliary space excluding output.

### Status

✅ Completed — Seen

## Approach 03 — Sorting + Two Pointers — Time: O(n³), Space: O(1) auxiliary space excluding output

### Idea

Sort the array first.

Fix the first two elements using two loops, then use two pointers to
find the remaining two elements.

Because the array is sorted:

- If the sum is smaller than the target, move `left`.
- If the sum is larger than the target, move `right`.
- If the sum equals the target, store the quadruplet and move both
  pointers.

Skip duplicate values to ensure unique quadruplets.

### Steps

1. Sort the array.
2. Fix the first element using `i`.
3. Skip duplicate `i` values.
4. Fix the second element using `j`.
5. Skip duplicate `j` values.
6. Set `left = j + 1` and `right = n - 1`.
7. Calculate the four-element sum.
8. If `sum < target`, move `left`.
9. If `sum > target`, move `right`.
10. If `sum == target`, store the quadruplet.
11. Move both pointers and skip duplicates.
12. Continue until all possibilities are checked.

### Why It Works

After sorting, moving `left` increases the sum and moving `right`
decreases the sum.

This lets us find the required pair efficiently instead of using
another nested loop.

Duplicate values are skipped at every pointer level so that the result
contains only unique quadruplets.

### Complexity

- **Time:** O(n³)
- **Space:** O(1) auxiliary space excluding the returned result.

### Status

✅ Completed — Hint 2