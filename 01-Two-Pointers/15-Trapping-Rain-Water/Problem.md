# P015 — Trapping Rain Water

## Pattern

Two Pointers

## Difficulty

Hard

## LeetCode

**#42 — Trapping Rain Water**

## Problem Statement

Given an array `height` representing an elevation map where the width of
each bar is `1`, calculate how much water can be trapped after raining.

## Example 1

### Input

    height = [0,1,0,2,1,0,1,3,2,1,2,1]

### Output

    6

### Explanation

The elevation map traps a total of `6` units of water.

## Example 2

### Input

    height = [4,2,0,3,2,5]

### Output

    9

## Constraints

- `1 <= height.length <= 2 * 10^4`
- `0 <= height[i] <= 10^5`

## Requirements

- Calculate the total trapped water.
- Each bar has width `1`.
- Target O(n) time for the optimal approach.
- Target O(1) extra space for the optimal approach.

## Key Observation

Water trapped above an index depends on the tallest boundary on both
sides.

For index `i`:

    water[i] = min(leftMax, rightMax) - height[i]

If the left boundary is smaller, the trapped water is limited by the
left side.

This allows a two-pointer solution without storing separate leftMax
and rightMax arrays.

## Two Pointer Idea

Use:

    left = 0
    right = n - 1

Maintain:

    leftMax
    rightMax

At each step, process the side with the smaller boundary.

If:

    height[left] <= height[right]

the left side determines the limiting height.

Otherwise, process the right side.

## Main Idea

    left →                 ← right
    [elevation map]

    Maintain leftMax and rightMax

    Smaller boundary
          ↓
    Process that side
          ↓
    Calculate trapped water
          ↓
    Move pointer inward

## Learning Goal

Understand how the Two Pointers technique can solve a problem that
initially appears to require extra left-max and right-max arrays.