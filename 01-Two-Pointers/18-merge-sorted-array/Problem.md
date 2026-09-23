# P018 — Merge Sorted Array

## Problem

**LeetCode #88 — Merge Sorted Array**

**Pattern:** Two Pointers

**Difficulty:** Easy

---

## Description

You are given two integer arrays:

    nums1
    nums2

`nums1` has enough space to hold all elements from both arrays.

The first `m` elements of `nums1` contain valid values.

The first `n` elements of `nums2` contain valid values.

Merge the two sorted arrays into `nums1` in non-decreasing order.

The merge must be done in-place.

---

## Example

Input:

    nums1 = [1,2,3,0,0,0]
    m = 3

    nums2 = [2,5,6]
    n = 3

Output:

    [1,2,2,3,5,6]

---

## Example 2

Input:

    nums1 = [1]
    m = 1

    nums2 = []
    n = 0

Output:

    [1]

---

## Example 3

Input:

    nums1 = [0]
    m = 0

    nums2 = [1]
    n = 1

Output:

    [1]

---

## Important Point

Only the first `m` elements of `nums1` are valid initially.

The remaining `n` positions contain extra space for the elements of `nums2`.

Example:

    nums1 = [1,2,3,0,0,0]
                  ↑
              empty space

---

## Approaches

### Approach 01 — Extra Array

Create another array and merge the two sorted portions into it.

Then copy the result back into `nums1`.

**Time:** O(m + n)

**Space:** O(m + n)

---

### Approach 02 — Backward Two Pointers

Start from the end of both valid portions.

Compare the largest elements and place the larger one at the end of `nums1`.

Work backwards so that existing values in `nums1` are not overwritten.

**Time:** O(m + n)

**Space:** O(1)

**MUST MASTER**

---

## Edge Cases

- `m = 0`
- `n = 0`
- One array is empty
- All elements of `nums1` are smaller
- All elements of `nums2` are smaller
- Duplicate values
- Arrays of different lengths

---

## Goal

Master the backward two-pointer technique for modifying a sorted array in-place without overwriting useful elements.

---

## Status

⏳ In Progress