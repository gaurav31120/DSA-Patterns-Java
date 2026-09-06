## Approach 01 — Visited Set — Time: O(n), Space: O(n)

### Idea

Traverse the linked list while storing every visited node in a
`HashSet`.

If the same node is encountered again, the linked list contains a
cycle.

### Steps

1. Create a `HashSet<Node>`.
2. Start traversing from the head.
3. For every node, check whether it already exists in the set.
4. If it exists, return `true` because a cycle is present.
5. Otherwise, add the node to the set.
6. Move to the next node.
7. If the traversal reaches `null`, return `false`.

### Why It Works

A linked list without a cycle eventually reaches `null`.

If a cycle exists, traversal eventually reaches a node that was
already visited. The `HashSet` detects this repeated node.

We store the **node reference**, not its value, because different
nodes can contain the same value.

### Complexity

* **Time:** O(n)
* **Space:** O(n)

### Status

✅ Completed


// Approach 02: Fast & Slow Pointers
// Time: O(n)
// Space: O(1)

public class _02_FastAndSlow {

    public static boolean detectLoop(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = head.next;

        boolean isLoop = detectLoop(head);

        System.out.println(isLoop);
    }
}