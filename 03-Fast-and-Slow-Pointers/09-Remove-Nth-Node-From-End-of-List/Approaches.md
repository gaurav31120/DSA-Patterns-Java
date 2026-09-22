# Approach 01 — ArrayList

- **Status:** Solved
- **Time Complexity:** O(n)
- **Space Complexity:** O(n)
- **Priority:** OPTIONAL

## Idea

Store all linked-list nodes in an `ArrayList`.

This gives direct access to every node by index.

The `nth` node from the end can be converted into an index from the beginning using:

    index = list.size() - n

Then reconnect the list while skipping that node.

## Steps

1. Traverse the linked list.
2. Store every node in an `ArrayList`.
3. Calculate:

       index = list.size() - n

4. If `index == 0`, remove the head by returning:

       head.next

5. Otherwise, traverse the stored nodes.
6. Skip the node at `index`.
7. Reconnect the remaining nodes using `next`.
8. Set the final node's `next` to `null`.
9. Return the head.

## Example

    head = [1,2,3,4,5]
    n = 2

The target index is:

    5 - 2 = 3

So the node at index `3` is:

    4

Skip it and reconnect:

    1 → 2 → 3 → 5

## Important Point

The conversion:

    index = list.size() - n

changes the position from:

    nth node from the end

to:

    index from the beginning

## Edge Cases

    [1], n = 1
    → []

    [1,2], n = 1
    → [1]

    [1,2], n = 2
    → [2]

    [1,2,3,4,5], n = 5
    → [2,3,4,5]

## Complexity

    Time: O(n)
    Space: O(n)

-----------------------------------------------------------------------------

# Approach 02 — Two Pass

- **Status:** Solved
- **Time Complexity:** O(n)
- **Space Complexity:** O(1)
- **Priority:** OPTIONAL

## Idea

Use two traversals.

### Pass 1

Traverse the linked list and calculate its total length.

### Pass 2

Convert the `nth` position from the end into an index from the beginning:

    index = length - n

Then move to the node immediately before the target and remove it.

## Steps

1. Traverse the list and calculate `length`.
2. If `n == length`, the head must be removed.
3. Otherwise calculate:

       index = length - n

4. Start again from `head`.
5. Move to the node before the target.
6. Remove the target using:

       curr.next = curr.next.next

7. Return `head`.

## Example

    head = [1,2,3,4,5]
    n = 2

Length:

    5

Target index:

    5 - 2 = 3

Index `3` contains:

    4

The node before it is:

    3

Remove it:

    3.next = 5

Result:

    [1,2,3,5]

## Important Point

If:

    n == length

then the target is the head.

So return:

    head.next

## Complexity

    Time: O(n)
    Space: O(1)

----------------------------------------------------------------

# Approach 03 — Fast & Slow Pointers

## Problem

**LeetCode #19 — Remove Nth Node From End of List**

## Idea

Use two pointers:

- `slow`
- `fast`

Also create a dummy node before the head.

The dummy node helps us handle the case where the head itself needs to be removed.

Initial structure:

    dummy -> 1 -> 2 -> 3 -> 4 -> 5

Both pointers start at the dummy node:

    slow = dummy
    fast = dummy

---

## Step 1 — Create Dummy Node

    Node dummy = new Node(0);
    dummy.next = head;

Now the list becomes:

    dummy -> 1 -> 2 -> 3 -> 4 -> 5

---

## Step 2 — Initialize Slow and Fast

    Node slow = dummy;
    Node fast = dummy;

Both pointers are initially at the dummy node.

---

## Step 3 — Move Fast N Steps

Move `fast` exactly `n` steps ahead.

    for (int i = 0; i < n; i++) {
        fast = fast.next;
    }

For:

    1 -> 2 -> 3 -> 4 -> 5
    n = 2

`fast` moves 2 steps ahead.

The important point is that `slow` and `fast` now have a fixed gap.

---

## Step 4 — Move Both Pointers

Move both pointers together until `fast` reaches the last node.

    while (fast.next != null) {
        slow = slow.next;
        fast = fast.next;
    }

For:

    1 -> 2 -> 3 -> 4 -> 5
    n = 2

At the end:

    slow -> 3
    fast -> 5

Therefore:

    slow.next -> 4

Node `4` is the node that must be removed.

---

## Step 5 — Remove the Node

Remove the node using:

    slow.next = slow.next.next;

Before:

    3 -> 4 -> 5

After:

    3 -> 5

Final list:

    1 -> 2 -> 3 -> 5

---

## Step 6 — Return the Head

Return:

    return dummy.next;

We return `dummy.next` instead of `head` because the head itself may have been removed.

---

## Why Do We Need a Dummy Node?

Consider:

    1 -> 2
    n = 2

Here, node `1` is the node that must be removed.

With a dummy node:

    dummy -> 1 -> 2

`slow` can remain at `dummy`.

Then:

    slow.next = slow.next.next;

changes:

    dummy -> 1 -> 2

into:

    dummy -> 2

Finally:

    return dummy.next;

returns:

    2

So the same deletion logic works even when removing the head.

---

## Complete Flow

    dummy -> 1 -> 2 -> 3 -> 4 -> 5

Move `fast` n steps ahead.

Then move `slow` and `fast` together.

When `fast` reaches the last node:

    slow -> 3
    fast -> 5

Remove:

    3 -> 4 -> 5

using:

    slow.next = slow.next.next;

Result:

    1 -> 2 -> 3 -> 5

Return:

    dummy.next

---

## Complexity

- **Time:** O(n)
- **Space:** O(1)

---

## Java File

    _03_FastSlowPointers.java

---

## Status

✅ Solved

---

## Pattern Learned

**Fast & Slow Pointers with a Fixed Gap**

    1. Create a dummy node.
    2. Put slow and fast at dummy.
    3. Move fast n steps ahead.
    4. Move both pointers together.
    5. Slow reaches the node before the target.
    6. Remove the target node.
    7. Return dummy.next.