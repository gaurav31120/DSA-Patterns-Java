# P004 — Find the Duplicate Number

## Pattern

Fast & Slow Pointers

## Difficulty

Medium

## LeetCode

**#287 — Find the Duplicate Number**

## Problem

Given an array of integers `nums` containing `n + 1` integers where each
integer is in the range `[1, n]`.

There is only one repeated number, but it may be repeated more than once.

Return the duplicate number.

You must solve the problem without modifying the array and using only
constant extra space.

## Example 1

### Input

    nums = [1,3,4,2,2]

### Output

    2

### Explanation

The duplicate number is `2`.

## Example 2

### Input

    nums = [3,1,3,4,2]

### Output

    3

### Explanation

The duplicate number is `3`.

## Example 3

### Input

    nums = [3,3,3,3,3]

### Output

    3

### Explanation

The duplicate number is `3`.

## Constraints

- `1 <= n <= 10⁵`
- `nums.length == n + 1`
- `1 <= nums[i] <= n`
- Only one number is repeated.
- The duplicate number may appear more than once.

## Requirements

- Do not modify the array.
- Use O(1) extra space for the optimal solution.
- Target O(n) time.

## Key Learning

The important trick is to treat the array like a linked list.

For each index `i`, consider:

    next = nums[i]

This creates a sequence of indices.

Since there are `n + 1` numbers but only `n` possible values,
a cycle must exist.

The duplicate number is connected to the cycle.

The optimal solution uses Floyd's Fast & Slow Pointers to find the cycle
and then locate its starting point.

## Main Idea

There are two phases in the optimal solution.

### Phase 1 — Detect the Cycle

- `slow` moves one step.
- `fast` moves two steps.
- They eventually meet inside the cycle.

### Phase 2 — Find the Duplicate

- Reset `slow` to the beginning.
- Move both pointers one step at a time.
- The point where they meet is the duplicate number.