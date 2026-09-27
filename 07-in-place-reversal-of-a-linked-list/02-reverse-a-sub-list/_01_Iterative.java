// Time Complexity: O(n)
// Space Complexity: O(1)

public class _01_Iterative {

    static Node reverseBetween(Node head, int left, int right) {

        Node dummy = new Node(0);
        dummy.next = head;

        // Find the node before the sub-list
        Node before = dummy;

        for (int i = 1; i < left; i++) {
            before = before.next;
        }

        // Reverse the required part
        Node prev = before.next;
        Node curr = prev.next;

        for (int i = 0; i < right - left; i++) {

            Node next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        // Connect the reversed part back
        before.next.next = curr;
        before.next = prev;

        return dummy.next;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int left = 2;
        int right = 4;

        Node result = reverseBetween(head, left, right);

        while (result != null) {

            System.out.print(result.data);

            if (result.next != null) {
                System.out.print(" -> ");
            }

            result = result.next;
        }

        System.out.println();

        // Expected Output:
        // 1 -> 4 -> 3 -> 2 -> 5
    }
}

class Node {

    int data;
    Node next;

    Node(int value) {
        this.data = value;
        this.next = null;
    }
}