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