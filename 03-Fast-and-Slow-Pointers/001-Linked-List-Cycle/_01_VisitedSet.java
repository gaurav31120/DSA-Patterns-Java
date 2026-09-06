// Approach 01: Visited Set
// Time: O(n)
// Space: O(n)

import java.util.HashSet;

class Node {

    int data;
    Node next;

    Node(int val) {
        this.data = val;
        this.next = null;
    }
}

public class _01_VisitedSet {

    public static boolean detectLoop(Node head) {

        HashSet<Node> set = new HashSet<>();

        Node current = head;

        while (current != null) {

            if (set.contains(current)) {
                return true;
            }

            set.add(current);
            current = current.next;
        }

        return false;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(4);
        head.next.next.next = head.next;

        boolean isLoop = detectLoop(head);

        System.out.print(isLoop);
    }
}