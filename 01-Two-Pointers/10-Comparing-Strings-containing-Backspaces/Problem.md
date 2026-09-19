# P010 — Comparing Strings containing Backspaces

## Pattern

Two Pointers

## Difficulty

Easy

## LeetCode

**#844 — Backspace String Compare**

## Problem Statement

Given two strings `s` and `t`, return `true` if they are equal after
processing all backspace characters.

The character `#` represents a backspace.

A backspace removes the character immediately before it. If there is
no character before it, the backspace does nothing.

## Example 1

### Input

    s = "ab#c"
    t = "ad#c"

### Output

    true

### Explanation

Both strings become:

    "ac"

Therefore, they are equal.

## Example 2

### Input

    s = "ab##"
    t = "c#d#"

### Output

    true

### Explanation

Both strings become:

    ""

## Example 3

### Input

    s = "a#c"
    t = "b"

### Output

    false

### Explanation

After processing backspaces:

    s = "c"
    t = "b"

Therefore, the strings are not equal.

## Constraints

- `1 <= s.length, t.length <= 200`
- `s` and `t` contain only lowercase English letters and `#`.

## Requirements

- Process all backspace characters correctly.
- Return `true` when the final strings are equal.
- Return `false` otherwise.
- The optimal approach should use O(n) time.
- The optimal approach should use O(1) extra space.

## Key Observation

A backspace affects the character immediately before it.

Instead of physically building the final strings, we can process both
strings from right to left.

When we see `#`, we know that the next valid character to the left
must be skipped.

## Main Idea

    Start from the end
          ↓
    See '#'
          ↓
    Increase skip count
          ↓
    See a normal character
          ↓
    Skip it if skip count > 0
          ↓
    Otherwise compare it