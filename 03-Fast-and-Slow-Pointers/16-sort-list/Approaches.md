# Approach 01 — ArrayList + Sorting

## Idea

Store all node values in an `ArrayList`.

Sort the values using `Collections.sort()`.

Then traverse the linked list again and write the sorted values back into the existing nodes.

For example:

    4 -> 2 -> 1 -> 3

Store:

    [4, 2, 1, 3]

After sorting:

    [1, 2, 3, 4]

Write the values back:

    1 -> 2 -> 3 -> 4

---

## Steps

### Step 1 — Store Node Values

Traverse the linked list and add each value to the ArrayList.

    List<Integer> values = new ArrayList<>();

    Node curr = head;

    while (curr != null) {
        values.add(curr.data);
        curr = curr.next;
    }

---

### Step 2 — Sort the Values

Use:

    Collections.sort(values);

Example:

    [4, 2, 1, 3]

becomes:

    [1, 2, 3, 4]

---

### Step 3 — Write Values Back

Reset the linked-list pointer:

    curr = head;

Traverse the sorted ArrayList and replace the node values.

    for (int i = 0; i < values.size(); i++) {
        curr.data = values.get(i);
        curr = curr.next;
    }

---

## Example

Input:

    4 -> 2 -> 1 -> 3

ArrayList:

    [4, 2, 1, 3]

Sorted ArrayList:

    [1, 2, 3, 4]

Final linked list:

    1 -> 2 -> 3 -> 4

---

## Important Point

This approach sorts the **values** stored in the nodes.

The linked-list node connections are not changed.

The next approach will sort the linked list by actually splitting and merging nodes.

---

## Complexity

- Time: O(n log n)
- Space: O(n)

---

## Java File

    _01_ArrayList.java

---

## Status

✅ Solved