# P017 — Is Subsequence

**LeetCode:** #392  
**Pattern:** Two Pointers  
**Difficulty:** Easy

---

# Approaches

We have **2 meaningful approaches**:

| Approach | Technique | Time | Space | Status | Priority |
|---|---|---:|---:|---|---|
| Approach 01 | Nested Loops / Searching Forward | O(n × m) | O(1) | Solved | OPTIONAL |
| Approach 02 | Two Pointers | O(n + m) | O(1) | Solved | MUST MASTER 🔥 |

---

# Approach 01 — Nested Loops / Searching Forward

- **Status:** Solved
- **Time Complexity:** O(n × m)
- **Space Complexity:** O(1)
- **Priority:** OPTIONAL

## Idea

For every character in `s`, search for the same character in `t` starting from the position after the previous match.

We use:

    start

to remember where the next search in `t` should begin.

## Steps

1. Start with `start = 0`.
2. Traverse every character of `s`.
3. For each character, search `t` from `start`.
4. When a matching character is found:
   - mark it as found
   - move `start` to `j + 1`
5. If a character cannot be found, return `false`.
6. If every character is matched, return `true`.

## Key Logic

    s[i]
      ↓
    Search t from start
      ↓
    Match found?
      ↓
    start = j + 1

## Example

    s = "abc"
    t = "ahbgdc"

Search for `a`:

    a h b g d c
    ↑

Match found at index `0`.

Next search starts from:

    start = 1

Search for `b`:

    a h b g d c
      → → ↑

Match found at index `2`.

Next search starts from:

    start = 3

Search for `c`:

    a h b g d c
      → → → → → ↑

Match found.

Therefore:

    true

## Complexity

    Time: O(n × m)
    Space: O(1)

---

# Approach 02 — Two Pointers

- **Status:** Solved
- **Time Complexity:** O(n + m)
- **Space Complexity:** O(1)
- **Priority:** MUST MASTER 🔥

## Idea

Use two pointers:

- `i` points to the current character in `s`.
- `j` points to the current character in `t`.

We scan `t` from left to right.

When:

    s.charAt(i) == t.charAt(j)

we have successfully matched one character of `s`, so:

    i++

Regardless of whether the characters match, we move through `t`:

    j++

At the end, if all characters of `s` were matched, then `s` is a subsequence of `t`.

## Steps

1. Initialize `i = 0`.
2. Initialize `j = 0`.
3. Continue while both strings still have characters to inspect.
4. If `s[i] == t[j]`, increment `i`.
5. Always increment `j`.
6. Return `true` when `i == s.length()`.

## Key Logic

    s[i] == t[j]
        ↓
      i++

    Always:
      j++

## Example

    s = "abc"
    t = "ahbgdc"

Compare:

    a == a  → match → i++
    b != h  → skip t
    b == b  → match → i++
    c != g  → skip t
    c != d  → skip t
    c == c  → match → i++

All characters of `s` are matched.

Therefore:

    true

## Complexity

    Time: O(n + m)
    Space: O(1)