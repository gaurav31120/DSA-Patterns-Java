## Approach 01 — HashSet — Time: O(k), Space: O(k)

### Idea

Treat each generated number as a state in a sequence.

Store every number in a `HashSet`.

- If we reach `1`, the number is happy.
- If a number appears again, a cycle exists, so the number is not happy.

### Steps

1. Start with `n = num`.
2. While `n != 1`:
   - Check if `n` already exists in the set.
   - If yes, return `false`.
   - Add `n` to the set.
   - Calculate the sum of squares of its digits.
   - Set `n = sum`.
3. If `n` becomes `1`, return `true`.

### Complexity

- **Time:** O(k)
- **Space:** O(k)

Where `k` is the number of generated states.

### Status

✅ Completed