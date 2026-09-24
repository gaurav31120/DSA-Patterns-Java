# Approach 01 — Extra Array

## Idea

Create a separate result array of size `m + n`.

Use three pointers:

    i -> valid elements of arr1
    j -> elements of arr2
    k -> result array

Compare the current elements from both arrays and place the smaller element into the result array.

After one array is completely processed, copy the remaining elements from the other array.

Finally, copy the merged result back into `arr1`.

---

## Important Point

Only the first `m` elements of `arr1` are valid.

Example:

    arr1 = [1, 2, 3, 0, 0, 0]
             <- m = 3 ->

The valid portion is:

    [1, 2, 3]

The remaining positions are empty space reserved for the merged result.

---

## Step 1 — Create Result Array

Create an array with enough space for all elements:

    int[] result = new int[m + n];

Example:

    m = 3
    n = 3

    result size = 6

---

## Step 2 — Initialize Three Pointers

    int i = 0;
    int j = 0;
    int k = 0;

Where:

    i -> current element in arr1
    j -> current element in arr2
    k -> current position in result

---

## Step 3 — Merge the Two Sorted Arrays

Compare:

    arr1[i]
    arr2[j]

If `arr1[i]` is smaller or equal:

    result[k] = arr1[i];

Otherwise:

    result[k] = arr2[j];

Move the corresponding pointer and `k`.

Continue while both arrays still have valid elements:

    while (i < m && j < n)

---

## Step 4 — Copy Remaining Elements

If `arr1` still has valid elements:

    while (i < m)

copy them into `result`.

If `arr2` still has elements:

    while (j < n)

copy them into `result`.

---

## Step 5 — Copy Result Back to arr1

Once merging is complete, copy all `m + n` elements back into `arr1`.

    for (int index = 0; index < m + n; index++) {
        arr1[index] = result[index];
    }

---

## Example

Input:

    arr1 = [1, 2, 3, 0, 0, 0]
    m = 3

    arr2 = [2, 5, 6]
    n = 3

Merge process:

    1 vs 2 -> take 1
    2 vs 2 -> take 2
    3 vs 2 -> take 2
    3 vs 5 -> take 3
    5 vs 5 -> take 5
    6 remains -> take 6

Result:

    [1, 2, 2, 3, 5, 6]

Copy back into arr1:

    arr1 = [1, 2, 2, 3, 5, 6]

---

## Edge Cases

### n = 0

Only the valid elements of `arr1` remain.

Example:

    arr1 = [1]
    m = 1

    arr2 = []
    n = 0

Result:

    [1]

### m = 0

All elements come from `arr2`.

Example:

    arr1 = [0]
    m = 0

    arr2 = [1]
    n = 1

Result:

    [1]

### Duplicate Values

Equal values are handled correctly.

Example:

    arr1 = [1, 2, 3]
    arr2 = [2, 5, 6]

Result:

    [1, 2, 2, 3, 5, 6]

---

## Complexity

- Time: O(m + n)
- Space: O(m + n)

---

## Java File

    _01_ExtraArray.java

---

## Status

✅ Solved

----------------------------------------------------------------

# Approach 02 — Backward Two Pointers

## Idea

Merge the two sorted arrays directly inside `arr1`.

The challenge is that `arr1` already contains its valid elements at the beginning.

If we merge from the beginning, we may overwrite elements of `arr1` that we still need.

So we merge from the **end**.

Use three pointers:

    i -> last valid element of arr1
    j -> last element of arr2
    k -> last position of arr1

For example:

    arr1 = [1, 2, 3, 0, 0, 0]
    arr2 = [2, 5, 6]

Initial:

    i = 2
    j = 2
    k = 5

---

## Step 1 — Initialize Pointers

    int i = m - 1;
    int j = n - 1;
    int k = m + n - 1;

Here:

    i points to the last valid value of arr1.
    j points to the last value of arr2.
    k points to the last available position in arr1.

---

## Step 2 — Compare From the End

Compare:

    arr1[i]
    arr2[j]

Place the larger value at:

    arr1[k]

For example:

    arr1[i] = 3
    arr2[j] = 6

Since `6` is larger:

    arr1[k] = 6

Then move:

    j--
    k--

---

## Step 3 — Continue Backwards

Continue while both arrays still have valid elements:

    while (i >= 0 && j >= 0)

For:

    arr1 = [1, 2, 3, 0, 0, 0]
    arr2 = [2, 5, 6]

The process is:

    3 vs 6 -> place 6
    3 vs 5 -> place 5
    3 vs 2 -> place 3
    2 vs 2 -> place 2
    1 vs 2 -> place 2

Result:

    [1, 2, 2, 3, 5, 6]

---

## Step 4 — Copy Remaining arr2 Elements

If elements are still left in `arr2`, copy them:

    while (j >= 0) {
        arr1[k] = arr2[j];
        j--;
        k--;
    }

---

## Why No Remaining arr1 Loop?

If `arr2` becomes empty first, the remaining elements of `arr1` are already in the correct positions.

Therefore, no additional work is required for the remaining `arr1` elements.

---

## Why Do We Merge Backwards?

Suppose:

    arr1 = [1, 2, 3, 0, 0, 0]
    arr2 = [2, 5, 6]

If we merge from the beginning, writing into `arr1` could overwrite `2` or `3` before we use them.

By starting from the end, the empty positions are used first.

Therefore, no required values are overwritten.

---

## Important Point

We compare the largest remaining elements first.

So the pointer movement is:

    larger element -> arr1[k]
    move that pointer
    k--

This continues until all values are placed.

---

## Edge Cases

### n = 0

Nothing needs to be merged.

The existing valid elements of `arr1` are already sorted.

### m = 0

All elements come from `arr2`.

Example:

    arr1 = [0]
    arr2 = [1]

Result:

    [1]

### Duplicate Values

Equal values are handled correctly.

Example:

    arr1 = [1, 2, 3, 0, 0, 0]
    arr2 = [2, 5, 6]

Result:

    [1, 2, 2, 3, 5, 6]

---

## Complexity

- Time: O(m + n)
- Space: O(1)

---

## Java File

    _02_BackwardTwoPointers.java

---

## Status

✅ Solved