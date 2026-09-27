# P001 — Reverse a Linked List

**LeetCode:** #206
**Pattern:** In-Place Reversal of a LinkedList
**Difficulty:** Easy

---

## Problem

Given the head of a singly linked list, reverse the list and return the
new head.

---

## Example

### Input

1 → 2 → 3 → 4 → 5 → null

### Output

5 → 4 → 3 → 2 → 1 → null

---

## Example 2

### Input

1 → 2 → null

### Output

2 → 1 → null

---

## Example 3

### Input

null

### Output

null

---

## Key Observation

To reverse a linked list, every node's `next` pointer needs to point to the
previous node instead of the next node.

For example:

Before:

1 → 2 → 3 → null

After:

1 ← 2 ← 3

The new head becomes:

3

---

## Approaches

### Approach 01

Iterative Pointer Reversal

### Approach 02

Recursive Reversal

---

## Complexity Targets

### Approach 01

- Time Complexity: O(n)
- Space Complexity: O(1)

### Approach 02

- Time Complexity: O(n)
- Space Complexity: O(n) because of the recursion call stack