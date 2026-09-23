# P014 — Swapping Nodes in a Linked List

## Problem

**LeetCode #1721 — Swapping Nodes in a Linked List**

**Pattern:** Fast & Slow Pointers

**Difficulty:** Medium

---

## Description

Given the head of a linked list and an integer `k`, swap the values of:

- the `k`th node from the beginning
- the `k`th node from the end

The list is 1-indexed.

Return the head of the modified linked list.

---

## Example 1

Input:

    1 -> 2 -> 3 -> 4 -> 5
    k = 2

The 2nd node from the beginning:

    2

The 2nd node from the end:

    4

Swap their values.

Output:

    1 -> 4 -> 3 -> 2 -> 5

---

## Example 2

Input:

    7 -> 9 -> 6 -> 6 -> 7 -> 8 -> 3 -> 0 -> 9 -> 5
    k = 5

The 5th node from the beginning:

    7

The 5th node from the end:

    8

Output:

    7 -> 9 -> 6 -> 6 -> 8 -> 7 -> 3 -> 0 -> 9 -> 5

---

## Approaches

### Approach 01 — Two Pass

First find the length of the linked list.

Then find:

- the `k`th node from the beginning
- the `(length - k + 1)`th node from the beginning

Finally swap their values.

**Time:** O(n)

**Space:** O(1)

---

### Approach 02 — Fast & Slow / Two Pointers

Find the `k`th node from the beginning while moving through the list.

At the same time, use a fast pointer to create a gap of `k` nodes.

Then move the slow pointer with the fast pointer until the fast pointer reaches the end.

The slow pointer will reach the `k`th node from the end.

Finally swap the values of the two nodes.

**Time:** O(n)

**Space:** O(1)

**MUST MASTER**

---

## Important Point

We only need to swap the node values.

We do NOT need to change the linked-list structure.

For example:

    1 -> 2 -> 3 -> 4 -> 5

Swapping nodes `2` and `4` means:

    1 -> 4 -> 3 -> 2 -> 5

---

## Edge Cases

- `k = 1`
- `k = length`
- The two target nodes are the same
- The two target nodes are adjacent
- List contains exactly two nodes

---

## Goal

Master finding a node from the end using a fixed-gap two-pointer technique.

---

## Status

⏳ In Progress