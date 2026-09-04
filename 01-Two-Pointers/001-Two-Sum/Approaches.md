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

If that complement already exists in the HashMap, the required pair has been found.

### Steps

1. Create a HashMap to store `value → index`.
2. Traverse the array once.
3. Calculate `complement = target - nums[i]`.
4. Check whether the complement exists in the map.
5. If it exists, return the stored index and current index.
6. Otherwise, store the current value and index.

### Complexity

* **Time:** O(n)
* **Space:** O(n)

### Status

**Optimal Approach for the standard unsorted Two Sum problem**

---

## Approach 03 — Two Pointers

### Idea

Two Pointers works naturally on a sorted array.

Because the problem requires the **original indices**, store each value together with its original index before sorting.

Each pair contains:

```text
[value, originalIndex]
```

After sorting by value, use two pointers:

* `left` starts at the beginning.
* `right` starts at the end.

Compare their sum with the target and move the appropriate pointer.

### Steps

1. Create a 2D array storing each value and its original index.
2. Sort the pairs by value.
3. Set `left = 0`.
4. Set `right = n - 1`.
5. Calculate the sum of the values at `left` and `right`.
6. If the sum equals the target, return their original indices.
7. If the sum is smaller than the target, move `left` forward.
8. If the sum is larger than the target, move `right` backward.
9. Continue until the pair is found.

### Complexity

* **Time:** O(n log n)
* **Space:** O(n)

### Status

**Valid Alternative Approach**

---

## Approach Comparison

| Approach     |       Time | Space | Status      |
| ------------ | ---------: | ----: | ----------- |
| Brute Force  |      O(n²) |  O(1) | Basic       |
| HashMap      |       O(n) |  O(n) | **Optimal** |
| Two Pointers | O(n log n) |  O(n) | Alternative |

### Key Learning

Two Pointers requires sorted data.

When a problem asks for original indices, sorting the values directly loses their original positions. Store the value together with its original index before sorting.

The pointer rule is:

```text
sum < target → left++

sum > target → right--

sum == target → found
```
