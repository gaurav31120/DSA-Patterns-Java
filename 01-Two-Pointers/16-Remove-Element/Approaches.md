# Approach 01 — Nested Loops / Shifting

- **Status:** Solved
- **Time Complexity:** O(n²)
- **Space Complexity:** O(1)
- **Priority:** OPTIONAL

## Idea

Scan the valid portion of the array.

Whenever:

    arr[i] == val

remove that element by shifting all elements after it one position to the left.

After shifting:

    k--

The pointer `i` is not increased after a removal because a new element has moved into the same position and must be checked.

## Steps

1. Initialize `k = arr.length`.
2. Start `i` from `0`.
3. While `i < k`:
   - If `arr[i] == val`, shift elements left.
   - Decrease `k`.
   - Keep `i` at the same position.
   - Otherwise increase `i`.
4. Return `k`.

## Key Logic

    arr[i] == val
        ↓
    Shift elements left
        ↓
    k--
        ↓
    Check same index again

    arr[i] != val
        ↓
    i++

## Example

    arr = [3,2,2,3]
    val = 3

After removing the first `3`:

    [2,2,3,3]

Then `k` becomes:

    3

After removing the second `3`:

    k = 2

Valid portion:

    [2,2]

## Complexity

    Time: O(n²)
    Space: O(1)