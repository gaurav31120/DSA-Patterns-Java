/*
 * P007 — Rearrange a LinkedList
 * LeetCode #143
 * Approach 02 — Fast & Slow + Reverse + Merge
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class _02_FastSlowReverseMerge {

    static Node rearrange(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle of the linked list.
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Save the second half and split the list.
        Node secondHalf = slow.next;
        slow.next = null;

        // Reverse the second half.
        Node prev = null;
        Node curr = secondHalf;

        while (curr != null) {
            Node next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // prev is now the head of the reversed second half.
        Node first = head;
        Node second = prev;

        // Merge the two halves alternately.
        while (second != null) {

            Node firstNext = first.next;
            Node secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }

        return head;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node curr = rearrange(head);

        System.out.print("Rearranged list: ");

        while (curr != null) {

            System.out.print(curr.data);

            curr = curr.next;

            if (curr != null) {
                System.out.print(" -> ");
            }
        }

        // Output:
        // Rearranged list: 1 -> 5 -> 2 -> 4 -> 3
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