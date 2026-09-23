/*
 * Approach: ArrayList
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.ArrayList;
import java.util.List;

public class _01_ArrayList {

    static int maxTwinSum(Node head) {

        List<Integer> values = new ArrayList<>();

        Node curr = head;

        // Store all node values
        while (curr != null) {
            values.add(curr.data);
            curr = curr.next;
        }

        int left = 0;
        int right = values.size() - 1;
        int maxTwinSum = Integer.MIN_VALUE;

        // Calculate twin sums
        while (left < right) {

            int twinSum = values.get(left) + values.get(right);

            maxTwinSum = Math.max(maxTwinSum, twinSum);

            left++;
            right--;
        }

        return maxTwinSum;
    }

    public static void main(String[] args) {

        Node head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);

        int result = maxTwinSum(head);

        System.out.println("Maximum Twin Sum: " + result);

        // Expected Output:
        // Maximum Twin Sum: 6
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