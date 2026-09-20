# P017 — Is Subsequence

**LeetCode:** #392  
**Pattern:** Two Pointers  
**Difficulty:** Easy

---

## Problem

Given two strings `s` and `t`, return `true` if `s` is a subsequence of `t`, or `false` otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some or none of the characters without changing the relative order of the remaining characters.

For example:

    "abc" is a subsequence of "ahbgdc"

because we can find:

    a → b → c

in the same order.

However:

    "acb" is not a subsequence of "ahbgdc"

because `b` appears before `c` in `t`, while `s` requires `c` before `b`.

---

## Example 1

### Input

    s = "abc"
    t = "ahbgdc"

### Output

    true

---

## Example 2

### Input

    s = "axc"
    t = "ahbgdc"

### Output

    false

---

## Example 3

### Input

    s = ""
    t = "ahbgdc"

### Output

    true

An empty string is a subsequence of every string.

---

## Understanding the Problem

We need to check whether all characters of `s` can be found inside `t` while keeping their original order.

For example:

    s = "abc"
    t = "ahbgdc"

We can match:

    a
       b
             c

The extra characters in `t` can be skipped.

---

## Important Requirements

- Characters of `s` must appear in `t` in the same relative order.
- Characters from `t` may be skipped.
- We cannot rearrange characters.
- We only need to determine whether `s` is a subsequence of `t`.

---

## Key Observation

We only need to find each character of `s` in `t` from left to right.

Once a matching character is found, continue searching from the next position in `t`.

For example:

    s = "ace"
    t = "abcde"

Matching:

    a → c → e

Therefore:

    true

---

## Goal

Try to achieve:

    Time Complexity: O(n + m)
    Space Complexity: O(1)

where:

- `n` = length of `s`
- `m` = length of `t`

---

## Approaches

We have **2 meaningful approaches**:

### Approach 01 — Nested Loops / Searching Forward

- Time: **O(n × m)**
- Space: **O(1)**
- **OPTIONAL**

### Approach 02 — Two Pointers

- Time: **O(n + m)**
- Space: **O(1)**
- **MUST MASTER 🔥**

---

## What You Should Learn

This problem reinforces:

- Two Pointers
- String traversal
- Relative ordering
- Forward-only searching
- Subsequence checking  