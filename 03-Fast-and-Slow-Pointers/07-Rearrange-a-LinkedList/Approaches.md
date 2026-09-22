# Approach 01 — ArrayList

- **Status:** Solved
- **Time Complexity:** O(n)
- **Space Complexity:** O(n)
- **Priority:** OPTIONAL

## Idea

Store all existing linked-list nodes in an `ArrayList`.

This gives direct access to:

- First node
- Last node
- Second node
- Second-last node
- And so on

Then reconnect the existing nodes in the required order.

The required order is:

    L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → ...

## Steps

1. Traverse the linked list and store every `Node` in an `ArrayList`.
2. Set:

       prev = list.get(0)
       left = 1
       right = list.size() - 1

3. Connect the last node after `prev`.
4. Connect the next left node after that.
5. Move `left` and `right` inward.
6. For an odd-length list, connect the remaining middle node.
7. Set the final node's `next` to `null`.

## Example

Original:

    1 → 2 → 3 → 4

ArrayList:

    [1, 2, 3, 4]

Rearrange:

    1 → 4 → 2 → 3

For:

    1 → 2 → 3 → 4 → 5

Result:

    1 → 5 → 2 → 4 → 3

## Important Point

We must modify the actual `next` references.

Changing:

    curr = list.get(...)

only moves the local variable.

Changing:

    prev.next = list.get(...)

actually changes the linked-list structure.

At the end:

    prev.next = null

is necessary to avoid keeping an old link or creating a cycle.

## Pattern Reinforced

- Fast & Slow Pointers
- Linked List Reconnection
- ArrayList
- Two-ended traversal
- In-place node rearrangement

## Complexity

    Time: O(n)
    Space: O(n)