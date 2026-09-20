/*
 * P006 — Palindrome Linked List
 * LeetCode #234
 * Approach 03 — Fast & Slow + Reverse Second Half
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class _03_FastSlowReverse {

    static boolean palindrome(Node head) {

        if (head == null || head.next == null) {
            return true;
        }

        Node slow = head;
        Node fast = head;

        // Find the middle of the linked list.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half.
        Node prev = null;
        Node curr = slow.next;
        Node next = curr.next;

        while (next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }

        curr.next = prev;
        slow.next = curr;

        // Compare first half with reversed second half.
        Node first = head;
        Node second = slow.next;

        while (second != null) {

            if (first.data != second.data) {
                return false;
            }

            first = first.next;
            second = second.next;
        }

        return true;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);

        boolean isPalindrome = palindrome(head);

        System.out.println("Is palindrome: " + isPalindrome);

        // Output:
        // Is palindrome: true
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