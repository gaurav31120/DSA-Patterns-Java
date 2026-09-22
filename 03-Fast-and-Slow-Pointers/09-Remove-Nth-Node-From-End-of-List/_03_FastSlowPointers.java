/*
 * Approach 03: Fast & Slow Pointers
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class _03_FastSlowPointers {

    static Node remove(Node head, int n) {

        Node dummy = new Node(0);
        dummy.next = head;

        Node slow = dummy;
        Node fast = dummy;

        // Create a gap of n nodes
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the last node
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the nth node from the end
        slow.next = slow.next.next;

        // Return the actual head
        return dummy.next;
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

        // Expected Output: Updated list: 1 -> 2 -> 3 -> 5
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