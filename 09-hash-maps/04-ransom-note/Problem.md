# P004 — Ransom Note

**LeetCode:** #383
**Pattern:** Hash Maps
**Difficulty:** Easy

---

## Problem

Given two strings `ransomNote` and `magazine`, return `true` if `ransomNote`
can be constructed using the letters from `magazine`.

Each letter in `magazine` can be used only once.

Otherwise, return `false`.

---

## Example 1

### Input

ransomNote = "a"
magazine = "b"

### Output

false

---

## Example 2

### Input

ransomNote = "aa"
magazine = "ab"

### Output

false

---

## Example 3

### Input

ransomNote = "aa"
magazine = "aab"

### Output

true

---

## Key Observation

We need to check whether `magazine` contains enough occurrences of
every character required by `ransomNote`.

For example:

    ransomNote = "aa"

requires:

    a → 2

If:

    magazine = "aab"

then:

    a → 2

So the answer is `true`.

But if:

    magazine = "ab"

then:

    a → 1

So the answer is `false`.

---

## Pattern Recognition

Think:

    Count the available characters in magazine.

Then:

    Traverse ransomNote and consume one occurrence for every character.

If any required character is unavailable, return `false`.

---

## Approaches

### Approach 01

Frequency Map

### Approach 02

Count Array

---

## Complexity Targets

### Approach 01

- Time: O(n + m)
- Space: O(k)

### Approach 02

- Time: O(n + m)
- Space: O(1)