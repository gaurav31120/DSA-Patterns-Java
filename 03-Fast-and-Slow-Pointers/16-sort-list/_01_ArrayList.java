/*
 * Approach: ArrayList + Sorting
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _01_ArrayList {

    static Node sortList(Node head) {

        List<Integer> values = new ArrayList<>();

        // Store all values
        Node curr = head;

        while (curr != null) {
            values.add(curr.data);
            curr = curr.next;
        }

        // Sort values
        Collections.sort(values);

        // Write sorted values back
        curr = head;

        for (int i = 0; i < values.size(); i++) {
            curr.data = values.get(i);
            curr = curr.next;
        }

        return head;
    }

    public static void main(String[] args) {

        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);

        Node curr = sortList(head);

        System.out.print("Sorted list: ");

        while (curr != null) {

            System.out.print(curr.data);

            curr = curr.next;

            if (curr != null) {
                System.out.print(" -> ");
            }
        }

        // Expected Output:
        // Sorted list: 1 -> 2 -> 3 -> 4
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