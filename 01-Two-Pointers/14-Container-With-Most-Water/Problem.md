# P014 — Container With Most Water

## Pattern

Two Pointers

## Difficulty

Medium

## LeetCode

**#11 — Container With Most Water**

## Problem Statement

You are given an integer array `height`.

There are `n` vertical lines where the endpoints of the `i-th` line are
`(i, 0)` and `(i, height[i])`.

Choose two lines that, together with the x-axis, form a container that
holds the most water.

Return the maximum amount of water the container can store.

## Example 1

### Input

    height = [1, 8, 6, 2, 5, 4, 8, 3, 7]

### Output

    49

### Explanation

Choose the lines at indices `1` and `8`.

The width is:

    8 - 1 = 7

The height of the container is:

    min(8, 7) = 7

Area:

    7 × 7 = 49

## Example 2

### Input

    height = [1, 1]

### Output

    1

## Constraints

- `2 <= height.length <= 10^5`
- `0 <= height[i] <= 10^4`

## Requirements

- Choose two different lines.
- Maximize the area of water that can be contained.
- Target O(n) time for the optimal solution.
- Target O(1) extra space for the optimal solution.

## Key Observation

The area between two lines is:

    width × minimum height

For pointers `left` and `right`:

    area = (right - left) × min(height[left], height[right])

Start with the widest possible container.

If the left line is shorter, moving `right` inward cannot improve the
area because the width decreases while the limiting height remains the
left height.

Therefore, move the pointer pointing to the shorter line.

## Pointer Movement

    left →              ← right

If:

    height[left] < height[right]

then:

    left++

Otherwise:

    right--

After every move, calculate the new area and update the maximum.

## Main Idea

    Start with left = 0
    Start with right = n - 1
            ↓
    Calculate area
            ↓
    Update maximum
            ↓
    Move the pointer at the shorter line
            ↓
    Repeat until left >= right

## Why Two Pointers Work

Starting with both ends gives the maximum possible width.

When moving inward, the width always decreases.

Therefore, to have any chance of finding a larger area, we must try to
increase the limiting height by moving the pointer at the shorter line.

## Learning Goal

Understand how two pointers can reduce a pair-search problem from
O(n²) to O(n) by eliminating impossible pairs based on a mathematical
observation.