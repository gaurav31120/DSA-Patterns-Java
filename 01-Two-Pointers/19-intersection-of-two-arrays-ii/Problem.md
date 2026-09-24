# P019 — Intersection of Two Arrays II

## Problem

**LeetCode #350 — Intersection of Two Arrays II**

**Pattern:** Two Pointers

**Difficulty:** Easy

---

## Description

Given two integer arrays `arr1` and `arr2`, return their intersection.

Each element in the result must appear as many times as it shows in both arrays.

The result can be returned in any order.

---

## Example 1

Input:

    arr1 = [1, 2, 2, 1]
    arr2 = [2, 2]

Output:

    [2, 2]

---

## Example 2

Input:

    arr1 = [4, 9, 5]
    arr2 = [9, 4, 9, 8, 4]

Output:

    [4, 9]

or:

    [9, 4]

---

## Important Point

This is an intersection with **duplicates**.

Example:

    arr1 = [1, 2, 2, 3]
    arr2 = [2, 2, 2]

Result:

    [2, 2]

Only two `2`s are present in `arr1`, so only two can appear in the result.

---

## Approaches

### Approach 01 — HashMap / Frequency Counting

Store the frequency of each value from one array.

Traverse the second array.

If a value has a remaining frequency, add it to the result and decrease its frequency.

**Time:** O(m + n)

**Space:** O(min(m, n))

---

### Approach 02 — Sort + Two Pointers

Sort both arrays.

Use two pointers to scan them from left to right.

- Equal values -> add to result and move both.
- Smaller value -> move the pointer of the smaller value.
- Larger value -> move the other pointer.

**Time:** O(m log m + n log n)

**Space:** O(1) auxiliary, excluding the output/result storage

**MUST MASTER**

---

## Edge Cases

- One array is empty
- No common elements
- All elements are common
- Duplicate values
- Different array lengths
- Arrays contain negative values

---

## Goal

Master handling duplicates using either frequency counting or sorting with two pointers.

---

## Status

⏳ In Progress