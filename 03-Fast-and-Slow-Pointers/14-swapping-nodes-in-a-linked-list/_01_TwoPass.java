/*
 * Approach: Two Pass
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class _01_TwoPass {

    static Node swapNodes(Node head, int k) {

        // Find length
        int len = 0;
        Node curr = head;

        while (curr != null) {
            len++;
            curr = curr.next;
        }

        // Find kth node from beginning
        Node first = head;

        for (int i = 0; i < k - 1; i++) {
            first = first.next;
        }

        // Find kth node from end
        Node second = head;

        for (int i = 0; i < len - k; i++) {
            second = second.next;
        }

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