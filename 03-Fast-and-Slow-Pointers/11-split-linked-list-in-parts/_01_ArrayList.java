/*
 * Approach: ArrayList
 * Time Complexity: O(n + k)
 * Space Complexity: O(n + k)
 */

import java.util.ArrayList;
import java.util.List;

public class _01_ArrayList {

    static Node[] split(Node head, int k) {

        // Store all nodes in an ArrayList
        List<Node> nodes = new ArrayList<>();

        Node curr = head;

        while (curr != null) {
            nodes.add(curr);
            curr = curr.next;
        }

        int len = nodes.size();

        Node[] parts = new Node[k];

        int eachPartLength = len / k;
        int extra = len % k;

        int index = 0;

        for (int i = 0; i < k; i++) {

            // No nodes left
            if (index >= len) {
                parts[i] = null;
                continue;
            }

            // Size of current part
            int partSize = eachPartLength;

            if (extra > 0) {
                partSize++;
                extra--;
            }

            // Store head of current part
            parts[i] = nodes.get(index);

            // Connect nodes of current part
            for (int j = index; j < index + partSize - 1; j++) {
                nodes.get(j).next = nodes.get(j + 1);
            }

            // End current part
            nodes.get(index + partSize - 1).next = null;

            // Move to next unused node
            index += partSize;
        }

        return parts;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next.next.next = new Node(10);

        int k = 3;

        Node[] parts = split(head, k);

        for (int i = 0; i < parts.length; i++) {

            System.out.print("Part " + (i + 1) + ": ");

            Node curr = parts[i];

            while (curr != null) {

                System.out.print(curr.data);

                curr = curr.next;

                if (curr != null) {
                    System.out.print(" -> ");
                }
            }

            System.out.println();
        }

        // Expected Output:
        // Part 1: 1 -> 2 -> 3 -> 4
        // Part 2: 5 -> 6 -> 7
        // Part 3: 8 -> 9 -> 10
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