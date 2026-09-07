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

## Approach 02 — Known Cycle — Time: O(k), Space: O(1)

### Idea

Every unhappy number eventually enters the same cycle:

4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4

Therefore, instead of storing visited numbers, we can stop when the sequence reaches `4`.

### Steps

1. Start with `n = num`.
2. Continue while `n` is neither `1` nor `4`.
3. Calculate the sum of squares of the digits.
4. Set `n = sum`.
5. If `n == 1`, return `true`.
6. If `n == 4`, return `false`.

### Complexity

- **Time:** O(k)
- **Space:** O(1)

Where `k` is the number of generated states.

### Status

✅ Completed