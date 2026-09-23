/*
 * Approach: Fast & Slow Pointers
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class _02_FastSlowPointers {

    static Node deleteMiddle(Node head) {

        if (head == null || head.next == null) {
            return null;
        }

        Node dummy = new Node(0);
        dummy.next = head;

        Node slow = dummy;
        Node fast = dummy;

        // Move slow one step and fast two steps
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is just before the middle node
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(6);

        Node curr = deleteMiddle(head);

        while (curr != null) {
            System.out.print(curr.data);

            curr = curr.next;

            if (curr != null) {
                System.out.print(" -> ");
            }
        }

        // Expected Output:
        // 1 -> 3 -> 4 -> 1 -> 2 -> 6
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