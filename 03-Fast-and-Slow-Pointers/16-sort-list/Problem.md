# P016 — Sort List

## Problem

**LeetCode #148 — Sort List**

**Pattern:** Fast & Slow Pointers

**Difficulty:** Medium

---

## Description

Given the head of a linked list, return the list after sorting it in ascending order.

The linked list should be sorted by rearranging the nodes.

---

## Example 1

Input:

    4 -> 2 -> 1 -> 3

Output:

    1 -> 2 -> 3 -> 4

---

## Example 2

Input:

    -1 -> 5 -> 3 -> 4 -> 0

Output:

    -1 -> 0 -> 3 -> 4 -> 5

---

## Example 3

Input:

    null

Output:

    null

---

## Approaches

### Approach 01 — ArrayList + Sorting

Store all node values in an `ArrayList`, sort the values, and write them back into the linked list.

**Time:** O(n log n)

**Space:** O(n)

---

### Approach 02 — Merge Sort + Fast & Slow Pointers

Use Fast & Slow Pointers to split the linked list into two halves.

Recursively sort both halves and merge the two sorted lists.

**Time:** O(n log n)

**Space:** O(log n) with recursion

**MUST MASTER**

---

## Follow-Up

Can the linked list be sorted in:

    O(n log n) time

and:

    O(1) memory?

---

## Important Point

For linked lists, Merge Sort is a natural fit because:

- The list can be divided efficiently using Fast & Slow Pointers.
- Two sorted linked lists can be merged by changing `next` pointers.
- No random access is required.

---

## Edge Cases

- Empty list
- One node
- Already sorted list
- Reverse sorted list
- Duplicate values
- Negative values

---

## Goal

Master how Fast & Slow Pointers can be combined with Merge Sort to sort a linked list efficiently.

---

## Status

⏳ In Progress