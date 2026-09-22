/*
 * P009 — Remove Nth Node From End of List
 * LeetCode #19
 * Approach 02 — Two Pass
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class _02_TwoPass {

    static Node remove(Node head, int n) {

        // Pass 1: Find the length of the linked list.
        int length = 0;
        Node curr = head;

        while (curr != null) {
            length++;
            curr = curr.next;
        }

        // If the head itself must be removed.
        if (n == length) {
            return head.next;
        }

        // Convert nth from end to index from beginning.
        int index = length - n;

        // Pass 2: Reach the node before the target.
        curr = head;

        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }

        // Remove the target node.
        curr.next = curr.next.next;

        return head;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int n = 2;

        Node curr = remove(head, n);

        System.out.print("Updated list: ");

        while (curr != null) {
            System.out.print(curr.data);

            curr = curr.next;

            if (curr != null) {
                System.out.print(" -> ");
            }
        }

        // Output:
        // Updated list: 1 -> 2 -> 3 -> 5
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