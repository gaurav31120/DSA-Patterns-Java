## Approach 01 — Brute Force — Time: O(n²), Space: O(k)

### Idea

Try every possible starting position and expand the substring one
character at a time.

Use a `HashSet` to track the distinct characters in the current
substring.

### Steps

1. Start from every index `i`.
2. Create a new `HashSet`.
3. Expand the substring using `j`.
4. Add each character to the set.
5. If distinct characters become greater than `K`, stop expanding.
6. Update the maximum length while the substring is valid.

### Why It Works

The substring is valid as long as it contains at most `K` distinct
characters.

Once the set contains more than `K` distinct characters, extending
the same substring cannot make it valid again, so we can stop.

### Complexity

- **Time:** O(n²)
- **Space:** O(k)

### Status

✅ Completed