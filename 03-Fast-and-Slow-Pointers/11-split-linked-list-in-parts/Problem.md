# P011 — Split Linked List in Parts

## Problem

**LeetCode #725 — Split Linked List in Parts**

**Pattern:** Fast & Slow Pointers

**Difficulty:** Medium

---

## Description

Given the head of a singly linked list and an integer `k`, split the linked list into `k` consecutive linked-list parts.

The length of each part should be as equal as possible.

The parts should satisfy:

1. The parts must appear in the same order as the original linked list.
2. The size of any two parts should differ by at most `1`.
3. Earlier parts should have the extra nodes when the list cannot be divided equally.
4. If there are fewer than `k` nodes, the remaining parts should be `null`.

Return an array containing the `k` linked-list parts.

---

## Example

Input:

    List:
    1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10

    k = 3

Output:

    [1 -> 2 -> 3 -> 4]
    [5 -> 6 -> 7]
    [8 -> 9 -> 10]

The sizes are:

    4, 3, 3

---

## Example 2

Input:

    List:
    1 -> 2 -> 3 -> 4
    k = 5

Output:

    [1]
    [2]
    [3]
    [4]
    null

---

## Approaches

### Approach 01 — ArrayList

Store all nodes in an `ArrayList`, calculate the required part sizes, and build the parts.

**Time:** O(n)

**Space:** O(n)

---

### Approach 02 — Length & Traversal

First calculate the total length.

Then calculate:

    partSize = n / k
    extra = n % k

The first `extra` parts contain:

    partSize + 1

nodes.

The remaining parts contain:

    partSize

nodes.

**Time:** O(n + k)

**Space:** O(k) for the returned array

**MUST MASTER**

---

## Edge Cases

- `head == null`
- `k == 1`
- `k > length`
- `length % k == 0`
- `length % k != 0`
- `k` is much larger than the list length

---

## Goal

Master how to divide a linked list into consecutive parts while keeping the part sizes as balanced as possible.

---

