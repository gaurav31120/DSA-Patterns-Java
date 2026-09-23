# Approach 01 — Two Pass

## Idea

Use two traversals of the linked list.

First, find the total length of the list.

Then find:

- the `k`th node from the beginning
- the `k`th node from the end

Finally, swap their values.

We do not change the linked-list structure.

---

## Step 1 — Find Length

Traverse the complete linked list and count the nodes.

    int len = 0;
    Node curr = head;

    while (curr != null) {
        len++;
        curr = curr.next;
    }

---

## Step 2 — Find kth Node From Beginning

The `k`th node from the beginning is at index:

    k - 1

Starting from `head`, move `k - 1` times.

    Node first = head;

    for (int i = 0; i < k - 1; i++) {
        first = first.next;
    }

Example:

    1 -> 2 -> 3 -> 4 -> 5

    k = 2

    first -> 2

---

## Step 3 — Find kth Node From End

The position of the `k`th node from the end, counted from the beginning, is:

    len - k

So start from `head` and move `len - k` times.

    Node second = head;

    for (int i = 0; i < len - k; i++) {
        second = second.next;
    }

Example:

    len = 5
    k = 2

    len - k = 3

    second -> 4

---

## Step 4 — Swap Values

The problem requires swapping the values, not changing the links.

    int temp = first.data;
    first.data = second.data;
    second.data = temp;

Example:

    1 -> 2 -> 3 -> 4 -> 5

    k = 2

    first = 2
    second = 4

After swapping:

    1 -> 4 -> 3 -> 2 -> 5

---

## Important Point

We swap:

    first.data
    second.data

We do not swap:

    first.next
    second.next

The linked-list structure remains unchanged.

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