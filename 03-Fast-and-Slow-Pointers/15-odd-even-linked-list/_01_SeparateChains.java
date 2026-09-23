/*
 * Approach: Separate Odd and Even Chains
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class _01_SeparateChains {

    static Node oddEvenList(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node oddHead = null;
        Node oddTail = null;

        Node evenHead = null;
        Node evenTail = null;

        Node curr = head;
        int position = 1;

        while (curr != null) {

            Node next = curr.next;
            curr.next = null;

            if (position % 2 == 1) {

                if (oddHead == null) {
                    oddHead = curr;
                    oddTail = curr;
                } else {
                    oddTail.next = curr;
                    oddTail = curr;
                }

            } else {

                if (evenHead == null) {
                    evenHead = curr;
                    evenTail = curr;
                } else {
                    evenTail.next = curr;
                    evenTail = curr;
                }
            }

            curr = next;
            position++;
        }

        oddTail.next = evenHead;

        return oddHead;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node curr = oddEvenList(head);

        while (curr != null) {

            System.out.print(curr.data);

            curr = curr.next;

            if (curr != null) {
                System.out.print(" -> ");
            }
        }

        // Expected Output:
        // 1 -> 3 -> 5 -> 2 -> 4
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