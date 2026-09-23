/*
 * Approach: Fast & Slow Pointers
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class _02_FastSlowPointers {

    static Node swapNodes(Node head, int k) {

        // Find kth node from beginning
        Node first = head;

        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        // Find kth node from end
        Node slow = head;
        Node fast = first;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        Node second = slow;

        // Swap values
        int temp = first.data;
        first.data = second.data;
        second.data = temp;

        return head;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int k = 2;

        Node curr = swapNodes(head, k);

        while (curr != null) {
            System.out.print(curr.data);

            curr = curr.next;

            if (curr != null) {
                System.out.print(" -> ");
            }
        }

        // Expected Output:
        // 1 -> 4 -> 3 -> 2 -> 5
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