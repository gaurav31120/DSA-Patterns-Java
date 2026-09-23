/*
 * Approach: Length + Traversal
 * Time Complexity: O(n + k)
 * Space Complexity: O(k) for result array, O(1) auxiliary
 */

public class _02_LengthAndTraversal {

    static Node[] split(Node head, int k) {

        int len = 0;
        Node curr = head;

        // Find length
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        Node[] parts = new Node[k];

        int baseSize = len / k;
        int extra = len % k;

        curr = head;

        for (int i = 0; i < k; i++) {

            if (curr == null) {
                parts[i] = null;
                continue;
            }

            int partSize = baseSize + (extra > 0 ? 1 : 0);

            if (extra > 0) {
                extra--;
            }

            // Store head of current part
            parts[i] = curr;

            // Find last node of current part
            Node last = curr;

            for (int j = 1; j < partSize; j++) {
                last = last.next;
            }

            // Move to next part
            curr = last.next;

            // Disconnect current part
            last.next = null;
        }

        return parts;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next.next.next = new Node(10);

        int k = 3;

        Node[] parts = split(head, k);

        for (int i = 0; i < parts.length; i++) {

            System.out.print("Part " + (i + 1) + ": ");

            Node curr = parts[i];

            while (curr != null) {
                System.out.print(curr.data);

                curr = curr.next;

                if (curr != null) {
                    System.out.print(" -> ");
                }
            }

            System.out.println();
        }

        // Expected Output:
        // Part 1: 1 -> 2 -> 3 -> 4
        // Part 2: 5 -> 6 -> 7
        // Part 3: 8 -> 9 -> 10
    }
}

class Node {

    int data;
    Node next;

    Node(int val) {
        this.data = val;
        this.next = null;
    }
}