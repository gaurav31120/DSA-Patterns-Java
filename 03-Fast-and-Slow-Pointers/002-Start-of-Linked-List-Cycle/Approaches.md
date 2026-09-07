## Approach 01 — Visited Set — Time: O(n), Space: O(n)

### Idea

Traverse the linked list while storing every visited node in a
`HashSet`.

If a node is encountered again, that node is the starting point of
the cycle.

### Steps

1. Create a `HashSet<Node>`.
2. Start traversal from the head using a temporary pointer.
3. Check whether the current node already exists in the set.
4. If it exists, return the current node as the cycle start.
5. Otherwise, add the current node to the set.
6. Move to the next node.
7. If `null` is reached, return `null`.

### Why It Works

The first node encountered for the second time must be the node where
the cycle begins.

We store node references rather than node values because different
nodes can contain the same value.

### Complexity

* **Time:** O(n)
* **Space:** O(n)

### Status

✅ Completed

## Approach 02 — Fast & Slow Pointers + Reset — Time: O(n), Space: O(1)

### Idea

Use Floyd's Cycle Detection Algorithm in two phases.

First, use `slow` and `fast` pointers to detect whether a cycle exists.

If they meet, reset `slow` to the head and move both pointers one step
at a time.

The node where they meet again is the starting node of the cycle.

### Steps

#### Phase 1 — Detect Cycle

1. Initialize `slow` and `fast` at the head.
2. Move `slow` one step.
3. Move `fast` two steps.
4. If `slow == fast`, a cycle exists.
5. If `fast` reaches `null`, there is no cycle.

#### Phase 2 — Find Cycle Start

1. Reset `slow` to `head`.
2. Keep `fast` at the meeting point.
3. Move both `slow` and `fast` one step at a time.
4. When `slow == fast`, that node is the cycle start.
5. Return that node.

### Why It Works

The first meeting only proves that a cycle exists.

The meeting point itself is not necessarily the cycle start.

After resetting `slow` to the head, both pointers are positioned so that
moving them one step at a time causes them to meet exactly at the first
node of the cycle.

### Complexity

- **Time:** O(n)
- **Space:** O(1)

### Status

✅ Completed