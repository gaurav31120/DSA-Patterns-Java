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
}

class Node {

    int data;
    Node next;

    Node(int val) {
        this.data = val;
        this.next = null;
    }
}