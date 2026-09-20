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
    

# Approach 02 — Extra Array

- **Status:** Solved
- **Time Complexity:** O(n)
- **Space Complexity:** O(n)
- **Priority:** OPTIONAL

## Idea

Create a separate array and store only the elements that are not equal to `val`.

A variable `k` represents the next position where a valid element should be placed.

For every element:

    arr[i] != val
        ↓
    res[k] = arr[i]
        ↓
    k++

After scanning the original array, copy the first `k` elements from `res` back into `arr`.

## Steps

1. Create a new array with the same size as `arr`.
2. Initialize `k = 0`.
3. Traverse the original array.
4. If `arr[i] != val`, store it at `res[k]`.
5. Increment `k`.
6. Copy `res[0 ... k-1]` back into `arr`.
7. Return `k`.

## Example

    arr = [3,2,2,3]
    val = 3

After scanning:

    res = [2,2,0,0]
    k = 2

Copy the valid elements back:

    arr = [2,2,0,0]

Return:

    k = 2

## Key Concept

Only the first `k` elements matter after the operation.

## Complexity

    Time: O(n)
    Space: O(n)