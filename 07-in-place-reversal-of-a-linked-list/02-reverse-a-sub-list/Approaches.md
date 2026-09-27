# P002 — Reverse a Sub-list

## Approach 01 — Iterative Pointer Reversal

### Idea

Reverse only the part of the linked list between `left` and `right`.

For example:

    1 → 2 → 3 → 4 → 5

If:

    left = 2
    right = 4

Reverse:

    2 → 3 → 4

to:

    4 → 3 → 2

Final list:

    1 → 4 → 3 → 2 → 5

### Steps

1. Create a dummy node before the head.
2. Move `first` to the node just before `left`.
3. Set `prev` to the first node that needs to be reversed.
4. Set `curr` to the next node.
5. Reverse the required part using the same pointer-reversal technique
   learned in P001.
6. Connect the reversed part back to the remaining list.

### Example

Original:

    1 → 2 → 3 → 4 → 5

For:

    left = 2
    right = 4

The part to reverse is:

    2 → 3 → 4

After reversal:

    4 → 3 → 2

Connect it back:

    1 → 4 → 3 → 2 → 5

### Important Pointer Logic

During reversal:

    Node next = curr.next;
    curr.next = prev;
    prev = curr;
    curr = next;

After the reversal, reconnect:

    first.next.next = curr;
    first.next = prev;

### Java Implementation

    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public class _01_Iterative {

        static Node reverseBetween(Node head, int left, int right) {

            Node dummy = new Node(0);
            dummy.next = head;

            // Move first to the node before left
            Node first = dummy;

            for (int i = 1; i < left; i++) {
                first = first.next;
            }

            // Start reversing from left
            Node prev = first.next;
            Node curr = prev.next;

            for (int i = 0; i < right - left; i++) {

                Node next = curr.next;

                curr.next = prev;

                prev = curr;
                curr = next;
            }

            // Connect reversed part back
            first.next.next = curr;
            first.next = prev;

            return dummy.next;
        }

        public static void main(String[] args) {

            Node head = new Node(1);
            head.next = new Node(2);
            head.next.next = new Node(3);
            head.next.next.next = new Node(4);
            head.next.next.next.next = new Node(5);

            int left = 2;
            int right = 4;

            Node result = reverseBetween(head, left, right);

            while (result != null) {

                System.out.print(result.data);

                if (result.next != null) {
                    System.out.print(" -> ");
                }

                result = result.next;
            }

            System.out.println();

            // Expected Output:
            // 1 -> 4 -> 3 -> 2 -> 5
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

This approach extends the basic linked-list reversal from P001.

The important idea is:

    find the part
    → reverse only that part
    → connect it back


---

## Approach 02 — Recursive Reversal

### Idea

Use recursion to reverse the sub-list.

The recursion moves to the beginning of the portion that needs to be
reversed and reverses the nodes while returning from the recursive calls.

The nodes before `left` and after `right` remain connected to the reversed
portion.

### Example

Original:

    1 → 2 → 3 → 4 → 5

For:

    left = 2
    right = 4

Reverse:

    2 → 3 → 4

to:

    4 → 3 → 2

Final:

    1 → 4 → 3 → 2 → 5

### Main Idea

First recursively move until the beginning of the sub-list.

Once the reversal starts, use:

    head.next.next = head;

to reverse the current connection.

Then:

    head.next = null;

to remove the old forward connection.

The new head of the reversed portion is returned through recursion.

### Important Point

There are two parts to handle:

    1. Reach the `left` position.
    2. Reverse nodes until the `right` position.

This makes the recursive solution more difficult to understand than the
iterative solution.

### Java Implementation

    // Time Complexity: O(n)
    // Space Complexity: O(n) because of recursion stack

    public class _02_Recursive {

        static Node reverseBetween(Node head, int left, int right) {

            if (head == null || left == right) {
                return head;
            }

            // Move to the left position
            if (left > 1) {
                head.next = reverseBetween(
                        head.next,
                        left - 1,
                        right - 1
                );

                return head;
            }

            // left == 1, start reversing
            Node curr = head;
            Node prev = null;

            for (int i = 0; i <= right - left; i++) {

                Node next = curr.next;

                curr.next = prev;

                prev = curr;
                curr = next;
            }

            head.next = curr;

            return prev;
        }

        public static void main(String[] args) {

            Node head = new Node(1);
            head.next = new Node(2);
            head.next.next = new Node(3);
            head.next.next.next = new Node(4);
            head.next.next.next.next = new Node(5);

            int left = 2;
            int right = 4;

            Node result = reverseBetween(head, left, right);

            while (result != null) {

                System.out.print(result.data);

                if (result.next != null) {
                    System.out.print(" -> ");
                }

                result = result.next;
            }

            System.out.println();

            // Expected Output:
            // 1 -> 4 -> 3 -> 2 -> 5
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

The additional space comes from the recursion call stack.

### Key Learning

Recursive linked-list problems often follow:

    move recursively
    → perform pointer change
    → return the new head

For sub-list reversal, recursion is mainly useful for understanding how
the reversal can be combined with recursive traversal.