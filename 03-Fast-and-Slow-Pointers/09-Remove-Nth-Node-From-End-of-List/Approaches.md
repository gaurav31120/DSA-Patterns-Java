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