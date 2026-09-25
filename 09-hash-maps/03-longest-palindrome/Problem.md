# P003 — Longest Palindrome

**LeetCode:** #409
**Pattern:** Hash Maps
**Difficulty:** Easy

---

## Problem

Given a string `s` consisting of lowercase and uppercase English letters,
return the length of the longest palindrome that can be built with those letters.

Letters are case-sensitive.

Each character can be used at most once.

---

## Example 1

### Input

s = "abccccdd"

### Output

7

### Explanation

One longest palindrome that can be built is:

"dccaccd"

The length is 7.

---

## Example 2

### Input

s = "a"

### Output

1

---

## Example 3

### Input

s = "bb"

### Output

2

---

## Key Observation

A palindrome has matching characters on both sides.

For example:

"abba"

Here:

a → 2
b → 2

Both characters can be used completely.

If a character appears an odd number of times, we can use the largest even number from that frequency.

Examples:

1 → 0
2 → 2
3 → 2
4 → 4
5 → 4

After using all possible pairs, at most one remaining character can be placed in the center.

---

## Pattern Recognition

Think:

1. Count the frequency of every character.
2. Use the maximum possible even number from each frequency.
3. If any character has an odd frequency, add `1` for the center.

---

## Approaches

### Approach 01

Frequency Map using HashMap

### Approach 02

Count Array

---

## Complexity Targets

### Approach 01

- Time: O(n)
- Space: O(k)

### Approach 02

- Time: O(n)
- Space: O(1)