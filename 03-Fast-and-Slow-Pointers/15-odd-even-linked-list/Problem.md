# P015 — Odd Even Linked List

## Problem

**LeetCode #328 — Odd Even Linked List**

**Pattern:** Fast & Slow Pointers

**Difficulty:** Medium

---

## Description

Given the head of a singly linked list, group all nodes at odd positions together followed by all nodes at even positions.

The first node is considered to be at an odd position.

The second node is considered to be at an even position.

The relative order inside both the odd-position group and the even-position group must remain the same as in the original list.

---

## Important Clarification

This problem is based on the **position of the nodes**, not the value stored in the nodes.

For:

    1 -> 2 -> 3 -> 4 -> 5

Positions are:

    1 -> odd
    2 -> even
    3 -> odd
    4 -> even
    5 -> odd

So the result is:

    1 -> 3 -> 5 -> 2 -> 4

---

## Example 1

Input:

    1 -> 2 -> 3 -> 4 -> 5

Output:

    1 -> 3 -> 5 -> 2 -> 4

---

## Example 2

Input:

    2 -> 1 -> 3 -> 5 -> 6 -> 4 -> 7

Output:

    2 -> 3 -> 6 -> 7 -> 1 -> 5 -> 4

---

## Approaches

### Approach 01 — Separate Odd and Even Chains

Create two chains:

    Odd-position chain
    Even-position chain

Traverse the original list and attach each node to its corresponding chain.

Finally connect the odd chain to the even chain.

**Time:** O(n)

**Space:** O(1) auxiliary pointers

---

### Approach 02 — In-Place Two Pointers

Maintain:

    odd
    even
    evenHead

Rewire the existing `next` pointers so that odd-position nodes form one chain and even-position nodes form another.

Finally connect the odd chain to the saved even head.

**Time:** O(n)

**Space:** O(1)

**MUST MASTER**

---

## Edge Cases

- Empty list
- One node
- Two nodes
- Odd number of nodes
- Even number of nodes

---

## Goal

Master rearranging linked-list nodes by position while preserving the relative order of both groups.

---

## Status

⏳ In Progress