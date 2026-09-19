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