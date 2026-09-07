// Approach 02: Fast & Slow Pointers
// Time: O(n)
// Space: O(1)

public class _02_FastAndSlow {

    static Node middleNode(Node head) {

        // Slow moves 1 step, fast moves 2 steps.
        Node slow = head;
        Node fast = head;

        // When fast ends, slow is at the middle.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {

        Node head = new Node(1);

        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        Node midNode = middleNode(head);

        System.out.println(midNode.data);
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