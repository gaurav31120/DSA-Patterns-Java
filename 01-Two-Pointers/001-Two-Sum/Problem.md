# Problem 001 — Two Sum

## Pattern

**Two Pointers**

## Difficulty

**Easy**

## Problem Statement

Given an integer array `nums` and an integer `target`, find the two different elements in the array whose sum is equal to `target`.

Return the **indices** of those two elements.

You may assume that there is exactly one valid pair.

### Important

* You cannot use the same array element twice.
* The order of the returned indices does not matter.

---

## Example 1

**Input:**

```text
nums = [2, 7, 11, 15]
target = 9
```

**Output:**

```text
[0, 1]
```

**Explanation:**

`nums[0] + nums[1] = 2 + 7 = 9`

---

## Example 2

**Input:**

```text
nums = [3, 2, 4]
target = 6
```

**Output:**

```text
[1, 2]
```

**Explanation:**

`nums[1] + nums[2] = 2 + 4 = 6`

---

## Example 3

**Input:**

```text
nums = [3, 3]
target = 6
```

**Output:**

```text
[0, 1]
```

---

## Constraints

* `2 <= nums.length <= 10⁴`
* Each element of `nums` is an integer.
* `-10⁹ <= nums[i] <= 10⁹`
* `-10⁹ <= target <= 10⁹`
* Exactly one valid answer exists.
* The same index cannot be used twice.

---

## Expected Output

Return an integer array containing the **two indices** whose corresponding values add up to `target`.

---

## What You Should Practice

Try to solve this problem using the approaches you know.

Start with the most straightforward approach, then think about how you can improve it.

**Do not worry about writing `Approaches.md` yet.**
First solve the problem yourself.

## Interview Goal

You should eventually be able to explain:

1. How you identified the pattern.
2. Why your first approach works.
3. How you improved the solution.
4. Time and space complexity.
5. Why your final approach is preferable.
