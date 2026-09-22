/*
 * Approach: ArrayList
 * Time Complexity: O(n * m)
 * Space Complexity: O(n)
 */

import java.util.ArrayList;
import java.util.List;

public class _01_ArrayList {

    static Node intersection(Node headA, Node headB) {

        List<Node> listA = new ArrayList<>();

        Node currA = headA;
        Node currB = headB;

        while (currA != null) {
            listA.add(currA);
            currA = currA.next;
        }

        while (currB != null) {

            if (listA.contains(currB)) {
                return currB;
            }

            currB = currB.next;
        }

        return null;
    }

    public static void main(String[] args) {

        Node headA = new Node(1);
        headA.next = new Node(2);
        headA.next.next = new Node(3);

        Node headB = new Node(4);
        headB.next = new Node(5);

        // Common intersection nodes
        Node intersection = new Node(6);
        intersection.next = new Node(7);

        headA.next.next.next = intersection;
        headB.next.next = intersection;

        Node curr = intersection(headA, headB);

        System.out.print("Intersection nodes: ");

        while (curr != null) {
            System.out.print(curr.data);

            curr = curr.next;

            if (curr != null) {
                System.out.print(" -> ");
            }
        }

        // Expected Output:
        // Intersection nodes: 6 -> 7
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