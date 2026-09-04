# Problem 002 — Remove Duplicates

## Pattern

**Two Pointers**

## Difficulty

**Easy**

## Problem Statement

Given a **sorted integer array**, remove the duplicate values **in-place** so that every unique value appears only once.

Return the number of unique elements remaining in the array.

The first `k` positions of the array should contain the unique values in their original sorted order.

The elements after the first `k` positions do not matter.

### Important

* The array is already sorted.
* The modification must be done **in-place**.
* You should not create another array to store the result.
* Return the number of unique elements.

---

## Example 1

**Input:**

```text
nums = [1, 1, 2]
```

**Output:**

```text
2
```

**Modified array:**

```text
[1, 2, _]
```

---

## Example 2

**Input:**

```text
nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
```

**Output:**

```text
5
```

**Modified array:**

```text
[0, 1, 2, 3, 4, _, _, _, _, _]
```

---

## Example 3

**Input:**

```text
nums = [1]
```

**Output:**

```text
1
```

**Modified array:**

```text
[1]
```

---

## Constraints

* `1 <= nums.length <= 30,000`
* `-100 <= nums[i] <= 100`
* `nums` is sorted in non-decreasing order.

---

## Expected Output

Return an integer `k`, where `k` represents the number of unique elements.

After the operation:

```text
nums[0] ... nums[k - 1]
```

must contain all unique values.

---

## What You Should Practice

Try to solve this problem yourself using the **Two Pointers** pattern.

Think carefully about:

* Which pointer should represent the position where the next unique value should be placed?
* Which pointer should scan through the array?
* Since the array is sorted, how can you identify a duplicate without extra storage?

Do not use a second array.

## Interview Goal

You should be able to explain:

1. Why the sorted property makes duplicate detection easier.
2. What each pointer represents.
3. Why the solution works in-place.
4. The time and space complexity.
