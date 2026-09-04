# Approaches

## Approach 01 — Brute Force

### Idea

Check every possible pair of elements and find the pair whose sum equals the target.

For each index `i`, compare `nums[i]` with every element after it. If their sum equals the target, return their indices.

### Steps

1. Start from index `i = 0`.
2. For every `i`, start `j` from `i + 1`.
3. Check whether `nums[i] + nums[j] == target`.
4. If yes, return the two indices.
5. Continue until a valid pair is found.

### Complexity

* **Time:** O(n²)
* **Space:** O(1)

### Status

**Basic Approach**

---

## Approach 02 — HashMap

### Idea

Use a HashMap to store each previously visited number along with its index.

For the current number, calculate the value required to reach the target:

```text
complement = target - current
```

If that complement already exists in the HashMap, we have found the required pair.

### Steps

1. Create a HashMap to store `value → index`.
2. Traverse the array once.
3. For the current element, calculate:
   `complement = target - nums[i]`
4. Check whether the complement exists in the HashMap.
5. If it exists, return the stored index and current index.
6. Otherwise, store the current value and its index.
7. Continue until the pair is found.

### Complexity

* **Time:** O(n)
* **Space:** O(n)

### Status

**Optimal Approach for the standard unsorted Two Sum problem**

---

## Approach Comparison

| Approach    |  Time | Space | Status      |
| ----------- | ----: | ----: | ----------- |
| Brute Force | O(n²) |  O(1) | Basic       |
| HashMap     |  O(n) |  O(n) | **Optimal** |

### Key Learning

The main optimization is reducing repeated pair comparisons by using a HashMap for constant-average-time lookup.

The important formula is:

```text
current + complement = target

complement = target - current
```
