# P002 — Smallest Subarray with a Given Sum

## Pattern

Sliding Window

## Difficulty

Easy

## Problem

Given an array of positive numbers and a positive number `S`, find the
length of the smallest contiguous subarray whose sum is greater than
or equal to `S`.

Return `0` if no such subarray exists.

## Example 1

### Input

    S = 7
    arr = [2, 1, 5, 2, 3, 2]

### Output

    2

### Explanation

The smallest subarray with a sum greater than or equal to `7` is:

    [5, 2]

Sum = `7`

Length = `2`

## Example 2

### Input

    S = 8
    arr = [3, 4, 1, 1, 6]

### Output

    3

### Explanation

The smallest valid subarray is:

    [3, 4, 1]

Sum = `8`

Length = `3`

## Example 3

### Input

    S = 15
    arr = [1, 2, 3, 4, 5]

### Output

    0

### Explanation

No contiguous subarray has a sum greater than or equal to `15`.

## Constraints

- `1 <= arr.length <= 10^5`
- `1 <= arr[i] <= 10^4`
- `1 <= S <= 10^9`

## Requirements

- The subarray must be contiguous.
- Find the minimum possible length.
- Return `0` if no valid subarray exists.
- Use O(1) extra space for the optimal solution.

## Key Learning

Because all numbers are positive, increasing the right pointer always
increases or keeps the window sum.

When the sum becomes greater than or equal to `S`, shrink the window
from the left as much as possible while keeping the sum valid.

This allows us to find the smallest valid window in O(n) time.