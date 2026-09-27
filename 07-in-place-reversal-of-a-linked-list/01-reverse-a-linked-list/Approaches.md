# P001 — Reverse a Linked List

## Approach 01 — Iterative Pointer Reversal

### Idea

Reverse the linked list by changing each node's `next` pointer to point to
the previous node.

Use three pointers:

    prev
    curr
    next

### Steps

1. Start `prev` as `null`.
2. Start `curr` at `head`.
3. Save `curr.next` in `next`.
4. Change `curr.next` to `prev`.
5. Move `prev` to `curr`.
6. Move `curr` to `next`.
7. Repeat until `curr` becomes `null`.
8. Return `prev` as the new head.

### Example

Before:

    1 → 2 → 3 → 4 → 5 → null

After:

    5 → 4 → 3 → 2 → 1 → null

### Important Pointer Order

Always save the next node before reversing the pointer:

    Node next = curr.next;
    curr.next = prev;

If `curr.next` is changed before saving it, the remaining part of the
linked list can be lost.

### Java Implementation

    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public class _01_Iterative {

        static Node reverse(Node head) {

            Node prev = null;
            Node curr = head;

            while (curr != null) {

                Node next = curr.next;

                curr.next = prev;

                prev = curr;
                curr = next;
            }

            return prev;
        }

        public static void main(String[] args) {

            Node head = new Node(1);
            head.next = new Node(2);
            head.next.next = new Node(3);
            head.next.next.next = new Node(4);
            head.next.next.next.next = new Node(5);

            Node result = reverse(head);

            while (result != null) {

                System.out.print(result.data);

                if (result.next != null) {
                    System.out.print(" -> ");
                }

                result = result.next;
            }

            System.out.println();

            // Expected Output:
            // 5 -> 4 -> 3 -> 2 -> 1
        }
    }

    class Node {

        int data;
        Node next;

        Node(int value) {
            this.data = value;
            this.next = null;
        }
    }

### Complexity

- Time Complexity: O(n)
- Space Complexity: O(1)

### Key Learning

The core reversal pattern is:

    save next
    reverse current pointer
    move prev
    move curr

In short:

    next = curr.next
    curr.next = prev
    prev = curr
    curr = next

-------------------------

## Approach 02 — Recursive Reversal

### Idea

First reverse the linked list starting from `head.next`.

After the remaining list is reversed, make the current node point to the
end of that reversed list.

### Steps

For:

    1 → 2 → 3 → 4 → 5

Start with:

    reverse(1)

This calls:

    reverse(2)

which calls:

    reverse(3)

and continues until the last node.

The last node is the base case.

Then the recursion starts returning.

### Base Case

If:

    head == null

or:

    head.next == null

the list is already reversed.

Return `head`.

### Important Pointer Changes

Suppose the current part is:

    1 → 2 → 3

After reversing the rest:

    3 → 2

Now:

    head = 1
    head.next = 2

Use:

    head.next.next = head

This changes:

    2 → 1

giving:

    3 → 2 → 1

Then:

    head.next = null

removes the old:

    1 → 2

connection.

### Java Implementation

    // Time Complexity: O(n)
    // Space Complexity: O(n) because of recursion call stack

    public class _02_Recursive {

        static Node reverse(Node head) {

            // Base case
            if (head == null || head.next == null) {
                return head;
            }

            // Reverse the remaining list
            Node newHead = reverse(head.next);

            // Reverse the current connection
            head.next.next = head;

            // Remove the old forward connection
            head.next = null;

            return newHead;
        }

        public static void main(String[] args) {

            Node head = new Node(1);
            head.next = new Node(2);
            head.next.next = new Node(3);
            head.next.next.next = new Node(4);
            head.next.next.next.next = new Node(5);

            Node result = reverse(head);

            while (result != null) {

                System.out.print(result.data);

                if (result.next != null) {
                    System.out.print(" -> ");
                }

                result = result.next;
            }

            System.out.println();

            // Expected Output:
            // 5 -> 4 -> 3 -> 2 -> 1
        }
    }

    class Node {

        int data;
        Node next;

        Node(int value) {
            this.data = value;
            this.next = null;
        }
    }

### Complexity

- Time Complexity: O(n)
- Space Complexity: O(n)

The `O(n)` space comes from the recursion call stack.

### Key Learning

The recursive reversal pattern is:

    reverse(head.next)
    head.next.next = head
    head.next = null

The new head returned by the deepest recursive call remains the new head
of the entire reversed list.