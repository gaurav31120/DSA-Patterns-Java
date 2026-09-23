/*
 * Approach: In-Place Two Pointers
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class _02_TwoPointers {

    static Node oddEvenList(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        while (even != null && even.next != null) {

            odd.next = odd.next.next;
            odd = odd.next;

            even.next = even.next.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node curr = oddEvenList(head);

        System.out.print("Odd-Even list: ");

        while (curr != null) {
            System.out.print(curr.data);

            curr = curr.next;

            if (curr != null) {
                System.out.print(" -> ");
            }
        }

        // Expected Output:
        // Odd-Even list: 1 -> 3 -> 5 -> 2 -> 4
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