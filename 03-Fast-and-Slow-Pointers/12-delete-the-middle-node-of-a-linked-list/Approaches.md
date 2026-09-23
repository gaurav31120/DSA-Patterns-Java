# Approach 01 — Two Pass

## Idea

Use two traversals of the linked list.

In the first traversal, find the total number of nodes.

Then calculate the middle index:

    middleIndex = length / 2

In the second traversal, move to the node immediately before the middle node.

Finally, skip the middle node using:

    curr.next = curr.next.next

For an even-length list, `length / 2` gives the index of the second middle node, which is the node that must be deleted.

---

## Steps

### Step 1 — Find Length

Traverse the complete linked list and count the number of nodes.

    int len = 0;
    Node curr = head;

    while (curr != null) {
        len++;
        curr = curr.next;
    }

---

### Step 2 — Calculate Middle Index

    int middleIndex = len / 2;

Examples:

    length = 7
    middleIndex = 3

    length = 6
    middleIndex = 3

    length = 4
    middleIndex = 2

---

### Step 3 — Reach the Previous Node

Reset:

    curr = head;

Move until `curr` points to the node immediately before the middle node.

    for (int i = 0; i < middleIndex - 1; i++) {
        curr = curr.next;
    }

---

### Step 4 — Delete the Middle Node

Skip the middle node:

    curr.next = curr.next.next;

Example:

    1 -> 2 -> 3 -> 4

Before deletion:

    curr -> 2
    curr.next -> 3

After:

    curr.next = curr.next.next

Result:

    1 -> 2 -> 4

---

## Example

Input:

    1 -> 3 -> 4 -> 7 -> 1 -> 2 -> 6

Length:

    7

Middle index:

    7 / 2 = 3

Node at index 3:

    7

Delete `7`.

Result:

    1 -> 3 -> 4 -> 1 -> 2 -> 6

---

## Even Length Example

Input:

    1 -> 2 -> 3 -> 4

Length:

    4

Middle index:

    4 / 2 = 2

Node at index 2:

    3

Result:

    1 -> 2 -> 4

This correctly removes the second of the two middle nodes.

---

## Edge Cases

### Empty List

    head == null

Return:

    null

### Single Node

    1

After deleting the middle node:

    null

### Two Nodes

    1 -> 2

The second middle node is `2`.

Result:

    1

---

## Complexity

- Time: O(n)
- Space: O(1)

---

## Java File

    _01_TwoPass.java

---

## Status

✅ Solved