// Approach 01: Count Nodes + Traverse Again
// Time: O(n)
// Space: O(1)

public class _01_CountNodes {

    static Node middleNode(Node head) {

        Node curr = head;
        int count = 0;

        // Count nodes
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        // Find middle position
        int midCount = count / 2;

        // Reset to head
        curr = head;

        // Move to middle
        while (midCount > 0) {
            curr = curr.next;
            midCount--;
        }

        return curr;
    }

    public static void main(String[] args) {

        Node head = new Node(1);

        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        Node midNode = middleNode(head);

        System.out.println(midNode.data);
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