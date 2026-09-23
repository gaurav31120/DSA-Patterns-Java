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

----------------------------------------------------

# Approach 02 — Fast & Slow Pointers

## Idea

Use two pointers to find the two nodes whose values must be swapped:

- `first` = kth node from the beginning
- `second` = kth node from the end

First find the kth node from the beginning.

Then use that node as the `fast` pointer and keep `slow` at the head.

Because `fast` is already `k - 1` nodes ahead of `slow`, moving both pointers together until `fast` reaches the last node makes `slow` the kth node from the end.

Finally, swap the values of the two nodes.

---

## Step 1 — Find kth Node From Beginning

Start:

    Node first = head;

Move `first` `k - 1` times.

    for (int i = 1; i < k; i++) {
        first = first.next;
    }

Example:

    1 -> 2 -> 3 -> 4 -> 5

    k = 2

    first -> 2

---

## Step 2 — Create the Gap

Initialize:

    Node slow = head;
    Node fast = first;

Now `fast` is `k - 1` nodes ahead of `slow`.

For:

    1 -> 2 -> 3 -> 4 -> 5

    k = 2

we have:

    slow -> 1
    fast -> 2

---

## Step 3 — Find kth Node From End

Move both pointers together:

    while (fast.next != null) {
        slow = slow.next;
        fast = fast.next;
    }

When `fast` reaches the last node:

    slow = kth node from the end

Example:

    slow -> 4
    fast -> 5

Therefore:

    second = 4

---

## Step 4 — Swap Values

The problem requires swapping values, not changing the linked-list structure.

    int temp = first.data;
    first.data = second.data;
    second.data = temp;

Example:

    1 -> 2 -> 3 -> 4 -> 5

    k = 2

After swapping:

    1 -> 4 -> 3 -> 2 -> 5

---

## Why This Works

The fixed gap between `slow` and `fast` allows us to locate the kth node from the end without calculating the length.

The distance between the two pointers remains:

    k - 1

When `fast` reaches the last node, `slow` must be the kth node from the end.

---

## Edge Cases

### k = 1

The first node is swapped with the last node.

### k = length

The first and second nodes refer to the same node.

Swapping its value with itself has no effect.

### Adjacent Nodes

The two target nodes may be adjacent.

Only their values are swapped, so no link changes are required.

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