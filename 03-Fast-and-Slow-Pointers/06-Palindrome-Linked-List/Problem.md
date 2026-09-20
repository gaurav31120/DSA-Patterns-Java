# P006 — Palindrome Linked List

**LeetCode:** #234  
**Pattern:** Fast & Slow Pointers  
**Difficulty:** Medium

---

## Problem

Given the head of a singly linked list, return `true` if the linked list is a palindrome or `false` otherwise.

A palindrome is a sequence that reads the same forward and backward.

---

## Example 1

### Input

    head = [1,2,2,1]

### Output

    true

---

## Example 2

### Input

    head = [1,2]

### Output

    false

---

## Example 3

### Input

    head = [1]

### Output

    true

---

## Understanding the Problem

A linked list is a palindrome when its values are the same from both directions.

For example:

    [1,2,2,1]

Forward:

    1 → 2 → 2 → 1

Backward:

    1 → 2 → 2 → 1

Therefore:

    true

But:

    [1,2,3]

Forward:

    1 → 2 → 3

Backward:

    3 → 2 → 1

Therefore:

    false

---

## Important Requirements

- The input is a singly linked list.
- Return `true` if the list is a palindrome.
- Return `false` otherwise.
- The optimal approach should use constant extra space.

---

## Key Observation

To check whether a linked list is a palindrome, we need to compare:

    First half ↔ Second half in reverse order

The challenge is:

> How can we find the middle of the linked list and access the second half efficiently?

This is where the **Fast & Slow Pointers** pattern becomes useful.

---

## Goal

Try to achieve:

    Time Complexity: O(n)
    Space Complexity: O(1)

---

## Approaches

We have **3 meaningful approaches**:

### Approach 01 — ArrayList

- Time: **O(n)**
- Space: **O(n)**
- **OPTIONAL**

### Approach 02 — Stack

- Time: **O(n)**
- Space: **O(n)**
- **OPTIONAL**

### Approach 03 — Fast & Slow + Reverse Second Half

- Time: **O(n)**
- Space: **O(1)**
- **MUST MASTER 🔥**

---

## What You Should Learn

This problem reinforces:

- Fast & Slow Pointers
- Finding the middle of a linked list
- Reversing a linked list
- Comparing two halves
- In-place linked list manipulation
- O(1) extra space