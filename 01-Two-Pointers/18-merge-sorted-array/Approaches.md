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