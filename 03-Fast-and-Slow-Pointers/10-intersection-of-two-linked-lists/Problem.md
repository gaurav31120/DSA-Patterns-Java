# P010 — Intersection of Two Linked Lists

## Problem

**LeetCode #160 — Intersection of Two Linked Lists**

**Pattern:** Fast & Slow Pointers

**Difficulty:** Easy

---

## Description

Given the heads of two singly linked lists, `headA` and `headB`, return the node at which the two linked lists intersect.

If the two linked lists do not intersect, return `null`.

The linked lists must retain their original structure after the function returns.

---

## Example 1

    List A:       4 -> 1 \
                         8 -> 4 -> 5
    List B:   5 -> 6 -> 1 /

    Intersection node = 8

---

## Example 2

    List A:       1 -> 2 -> 3

    List B:       4 -> 5

    No intersection.

    Output: null

---

## Important Point

Intersection means the two lists share the **same node in memory**.

It does NOT mean that they simply have the same value.

For example:

    List A: 1 -> 2 -> 8 -> 10
                  \
    List B:     5 -> 8 -> 10

If the `8` nodes are different objects, there is no intersection.

---

## Approaches

### Approach 01 — ArrayList

Store the nodes of one linked list and check whether nodes from the second list are present.

**Time:** O(n + m)

**Space:** O(n)

---

### Approach 02 — Two Pointers

Use two pointers and switch each pointer to the other list when it reaches the end.

Eventually, both pointers either meet at the intersection node or both become `null`.

**Time:** O(n + m)

**Space:** O(1)

**MUST MASTER**

---

## Edge Cases

- One or both heads are `null`.
- The lists do not intersect.
- The intersection is at the head of one list.
- The intersection is at the last node.
- Both lists are the same linked list.
- The two lists have different lengths.

---

## Goal

Master the **two-pointer switching technique** for linked-list intersection.

---

## Status

⏳ In Progress