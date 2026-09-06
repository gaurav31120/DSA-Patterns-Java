# P001 — Linked List Cycle

## Pattern

Fast & Slow Pointers

## Difficulty

Easy

## Problem

Given the head of a singly linked list, determine whether the linked list contains a cycle.

A cycle exists if there is some node in the list that can be reached again by continuously following the `next` pointer.

Return:

* `true` if a cycle exists.
* `false` if no cycle exists.

The linked list uses `pos` to describe the index of the node that the tail connects to. `pos` is not given as a parameter.

---

## Example 1

### Input

```text
head = [3,2,0,-4]
pos = 1
```

The tail connects back to the node with value `2`.

```text
3 → 2 → 0 → -4
    ↑         ↓
    └─────────┘
```

### Output

```text
true
```

---

## Example 2

### Input

```text
head = [1,2]
pos = 0
```

```text
1 → 2
↑   ↓
└───┘
```

### Output

```text
true
```

---

## Example 3

### Input

```text
head = [1]
pos = -1
```

```text
1 → null
```

### Output

```text
false
```

---

## Constraints

* `0 <= number of nodes <= 10⁴`
* `-10⁵ <= Node.val <= 10⁵`
* `pos` is `-1` or a valid index.

---

## Requirements

* Determine whether a cycle exists.
* Do not modify the linked list.
* Target `O(n)` time.
* Target `O(1)` extra space.

---

## Key Learning

This problem introduces **cycle detection** in a linked list.

The optimal solution uses **Floyd's Cycle Detection Algorithm**, also known as the **Fast & Slow Pointers** technique.

```text
Slow → 1 step
Fast → 2 steps
```

If a cycle exists, the fast pointer will eventually meet the slow pointer.

If there is no cycle, the fast pointer will eventually reach `null`.
