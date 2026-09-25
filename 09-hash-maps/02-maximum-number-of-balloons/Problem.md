# P002 — Maximum Number of Balloons

**LeetCode:** #1189  
**Pattern:** Hash Maps  
**Difficulty:** Easy

---

## Problem

Given a string `text`, return the maximum number of instances of the word:

    "balloon"

that can be formed using the characters from `text`.

Each character can be used only once.

---

## Example 1

### Input

text = "nlaebolko"

### Output

1

### Explanation

We can form:

    balloon

once.

---

## Example 2

### Input

text = "loonbalxballpoon"

### Output

2

### Explanation

We can form:

    balloon
    balloon

two times.

---

## Example 3

### Input

text = "leetcode"

### Output

0

---

## Important Observation

The word `balloon` contains:

    b → 1
    a → 1
    l → 2
    o → 2
    n → 1

Therefore, `l` and `o` are needed twice for every one `balloon`.

---

## Pattern Recognition

Ask:

> How many times does each required character occur in `text`?

Then:

> Which required character becomes the limiting factor?

For example:

    b = 3
    a = 2
    l = 6
    o = 4
    n = 5

The number of `balloon`s we can form is:

    min(3, 2, 6/2, 4/2, 5)
    = min(3, 2, 3, 2, 5)
    = 2

---

## Approaches

### Approach 01

Frequency Map

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