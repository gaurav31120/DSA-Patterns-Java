# P016 — Remove Element

**LeetCode:** #27  
**Pattern:** Two Pointers  
**Difficulty:** Easy

---

## Problem

Given an integer array `arr` and an integer `val`, remove all occurrences of `val` **in-place**.

The order of the remaining elements may be changed.

Return the number of elements `k` in `arr` that are not equal to `val`.

The first `k` elements of `arr` must contain the elements that are not equal to `val`.

The elements beyond the first `k` positions do not matter.

---

## Example 1

### Input

    arr = [3,2,2,3]
    val = 3

### Output

    k = 2

### Modified Array

    [2,2,_,_]

The first `2` elements are:

    [2,2]

---

## Example 2

### Input

    arr = [0,1,2,2,3,0,4,2]
    val = 2

### Output

    k = 5

### Modified Array

    [0,1,3,0,4,_,_,_]

The first `5` elements are:

    [0,1,3,0,4]

---

## Understanding the Problem

We need to remove every occurrence of `val`.

For example:

    arr = [3,2,2,3]
    val = 3

The elements equal to `3` must be removed.

Remaining elements:

    [2,2]

So we return:

    2

The important point is that the operation must be performed **in-place**.

---

## Important Requirements

- Modify the original array.
- Remove all occurrences of `val`.
- Return the number `k` of elements that are not equal to `val`.
- The first `k` elements must contain the valid elements.
- Elements after index `k - 1` do not matter.
- The order of the remaining elements may be changed.

---

## Key Observation

Every element belongs to one of two groups:

    arr[i] == val
    → Remove

    arr[i] != val
    → Keep

The main question is:

> Where should the next valid element be placed?

This makes the problem a good fit for the **Two Pointers** pattern.

---

## Goal

Try to achieve:

    Time Complexity: O(n)
    Space Complexity: O(1)

---

## Approaches

We have **3 meaningful approaches**:

### Approach 01 — Nested Loops / Shifting

- Time: **O(n²)**
- Space: **O(1)**
- **OPTIONAL**

### Approach 02 — Extra Array

- Time: **O(n)**
- Space: **O(n)**
- **OPTIONAL**

### Approach 03 — Two Pointers / Overwrite

- Time: **O(n)**
- Space: **O(1)**
- **MUST MASTER 🔥**

---

## What You Should Learn

This problem reinforces:

- Two Pointers
- In-place array modification
- Array traversal
- Overwriting elements
- Write pointer
- O(1) extra space