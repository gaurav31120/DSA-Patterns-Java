# P005 — Triplets Sum Closest to Target

## Pattern

Two Pointers

## Difficulty

Medium

## Problem

Given an integer array `arr` and an integer `target`, find three
integers in `arr` such that their sum is closest to `target`.

Return the sum of the three integers.

You may assume that there is exactly one solution.

## Example 1

Input:

arr = [-1, 2, 1, -4]
target = 1

Output:

2

Explanation:

The triplet `[-1, 2, 1]` has a sum of `2`, which is closest to
the target `1`.

## Example 2

Input:

arr = [0, 0, 0]
target = 1

Output:

0

## Constraints

- `3 <= arr.length <= 500`
- `-1000 <= arr[i] <= 1000`
- `-10^4 <= target <= 10^4`
- Exactly one closest sum exists.

## Follow-up

Can you solve the problem in O(n²) time?

## Key Learning

This problem is a variation of 3Sum.

Instead of:

`sum == target`

we need to track:

`closest sum to target`

The important idea is to maintain the best answer found so far.