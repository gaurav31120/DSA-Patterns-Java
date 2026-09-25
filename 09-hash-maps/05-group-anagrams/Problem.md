# P005 — Group Anagrams

**LeetCode:** #49
**Pattern:** Hash Maps
**Difficulty:** Medium

---

## Problem

Given an array of strings, group the anagrams together.

You can return the answer in any order.

Two strings are anagrams if they contain the same characters with the same
frequencies, but possibly in a different order.

---

## Example

### Input

strs = ["eat","tea","tan","ate","nat","bat"]

### Output

[
    ["bat"],
    ["nat","tan"],
    ["ate","eat","tea"]
]

The order of the groups and the strings inside each group does not matter.

---

## Key Observation

Anagrams have exactly the same character frequencies.

For example:

    "eat"

and:

    "tea"

Both contain:

    a → 1
    e → 1
    t → 1

Therefore, they should belong to the same group.

---

## Pattern Recognition

Think:

    How can I create the same key for all anagrams?

One possibility is:

    character → frequency

For lowercase English letters, the frequency pattern can be represented
using a fixed-size array.

---

## Approaches

### Approach 01

Frequency Map as the Anagram Key

### Approach 02

Sorted String as the Anagram Key

---

## Complexity Targets

### Approach 01

- Time: O(n × k)
- Space: O(n × k)

### Approach 02

- Time: O(n × k log k)
- Space: O(n × k)

where:

- `n` = number of strings
- `k` = average length of each string