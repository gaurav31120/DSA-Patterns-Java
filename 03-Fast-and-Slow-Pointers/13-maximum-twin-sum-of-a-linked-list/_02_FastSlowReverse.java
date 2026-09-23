/*
 * Approach: Fast & Slow Pointers + Reverse Second Half
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class _02_FastSlowReverse {

    static int maxTwinSum(Node head) {

        Node slow = head;
        Node fast = head;

        // Find the start of the second half
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half
        Node prev = null;
        Node curr = slow;

        while (curr != null) {
            Node next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Compare first half and reversed second half
        Node first = head;
        Node second = prev;

        int maxSum = Integer.MIN_VALUE;

        while (second != null) {

            int twinSum = first.data + second.data;

            maxSum = Math.max(maxSum, twinSum);

            first = first.next;
            second = second.next;
        }

        return maxSum;
    }

    public static void main(String[] args) {

        Node head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);

        int result = maxTwinSum(head);

        System.out.println("Maximum Twin Sum: " + result);

        // Expected Output:
        // Maximum Twin Sum: 6
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