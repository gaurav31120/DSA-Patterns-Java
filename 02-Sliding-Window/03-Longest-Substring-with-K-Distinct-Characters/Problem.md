# P003 — Longest Substring with K Distinct Characters

## Pattern

Sliding Window

## Difficulty

Medium

## LeetCode

No exact LeetCode problem number for the original Pratyush/Grokking problem.

## Problem

Given a string and a positive integer `K`, find the length of the longest
substring that contains no more than `K` distinct characters.

Return `0` if the string is empty or `K` is `0`.

## Example 1

### Input

    str = "araaci"
    K = 2

### Output

    4

### Explanation

The longest substring with at most `2` distinct characters is:

    "araa"

Length = `4`

## Example 2

### Input

    str = "araaci"
    K = 1

### Output

    2

### Explanation

The longest substring with at most `1` distinct character is:

    "aa"

Length = `2`

## Example 3

### Input

    str = "cbbebi"
    K = 3

### Output

    5

### Explanation

The longest substring with at most `3` distinct characters is:

    "cbbeb"

Length = `5`

## Example 4

### Input

    str = "abc"
    K = 5

### Output

    3

### Explanation

The whole string contains only `3` distinct characters, which is
within the limit of `5`.

## Constraints

- `1 <= str.length <= 10^5`
- `0 <= K <= str.length`
- The string contains lowercase English letters.

## Requirements

- The substring must be contiguous.
- The substring can contain at most `K` distinct characters.
- Return the maximum length.
- Target O(n) time for the optimal solution.

## Key Learning

This is a variable-size Sliding Window problem.

Expand the window using the `right` pointer.

Keep track of the frequency of characters inside the window.

If the number of distinct characters becomes greater than `K`,
shrink the window from the left until it becomes valid again.

Then update the maximum window length.

## Main Idea

    Expand window
         ↓
    Add character
         ↓
    Distinct characters > K?
         ↓
       YES
         ↓
    Shrink from left
         ↓
    Window becomes valid
         ↓
    Update maximum length

## Important Formula

Current window length:

    right - left + 1