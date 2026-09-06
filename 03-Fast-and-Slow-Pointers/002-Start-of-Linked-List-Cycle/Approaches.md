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
