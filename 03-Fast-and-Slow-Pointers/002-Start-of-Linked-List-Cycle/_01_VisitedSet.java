// Approach 01: Visited Set
// Time: O(n)
// Space: O(n)

import java.util.HashSet;

public class _01_VisitedSet {

    static Node startOfLL(Node head) {

        HashSet<Node> set = new HashSet<>();

        Node curr = head;

        while (curr != null) {

            if (set.contains(curr)) {
                return curr;
            }

            set.add(curr);
            curr = curr.next;
        }

        return null;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.next.next.next.next.next.next = head.next.next;

        Node loopNode = startOfLL(head);

        System.out.println(loopNode.data);
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