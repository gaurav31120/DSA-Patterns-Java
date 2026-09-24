# P001 — First Non-repeating Character

**LeetCode:** #387  
**Pattern:** Hash Maps  
**Difficulty:** Easy

---

## Problem

Given a string `s`, find the first character that does not repeat.

Return its index.

If there is no non-repeating character, return `-1`.

---

## Example 1

### Input

s = "leetcode"

### Output

0

### Explanation

The character `l` appears only once and is the first non-repeating character.

---

## Example 2

### Input

s = "loveleetcode"

### Output

2

### Explanation

The first non-repeating character is `v`, which is at index `2`.

---

## Example 3

### Input

s = "aabb"

### Output

-1

### Explanation

Every character appears more than once.

---

## Key Requirement

We need the **first** character that appears exactly once.

For example:

s = "swiss"

Frequencies:

s → 3  
w → 1  
i → 1

The answer is index `1` because `w` is the first character with frequency `1`.

---

## Pattern Recognition

Think:

> I need to count how many times each character appears.

Then:

> I need to traverse the string again in the original order to find the first character whose frequency is `1`.

---

## Approaches

### Approach 01

Frequency Map using `HashMap<Character, Integer>`

### Approach 02

Frequency Array using character indexes

---

## Complexity Targets

### Approach 01

- Time: `O(n)`
- Space: `O(k)`

where `k` is the number of distinct characters.

### Approach 02

- Time: `O(n)`
- Space: `O(k)`

where `k` is the character set size.