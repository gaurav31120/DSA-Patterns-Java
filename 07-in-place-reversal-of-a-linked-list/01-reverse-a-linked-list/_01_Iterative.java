// Time Complexity: O(n)
// Space Complexity: O(1)

public class _01_Iterative {

    static Node reverse(Node head) {

        Node prev = null;
        Node curr = head;

        while (curr != null) {

            // Save the next node
            Node next = curr.next;

            // Reverse the current pointer
            curr.next = prev;

            // Move prev and curr forward
            prev = curr;
            curr = next;
        }

        return prev;
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