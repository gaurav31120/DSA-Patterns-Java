/*
 * Approach: Two Pass
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class _01_TwoPass {

    static Node deleteMiddle(Node head) {

        if (head == null || head.next == null) {
            return null;
        }

        // First pass: find length
        int len = 0;
        Node curr = head;

        while (curr != null) {
            len++;
            curr = curr.next;
        }

        // Middle index
        int middleIndex = len / 2;

        // Second pass: reach node before middle
        curr = head;

        for (int i = 0; i < middleIndex - 1; i++) {
            curr = curr.next;
        }

        // Delete middle node
        curr.next = curr.next.next;

        return head;
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