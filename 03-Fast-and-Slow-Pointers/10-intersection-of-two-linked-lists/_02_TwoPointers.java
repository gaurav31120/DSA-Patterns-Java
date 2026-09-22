/*
 * Approach: Two Pointers - Length Difference Alignment
 * Time Complexity: O(n + m)
 * Space Complexity: O(1)
 */

public class _02_TwoPointers {

    static Node intersection(Node headA, Node headB) {

        Node currA = headA;
        Node currB = headB;

        int m = 0;
        int n = 0;

        // Find length of List A
        while (currA != null) {
            currA = currA.next;
            m++;
        }

        // Find length of List B
        while (currB != null) {
            currB = currB.next;
            n++;
        }

        // Reset pointers
        currA = headA;
        currB = headB;

        // Align both pointers
        if (m > n) {

            int skipA = m - n;

            for (int i = 0; i < skipA; i++) {
                currA = currA.next;
            }

        } else {

            int skipB = n - m;

            for (int i = 0; i < skipB; i++) {
                currB = currB.next;
            }
        }

        // Find intersection
        while (currA != null) {

            if (currA == currB) {
                return currA;
            }

            currA = currA.next;
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