# Approaches

## Approach 01 — Extra Array + Sorting

### Idea

Create an extra array and store the square of every element.

After that, sort the result array using `Arrays.sort()`.

### Steps

1. Create a result array of the same size as the input.
2. Traverse the input array.
3. Store `arr[i] * arr[i]` in `result[i]`.
4. Sort the result array.
5. Return the result array.

### Complexity

- Time: O(n log n)
- Space: O(n)

### Status

✅ Completed

---

## Approach 02 — Two Pointers

### Idea

The input array is already sorted, but after squaring, the order may change.

The largest square can only come from either:
- the leftmost element, or
- the rightmost element.

Use two pointers to compare their absolute values and fill the result array from right to left.

### Steps

1. Create a result array.
2. Set `left = 0`.
3. Set `right = arr.length - 1`.
4. Set `k = arr.length - 1`.
5. Compare `Math.abs(arr[left])` and `Math.abs(arr[right])`.
6. Put the larger square at `result[k]`.
7. Move the pointer from which the larger value was taken.
8. Decrement `k`.
9. Continue until `left > right`.
10. Return the result array.

### Complexity

- Time: O(n)
- Space: O(n)

### Status

✅ Completed

---

# Approach Comparison

| Approach | Time | Space | Key Idea |
|----------|------|-------|----------|
| Extra Array + Sorting | O(n log n) | O(n) | Square everything, then sort |
| Two Pointers | O(n) | O(n) | Compare both ends and fill from right |

## ⭐ Best Approach

**Approach 02 — Two Pointers**

Why?

- Linear time: O(n)
- Uses the sorted property of the input
- Demonstrates the Two Pointers pattern
- No sorting required