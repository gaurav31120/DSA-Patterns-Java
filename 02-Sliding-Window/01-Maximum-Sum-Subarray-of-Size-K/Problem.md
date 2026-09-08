# Maximum Sum Subarray of Size K

## Problem Statement

Given an array of positive numbers and a positive number `K`, find the maximum sum of any contiguous subarray of size `K`.

Return the maximum sum.

## Example

### Input

arr = [2, 1, 5, 1, 3, 2]
K = 3

### Output

9

### Explanation

The subarrays of size 3 are:

- [2, 1, 5] → 8
- [1, 5, 1] → 7
- [5, 1, 3] → 9
- [1, 3, 2] → 6

Maximum sum = `9`

## Another Example

### Input

arr = [2, 3, 4, 1, 5]
K = 2

### Output

7

### Explanation

The subarrays of size 2 are:

- [2, 3] → 5
- [3, 4] → 7
- [4, 1] → 5
- [1, 5] → 6

Maximum sum = `7`

## Approaches

| # | Approach | Time | Space | Status |
|---|---|---|---|---|
| 01 | Brute Force | O(n × k) | O(1) | 🟡 OPTIONAL |
| 02 | Sliding Window | O(n) | O(1) | 🟢 MUST MASTER |

## Key Learning

The important idea is to avoid recalculating the entire sum for every subarray.

Instead, maintain a window of size `K`:

1. Add the new element entering the window.
2. Remove the element leaving the window.
3. Track the maximum sum.

This reduces the time complexity from `O(n × k)` to `O(n)`.