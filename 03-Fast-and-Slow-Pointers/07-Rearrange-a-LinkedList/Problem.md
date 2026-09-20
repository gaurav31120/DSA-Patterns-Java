# P007 — Rearrange a LinkedList

**LeetCode:** #143  
**Pattern:** Fast & Slow Pointers  
**Difficulty:** Medium

---

## Problem

Given the head of a singly linked list, reorder the list so that the nodes are arranged in the following order:

    L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → ...

You must perform the rearrangement **in-place**.

---

## Example 1

### Input

    head = [1,2,3,4]

### Output

    [1,4,2,3]

---

## Example 2

### Input

    head = [1,2,3,4,5]

### Output

    [1,5,2,4,3]

---

## Understanding the Problem

For:

    1 → 2 → 3 → 4

We need:

    1 → 4 → 2 → 3

For:

    1 → 2 → 3 → 4 → 5

We need:

    1 → 5 → 2 → 4 → 3

The rearrangement follows this order:

    First node
    Last node
    Second node
    Second-last node
    Third node
    ...

---

## Important Requirements

- Modify the linked list **in-place**.
- Do not create a new linked list.
- Use the existing nodes.
- The final order must follow:

    L0 → Ln → L1 → Ln-1 → L2 → ...

---

## Key Observation

A singly linked list allows easy traversal from the beginning, but finding the last node repeatedly is inefficient.

We can solve the problem by dividing the linked list into two parts:

    First half
    Second half

Then:

1. Find the middle of the linked list.
2. Reverse the second half.
3. Merge the first half and reversed second half alternately.

---

## Example

Original:

    1 → 2 → 3 → 4 → 5

### Step 1 — Find the Middle

    1 → 2 → 3

    4 → 5

### Step 2 — Reverse the Second Half

    1 → 2 → 3

    5 → 4

### Step 3 — Merge Alternately

    1 → 5 → 2 → 4 → 3

---

## Goal

Try to achieve:

    Time Complexity: O(n)
    Space Complexity: O(1)

---

## Approaches

We have **2 meaningful approaches**:

### Approach 01 — ArrayList

- Time: **O(n)**
- Space: **O(n)**
- **OPTIONAL**

### Approach 02 — Fast & Slow + Reverse + Merge

- Time: **O(n)**
- Space: **O(1)**
- **MUST MASTER 🔥**

---

## What You Should Learn

This problem reinforces:

- Fast & Slow Pointers
- Finding the middle of a linked list
- Reversing a linked list
- Merging linked lists
- In-place linked list manipulation
- O(1) extra space