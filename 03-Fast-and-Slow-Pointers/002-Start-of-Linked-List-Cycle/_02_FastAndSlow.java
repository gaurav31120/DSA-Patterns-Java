// Approach 02: Fast & Slow Pointers + Reset
// Time: O(n)
// Space: O(1)

public class _02_FastAndSlow {

    static Node startOfLL(Node head) {

        Node slow = head;
        Node fast = head;

        boolean cycleFound = false;

        // Phase 1: Detect cycle
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                cycleFound = true;
                break;
            }
        }

        if (!cycleFound) {
            return null;
        }

        // Phase 2: Find cycle start
        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
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

        // Create cycle: 6 -> 3
        head.next.next.next.next.next.next = head.next.next;

        Node loopNode = startOfLL(head);

        if (loopNode != null) {
            System.out.println("Cycle starts at: " + loopNode.data);
        } else {
            System.out.println("No cycle");
        }
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