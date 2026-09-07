## Approach 01 — Count Nodes + Traverse Again — Time: O(n), Space: O(1)

### Idea

First count the total number of nodes in the linked list.

Then calculate the middle position using `count / 2`.

Reset the pointer to the head and traverse to that position.

For an even-length list, `count / 2` naturally gives the second
middle node.

### Steps

1. Traverse the entire linked list and count the nodes.
2. Calculate the middle position using `count / 2`.
3. Reset the pointer to `head`.
4. Move the pointer `count / 2` times.
5. Return the node reached.

### Why It Works

For an odd-length list, `count / 2` points to the middle node.

For an even-length list, integer division makes `count / 2` point to
the second middle node, which is exactly what the problem requires.

### Complexity

- **Time:** O(n)
- **Space:** O(1)

### Status

✅ Completed

## Approach 02 — Fast & Slow Pointers — Time: O(n), Space: O(1)

### Idea

Use two pointers that move through the linked list at different speeds.

- `slow` moves one step at a time.
- `fast` moves two steps at a time.

When `fast` reaches the end of the list, `slow` will be at the middle.

For an even-length list, `slow` reaches the second middle node.

### Steps

1. Initialize `slow` and `fast` at `head`.
2. Move `slow` one step.
3. Move `fast` two steps.
4. Continue while `fast` and `fast.next` are not `null`.
5. When the loop ends, return `slow`.

### Why It Works

The fast pointer moves twice as quickly as the slow pointer.

Therefore, when `fast` reaches the end, `slow` has traveled approximately
half the distance.

For an even-length list, the loop condition causes `slow` to stop at the
second middle node.

### Complexity

- **Time:** O(n)
- **Space:** O(1)

### Status

✅ Completed