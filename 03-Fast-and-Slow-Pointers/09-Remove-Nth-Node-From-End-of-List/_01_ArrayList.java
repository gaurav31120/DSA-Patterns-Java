/*
 * P009 — Remove Nth Node From End of List
 * LeetCode #19
 * Approach 01 — ArrayList
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.ArrayList;
import java.util.List;

public class _01_ArrayList {

    static Node remove(Node head, int n) {

        Node curr = head;
        List<Node> list = new ArrayList<>();

        // Store all nodes.
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }

        // Convert nth from end to index from beginning.
        int index = list.size() - n;

        // If the head must be removed.
        if (index == 0) {
            return head.next;
        }

        curr = head;

        // Reconnect nodes while skipping the target node.
        for (int i = 1; i < list.size(); i++) {

            if (i == index) {
                continue;
            }

            curr.next = list.get(i);
            curr = curr.next;
        }

        // Terminate the list.
        curr.next = null;

        return head;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int n = 2;

        Node curr = remove(head, n);

        System.out.print("Updated list: ");

        while (curr != null) {

            System.out.print(curr.data);

            curr = curr.next;

            if (curr != null) {
                System.out.print(" -> ");
            }
        }

        // Output:
        // Updated list: 1 -> 2 -> 3 -> 5
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