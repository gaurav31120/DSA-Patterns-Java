# P009 — Remove Nth Node From End of List

**LeetCode:** #19  
**Pattern:** Fast & Slow Pointers  
**Difficulty:** Medium

---

## Problem

Given the head of a singly linked list, remove the `n`th node from the end of the list and return the head of the modified list.

---

## Example 1

### Input

    head = [1,2,3,4,5]
    n = 2

### Output

    [1,2,3,5]

### Explanation

The 2nd node from the end is `4`.

    1 → 2 → 3 → 4 → 5
                ↑
              remove

After removing it:

    1 → 2 → 3 → 5

---

## Example 2

### Input

    head = [1]
    n = 1

### Output

    []

The only node is removed.

---

## Example 3

### Input

    head = [1,2]
    n = 1

### Output

    [1]

---

## Understanding the Problem

The challenge is that `n` is given from the **end** of the linked list.

For example:

    1 → 2 → 3 → 4 → 5

If:

    n = 2

then:

    5 → 1st from end
    4 → 2nd from end

So we need to remove:

    4

---

## Important Requirements

- Remove exactly the `n`th node from the end.
- Return the head of the modified linked list.
- The linked list is singly linked.
- The optimal solution should use constant extra space.
- The optimal solution should use one traversal.

---

## Key Observation

A singly linked list can easily move from the beginning toward the end, but it cannot move backward.

We can use two pointers and maintain a fixed gap of `n` nodes between them.

When the fast pointer reaches the end, the slow pointer will be positioned just before the node that needs to be removed.

---

## Visual Idea

For:

    1 → 2 → 3 → 4 → 5

and:

    n = 2

Maintain a gap between the two pointers.

    slow
     ↓
    1 → 2 → 3 → 4 → 5
                    ↑
                   fast

When `fast` reaches the end, `slow` will be positioned correctly to remove the required node.

---

## Main Idea

Use:

    slow
    fast

First create a gap of `n` nodes between them.

Then move both pointers together.

When `fast` reaches the end:

    slow

will be just before the node that must be removed.

We can remove it by changing:

    slow.next

---

## Goal

Try to achieve:

    Time Complexity: O(n)
    Space Complexity: O(1)

---

# Approaches

We have **3 meaningful approaches**:

### Approach 01 — ArrayList

- Traverse the linked list and store the nodes in an `ArrayList`.
- Use indexes to identify the `n`th node from the end.
- **Time:** O(n)
- **Space:** O(n)
- **OPTIONAL**

### Approach 02 — Two Pass

- First traverse the list to find its length.
- Calculate the position of the node from the beginning.
- Traverse again to remove it.
- **Time:** O(n)
- **Space:** O(1)
- **OPTIONAL**

### Approach 03 — Fast & Slow Pointers

- Maintain a fixed gap of `n` nodes between two pointers.
- Move both pointers together.
- When `fast` reaches the end, `slow` is positioned before the target node.
- Remove the node by changing `slow.next`.
- **Time:** O(n)
- **Space:** O(1)
- **MUST MASTER 🔥**

---

## What You Should Learn

This problem reinforces:

- Fast & Slow Pointers
- Maintaining a fixed gap
- Linked List traversal
- Removing nodes by changing `next`
- Dummy node technique
- One-pass linked-list solutions

---

## Edge Cases

Consider:

    [1], n = 1

    [1,2], n = 1

    [1,2], n = 2

    [1,2,3,4,5], n = 5

The last case removes the head of the linked list.

---

## Expected Complexity

    Approach 01:
    Time: O(n)
    Space: O(n)

    Approach 02:
    Time: O(n)
    Space: O(1)

    Approach 03:
    Time: O(n)
    Space: O(1)
    MUST MASTER 🔥