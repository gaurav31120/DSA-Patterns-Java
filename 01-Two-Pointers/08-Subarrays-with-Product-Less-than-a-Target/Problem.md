# P008 — Subarrays with Product Less than a Target

## Pattern

Two Pointers

## Difficulty

Medium

## LeetCode

**#713 — Subarray Product Less Than K**

## Problem Statement

Given an array of positive integers `arr` and a positive integer
`target`, find the number of contiguous subarrays where the product
of all the elements is strictly less than `target`.

Return the total number of valid contiguous subarrays.

## Example 1

### Input

    arr = [10, 5, 2, 6]
    target = 100

### Output

    8

### Explanation

The valid subarrays are:

    [10]
    [5]
    [2]
    [6]
    [10, 5]
    [5, 2]
    [2, 6]
    [5, 2, 6]

Total = `8`

## Example 2

### Input

    arr = [1, 2, 3]
    target = 0

### Output

    0

### Explanation

No subarray can have a product strictly less than `0`.

## Example 3

### Input

    arr = [1, 1, 1]
    target = 2

### Output

    6

### Explanation

Every non-empty contiguous subarray has product `1`, which is
strictly less than `2`.

There are 6 such subarrays:

    [1]
    [1]
    [1]
    [1, 1]
    [1, 1]
    [1, 1, 1]

## Constraints

- `1 <= arr.length <= 3 * 10^4`
- `1 <= arr[i] <= 1000`
- `0 <= target <= 10^6`

## Requirements

- The subarray must be contiguous.
- Count all valid subarrays.
- The product must be strictly less than `target`.
- The optimal solution should use O(n) time.
- The optimal solution should use O(1) extra space.

## Key Observation

All elements in the array are positive.

Therefore:

- Expanding the window increases or keeps the product the same.
- Shrinking the window decreases or keeps the product the same.

When the product becomes greater than or equal to `target`, shrink the
window from the left until the product becomes valid again.

## Important Formula

If the current valid window is:

    [left ... right]

then the number of valid subarrays ending at `right` is:

    right - left + 1

## Why the Formula Works

Suppose the current valid window is:

    [left ... right]

Then all of these subarrays are valid:

    [right]
    [right - 1 ... right]
    [right - 2 ... right]
    ...
    [left ... right]

Therefore, the number of valid subarrays ending at `right` is:

    right - left + 1

## Main Idea

    Expand right
        ↓
    Multiply arr[right]
        ↓
    product >= target?
        ↓
       YES
        ↓
    Shrink from left
        ↓
    product < target
        ↓
    Add (right - left + 1)
        ↓
    Move right forward

## Example Dry Run

For:

    arr = [10, 5, 2, 6]
    target = 100

Start:

    left = 0
    product = 1

Add `10`:

    product = 10

Valid window:

    [10]

New subarrays = `1`

Add `5`:

    product = 50

Valid window:

    [10, 5]

New subarrays = `2`

Add `2`:

    product = 100

Product is not less than `100`, so shrink.

Remove `10`:

    product = 10
    left = 1

Valid window:

    [5, 2]

New subarrays = `2`

Add `6`:

    product = 60

Valid window:

    [5, 2, 6]

New subarrays = `3`

Total:

    1 + 2 + 2 + 3 = 8

## Approaches

### Approach 01 — Nested Loops

- Time: O(n²)
- Space: O(1)
- Status: OPTIONAL

### Approach 02 — Sliding Window / Two Pointers

- Time: O(n)
- Space: O(1)
- Status: MUST MASTER

## Learning Goal

Understand how the Two Pointers / Sliding Window technique can count
multiple valid subarrays at once instead of checking every subarray
individually.