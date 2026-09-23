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

--------------------------------------------------------

# Approach 02 — Fast & Slow Pointers

## Idea

Use two pointers:

- `slow` moves one node at a time.
- `fast` moves two nodes at a time.

The goal is to make `slow` reach the node just before the middle node.

Then we remove the middle node by changing the previous node's `next`.

---

## Steps

### Step 1 — Handle Small Lists

If the list is empty or contains only one node:

    if (head == null || head.next == null) {
        return null;
    }

For a single-node list, that node itself is the middle node and must be deleted.

---

### Step 2 — Initialize Pointers

Using a dummy node:

    dummy -> head

Initialize:

    Node slow = dummy;
    Node fast = dummy;

The dummy node allows the same deletion logic to work for all valid list sizes.

---

### Step 3 — Move the Pointers

Move `slow` one step and `fast` two steps:

    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

When the loop ends, `slow` is positioned immediately before the middle node.

---

### Step 4 — Delete the Middle Node

Skip the middle node:

    slow.next = slow.next.next;

For:

    1 -> 2 -> 3 -> 4

`slow` reaches node `2`.

So:

    slow.next = slow.next.next;

changes:

    2 -> 3 -> 4

into:

    2 -> 4

Result:

    1 -> 2 -> 4

---

## Odd-Length Example

Input:

    1 -> 2 -> 3 -> 4 -> 5

The middle node is:

    3

The algorithm positions `slow` at:

    2

Then:

    slow.next = slow.next.next;

Result:

    1 -> 2 -> 4 -> 5

---

## Even-Length Example

Input:

    1 -> 2 -> 3 -> 4

There are two middle nodes:

    2, 3

The problem requires deleting the second middle:

    3

The algorithm positions `slow` at:

    2

Then:

    slow.next = slow.next.next;

Result:

    1 -> 2 -> 4

---

## Why Fast & Slow Works

`fast` moves twice as quickly as `slow`.

Therefore, when `fast` reaches the end of the list, `slow` has reached the middle area.

Using the dummy node makes `slow` stop at the node immediately before the middle, which allows direct deletion.

---

## Complexity

- Time: O(n)
- Space: O(1)

---

## Java File

    _02_FastSlowPointers.java

---

## Status

✅ Solved