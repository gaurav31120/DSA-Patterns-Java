# P009 — Quadruple Sum to Target

## Pattern

Two Pointers

## Difficulty

Medium

## LeetCode

**#18 — 4Sum**

## Problem Statement

Given an integer array `arr` and an integer `target`, return all unique
quadruplets `[arr[a], arr[b], arr[c], arr[d]]` such that:

    arr[a] + arr[b] + arr[c] + arr[d] == target

The four indices must be different.

The answer must not contain duplicate quadruplets.

The order of the returned quadruplets does not matter.

## Example 1

### Input

    arr = [1, 0, -1, 0, -2, 2]
    target = 0

### Output

    [[-2, -1, 1, 2],
     [-2, 0, 0, 2],
     [-1, 0, 0, 1]]

## Example 2

### Input

    arr = [2, 2, 2, 2, 2]
    target = 8

### Output

    [[2, 2, 2, 2]]

## Example 3

### Input

    arr = [1, 2, 3, 4]
    target = 100

### Output

    []

## Constraints

- `1 <= arr.length <= 200`
- `-10^9 <= arr[i] <= 10^9`
- `-10^9 <= target <= 10^9`

## Requirements

- Find all unique quadruplets.
- The four selected elements must come from different indices.
- Avoid duplicate quadruplets.
- Return an empty list if no quadruplet exists.

## Key Observation

This problem extends the same idea used in 3Sum.

Instead of fixing one number and using two pointers, we can fix two
numbers and use two pointers for the remaining two numbers.

After sorting the array:

    i → first number
    j → second number
    left → third number
    right → fourth number

Then:

    sum = arr[i] + arr[j] + arr[left] + arr[right]

If the sum is too small, move `left`.

If the sum is too large, move `right`.

If the sum equals the target, record the quadruplet and move both
pointers while skipping duplicates.

## Main Idea

    Sort the array
         ↓
    Fix i
         ↓
    Fix j
         ↓
    left = j + 1
    right = n - 1
         ↓
    Compare 4-number sum with target
         ↓
    Move left / right
         ↓
    Skip duplicates

## Learning Goal

Understand how a 4Sum problem can be reduced to a Two Sum problem after
fixing two elements.

The main interview skill is recognizing that sorting plus two pointers
can reduce the time complexity significantly compared with four nested
loops.