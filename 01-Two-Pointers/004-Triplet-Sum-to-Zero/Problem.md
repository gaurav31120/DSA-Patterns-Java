# P004 — Triplet Sum to Zero

## Pattern
Two Pointers

## Difficulty
Medium

## Problem

Given an array of integers, find all unique triplets in the array
that add up to zero.

Return all unique triplets.

A triplet consists of three different elements from the array.

The order of the triplets does not matter, and the elements inside
each triplet should be in non-decreasing order.

## Examples

### Example 1

Input:

[-1, 0, 1, 2, -1, -4]

Output:

[
    [-1, -1, 2],
    [-1, 0, 1]
]

### Example 2

Input:

[0, 1, 1]

Output:

[]

### Example 3

Input:

[0, 0, 0]

Output:

[
    [0, 0, 0]
]

## Constraints

- 3 <= nums.length <= 3000
- -10^5 <= nums[i] <= 10^5

## Important Requirements

- Return only unique triplets.
- The same triplet should not appear more than once.
- The three elements must come from different indices.

## Follow-up

Can you solve the problem in O(n²) time?