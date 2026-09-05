# P006 — Triplets with Smaller Sum

## Pattern

Two Pointers

## Difficulty

Medium

## Problem

Given an integer array `arr` and an integer `target`, find the
number of triplets in the array whose sum is strictly smaller
than the given target.

Return the count of such triplets.

A triplet consists of three different elements from the array.

The order of the elements does not matter.

## Example 1

Input:

arr = [-2, 0, 1, 3]
target = 2

Output:

2

Explanation:

The two triplets whose sum is smaller than `2` are:

[-2, 0, 1] → -1
[-2, 0, 3] → 1

## Example 2

Input:

arr = [-1, 4, 2, 1, 3]
target = 5

Output:

4

## Example 3

Input:

arr = [0, 0, 0, 0]
target = 1

Output:

4

Explanation:

Every combination of three elements has sum `0`, which is
smaller than `1`.

## Constraints

- `3 <= arr.length <= 350`
- `-100 <= arr[i] <= 100`
- `-1000 <= target <= 1000`

## Follow-up

Can you solve the problem in O(n²) time?

## Key Learning

This problem is a variation of 3Sum.

Instead of finding:

`sum == target`

or:

`closest sum to target`

we need to:

`count all triplets where sum < target`

The important Two Pointers insight is that when the array is sorted
and a particular pair satisfies the condition, multiple triplets
can be counted at once.