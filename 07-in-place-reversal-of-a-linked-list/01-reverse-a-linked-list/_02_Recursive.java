// Time Complexity: O(n)
// Space Complexity: O(n) because of the recursion call stack

public class _02_Recursive {

    static Node reverse(Node head) {

        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // Reverse the rest of the linked list
        Node newHead = reverse(head.next);

        // Put current node after its next node
        head.next.next = head;

        // Break the old forward connection
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node result = reverse(head);

        while (result != null) {

            System.out.print(result.data);

            if (result.next != null) {
                System.out.print(" -> ");
            }

            result = result.next;
        }

        System.out.println();

        // Expected Output:
        // 5 -> 4 -> 3 -> 2 -> 1
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