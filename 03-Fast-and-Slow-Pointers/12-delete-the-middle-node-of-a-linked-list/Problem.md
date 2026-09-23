# P012 — Delete the Middle Node of a Linked List

## Problem

**LeetCode #2095 — Delete the Middle Node of a Linked List**

**Pattern:** Fast & Slow Pointers

**Difficulty:** Medium

---

## Description

Given the head of a singly linked list, delete the middle node of the linked list and return the head of the modified list.

The middle node is the node at index:

    floor(n / 2)

where indexing starts from `0`.

For an even-length linked list, this means the second of the two middle nodes is removed.

---

## Example 1

Input:

    1 -> 3 -> 4 -> 7 -> 1 -> 2 -> 6

Output:

    1 -> 3 -> 4 -> 1 -> 2 -> 6

Middle node:

    7

---

## Example 2

Input:

    1 -> 2 -> 3 -> 4

Output:

    1 -> 2 -> 4

Middle node:

    3

---

## Example 3

Input:

    1 -> 2

Output:

    1

Middle node:

    2

---

## Approaches

### Approach 01 — ArrayList

Store all nodes in an `ArrayList`.

Find the middle node using its index and change the previous node's `next` pointer.

**Time:** O(n)

**Space:** O(n)

---

### Approach 02 — Fast & Slow Pointers

Use `slow` and `fast` pointers to reach the middle node.

Keep track of the node before `slow`, then remove the middle node by changing the previous node's `next`.

**Time:** O(n)

**Space:** O(1)

**MUST MASTER**

---

## Edge Cases

- Empty list
- Single-node list
- Two-node list
- Odd number of nodes
- Even number of nodes

---

## Goal

Master finding and deleting the middle node using the Fast & Slow Pointers pattern.

---