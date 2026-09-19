# P013 — Two Sum II - Input Array Is Sorted

## Pattern

Two Pointers

## Difficulty

Medium

## LeetCode

**#167 — Two Sum II - Input Array Is Sorted**

## Problem Statement

Given a **1-indexed** array of integers `numbers` that is sorted in
non-decreasing order, find two numbers such that they add up to a
given `target`.

Return the indices of the two numbers.

The indices must satisfy:

    1 <= index1 < index2 <= numbers.length

Exactly one solution exists.

## Example 1

### Input

    numbers = [2, 7, 11, 15]
    target = 9

### Output

    [1, 2]

### Explanation

    numbers[1] + numbers[2] = 2 + 7 = 9

The array is 1-indexed, so the answer is:

    [1, 2]

## Example 2

### Input

    numbers = [2, 3, 4]
    target = 6

### Output

    [1, 3]

### Explanation

    2 + 4 = 6

## Example 3

### Input

    numbers = [-1, 0]
    target = -1

### Output

    [1, 2]

## Constraints

- `2 <= numbers.length <= 3 * 10^4`
- `-1000 <= numbers[i] <= 1000`
- `-1000 <= target <= 1000`
- `numbers` is sorted in non-decreasing order.
- Exactly one solution exists.

## Requirements

- Return the indices using **1-based indexing**.
- The two indices must be different.
- Use the fact that the array is already sorted.
- Target O(n) time.
- Target O(1) extra space for the optimal approach.

## Key Observation

Because the array is sorted, we can use two pointers.

Start one pointer at the beginning and the other at the end:

    left  → beginning
    right → end

Calculate:

    sum = numbers[left] + numbers[right]

If the sum is smaller than the target, we need a larger value,
so move `left` forward.

If the sum is greater than the target, we need a smaller value,
so move `right` backward.

If the sum equals the target, we found the answer.

## Main Idea

    left →                 ← right
    [2, 3, 4, 7, 11, 15]

    sum < target  → left++
    sum > target  → right--
    sum == target → answer

## Why Two Pointers Work

The array is sorted.

Therefore:

- Moving `left` to the right increases the possible sum.
- Moving `right` to the left decreases the possible sum.

This lets us eliminate impossible pairs without checking every
combination.

## Learning Goal

Master the basic Two Pointers technique on a sorted array.

This problem is a variation of Two Sum and is important for recognizing
when sorting allows a brute-force pair search to be reduced to O(n).