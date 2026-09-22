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

# Approach 02 — Fast & Slow + Reverse + Merge

- **Status:** Solved
- **Time Complexity:** O(n)
- **Space Complexity:** O(1)
- **Priority:** MUST MASTER 🔥

## Idea

Rearrange the linked list using three linked-list techniques:

1. Find the middle using Fast & Slow Pointers.
2. Reverse the second half.
3. Merge both halves alternately.

For:

    1 → 2 → 3 → 4 → 5

the required result is:

    1 → 5 → 2 → 4 → 3

## Step 1 — Find the Middle

Use:

    slow = head
    fast = head

Move:

    slow → 1 step
    fast → 2 steps

When `fast` reaches the end, `slow` is at the middle.

## Step 2 — Split the List

Save the second half:

    secondHalf = slow.next

Then disconnect the two halves:

    slow.next = null

For example:

    1 → 2 → 3 | 4 → 5

## Step 3 — Reverse the Second Half

Reverse:

    4 → 5

into:

    5 → 4

Use the standard linked-list reversal:

    prev = null
    curr = secondHalf

    while (curr != null) {
        next = curr.next
        curr.next = prev
        prev = curr
        curr = next
    }

After reversal:

    prev → 5 → 4

## Step 4 — Merge Alternately

Now:

    First:
    1 → 2 → 3

    Second:
    5 → 4

We need:

    1 → 5 → 2 → 4 → 3

Before changing links, save:

    firstNext = first.next
    secondNext = second.next

Then:

    first.next = second
    second.next = firstNext

Move:

    first = firstNext
    second = secondNext

Repeat until the second half is exhausted.

## Key Pattern

    Find Middle
         ↓
    Split List
         ↓
    Reverse Second Half
         ↓
    Merge Alternately

## Important Point

Always save the next pointers before changing links:

    Node firstNext = first.next;
    Node secondNext = second.next;

Otherwise, existing links can be lost or a cycle can be created.

## Complexity

    Time: O(n)
    Space: O(1)