# P005 — Happy Number

## Pattern

Fast & Slow Pointers

## Difficulty

Easy

## LeetCode

**#202 — Happy Number**

## Problem

Write an algorithm to determine if a number `n` is happy.

A happy number is a number defined by the following process:

1. Start with any positive integer.
2. Replace the number by the sum of the squares of its digits.
3. Repeat the process until the number becomes `1` or enters a cycle
   that does not include `1`.

If the process ends in `1`, the number is a happy number.

Return `true` if `n` is a happy number, otherwise return `false`.

## Example 1

### Input

    n = 19

### Process

    19 → 1² + 9²
       → 82
       → 8² + 2²
       → 68
       → 6² + 8²
       → 100
       → 1² + 0² + 0²
       → 1

### Output

    true

### Explanation

The process reaches `1`, so `19` is a happy number.

## Example 2

### Input

    n = 2

### Process

    2 → 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4 → ...

### Output

    false

### Explanation

The process enters a cycle and never reaches `1`.

## Constraints

- `1 <= n <= 2³¹ - 1`

## Requirements

- Return `true` if `n` is a happy number.
- Return `false` if the process enters a cycle.
- Target O(1) extra space for the optimal solution.

## Key Learning

The sequence of numbers can be treated like a linked list.

For every number:

    next = sum of squares of its digits

For example:

    19 → 82 → 68 → 100 → 1

If the number is not happy, the sequence eventually enters a cycle.

Therefore, Fast & Slow Pointers can be used to detect the cycle.

## Main Idea

There are two possible outcomes:

### Happy Number

The sequence reaches:

    1

Return `true`.

### Unhappy Number

The sequence enters a cycle.

Fast & Slow Pointers can detect this cycle.

Return `false`.

## Important Function

You need a helper function that calculates the sum of squares of digits.

For example:

    19 → 1² + 9² → 82

Think about how to extract each digit using:

    n % 10

and remove the last digit using:

    n / 10