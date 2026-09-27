# P002 — Reverse a Sub-list

**LeetCode:** #92
**Pattern:** In-Place Reversal of a LinkedList
**Difficulty:** Medium

---

## Problem

Given the head of a singly linked list and two positions `left` and `right`,
reverse the nodes of the list from position `left` to position `right`.

Return the reversed linked list.

Positions are 1-indexed.

---

## Example 1

### Input

head = [1,2,3,4,5]
left = 2
right = 4

### Output

[1,4,3,2,5]

### Explanation

Original:

1 → 2 → 3 → 4 → 5

Reverse positions 2 through 4:

2 → 3 → 4

becomes:

4 → 3 → 2

Final:

1 → 4 → 3 → 2 → 5

---

## Example 2

### Input

head = [5]
left = 1
right = 1

### Output

[5]

---

## Key Observation

We do not need to reverse the entire linked list.

Only the nodes between positions `left` and `right` need to be reversed.

The part before `left` and the part after `right` should remain unchanged.

---

## Important Structure

For:

1 → 2 → 3 → 4 → 5

and:

left = 2
right = 4

Think of the list as:

1 → [2 → 3 → 4] → 5

Only the bracketed portion is reversed:

1 → [4 → 3 → 2] → 5

---

## Approaches

### Approach 01

Iterative In-Place Sub-list Reversal

### Approach 02

Recursive Sub-list Reversal

---

## Complexity Targets

### Approach 01

- Time Complexity: O(n)
- Space Complexity: O(1)

### Approach 02

- Time Complexity: O(n)
- Space Complexity: O(n)