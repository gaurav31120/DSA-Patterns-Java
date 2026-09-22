/*
 * P007 — Rearrange a LinkedList
 * LeetCode #143
 * Approach 01 — ArrayList
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.ArrayList;
import java.util.List;

public class _01_ArrayList {

    static Node rearrange(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node curr = head;
        List<Node> list = new ArrayList<>();

        // Store all nodes in an ArrayList.
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }

        Node prev = list.get(0);

        int left = 1;
        int right = list.size() - 1;

        // Connect last, first, second-last, second, ...
        while (left < right) {

            prev.next = list.get(right);
            prev = prev.next;
            right--;

            prev.next = list.get(left);
            prev = prev.next;
            left++;
        }

        // Connect the remaining middle node for odd-length lists.
        if (left <= right) {
            prev.next = list.get(right);
            prev = prev.next;
        }

        // Important: terminate the linked list.
        prev.next = null;

        return head;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

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
        // Rearranged list: 1 -> 4 -> 2 -> 3
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