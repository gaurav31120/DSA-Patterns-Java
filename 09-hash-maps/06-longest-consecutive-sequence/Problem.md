# P006 — Longest Consecutive Sequence

**LeetCode:** #128
**Pattern:** Hash Maps
**Difficulty:** Medium

---

## Problem

Given an unsorted integer array, find the length of the longest sequence
of consecutive integers.

The numbers in the sequence must increase by exactly `1`.

The sequence does not need to appear next to each other in the input array.

Return the length of the longest consecutive sequence.

---

## Example 1

### Input

nums = [100, 4, 200, 1, 3, 2]

### Output

4

### Explanation

The longest consecutive sequence is:

1, 2, 3, 4

Its length is `4`.

---

## Example 2

### Input

nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]

### Output

9

### Explanation

The longest consecutive sequence is:

0, 1, 2, 3, 4, 5, 6, 7, 8

Its length is `9`.

---

## Example 3

### Input

nums = [1, 3, 5, 7]

### Output

1

### Explanation

No two numbers are consecutive, so the longest sequence has length `1`.

---

## Key Observation

For every number, we need to know whether another number exists.

For example:

    1 → does 2 exist?
    2 → does 3 exist?
    3 → does 4 exist?
    4 → does 5 exist?

A HashSet is useful because it allows us to quickly check whether a number
exists.

---

## Important Observation

We should start counting a sequence only when the previous number does not exist.

For example:

    1, 2, 3, 4

Start from `1` because:

    0 does not exist.

Do not start from `2` because:

    1 exists.

This prevents repeatedly counting the same sequence.

---

## Approaches

### Approach 01

HashSet

### Approach 02

Sorting

---

## Complexity Targets

### Approach 01

- Time: O(n)
- Space: O(n)

### Approach 02

- Time: O(n log n)
- Space: O(log n) to O(n), depending on the sorting implementation