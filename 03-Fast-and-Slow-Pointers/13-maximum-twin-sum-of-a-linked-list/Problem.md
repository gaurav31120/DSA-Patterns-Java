# P013 — Maximum Twin Sum of a Linked List

## Problem

**LeetCode #2130 — Maximum Twin Sum of a Linked List**

**Pattern:** Fast & Slow Pointers

**Difficulty:** Medium

---

## Description

You are given the head of a linked list with an even number of nodes.

For a linked list of length `n`:

- Node `0` is the twin of node `n - 1`.
- Node `1` is the twin of node `n - 2`.
- Node `2` is the twin of node `n - 3`.
- And so on.

The twin sum is:

    current node value + twin node value

Return the maximum twin sum.

---

## Example 1

Input:

    5 -> 4 -> 2 -> 1

Twin pairs:

    5 + 1 = 6
    4 + 2 = 6

Output:

    6

---

## Example 2

Input:

    4 -> 2 -> 2 -> 3

Twin pairs:

    4 + 3 = 7
    2 + 2 = 4

Output:

    7

---

## Example 3

Input:

    1 -> 100000

Twin pair:

    1 + 100000 = 100001

Output:

    100001

---

## Approaches

### Approach 01 — ArrayList

Store all nodes or values in an `ArrayList`.

Use two indices:

    left = 0
    right = n - 1

Calculate the twin sums by moving `left` forward and `right` backward.

**Time:** O(n)

**Space:** O(n)

---

### Approach 02 — Fast & Slow + Reverse Second Half

Use `slow` and `fast` to find the middle of the linked list.

Reverse the second half.

Then use two pointers:

- one from the beginning
- one from the reversed second half

Calculate each twin sum and keep the maximum.

**Time:** O(n)

**Space:** O(1)

**MUST MASTER**

---

## Edge Cases

- Exactly 2 nodes
- All node values are equal
- Maximum values
- Maximum twin pair occurs at the beginning
- Maximum twin pair occurs near the end

---

## Goal

Master how to combine:

    Fast & Slow Pointers
    +
    Reverse Linked List
    +
    Two Pointer comparison

to solve a linked-list pairing problem in O(1) auxiliary space.

---

