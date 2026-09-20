/*
 * P006 — Palindrome Linked List
 * LeetCode #234
 * Approach 01 — ArrayList
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.ArrayList;
import java.util.List;

public class _01_ArrayList {

    static boolean palindrome(Node head) {

        List<Integer> list = new ArrayList<>();

        Node curr = head;

        // Store all linked list values.
        while (curr != null) {
            list.add(curr.data);
            curr = curr.next;
        }

        int left = 0;
        int right = list.size() - 1;

        // Compare values from both ends.
        while (left < right) {

            if (list.get(left).equals(list.get(right))) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);

        boolean isPalindrome = palindrome(head);

        System.out.println("Is palindrome: " + isPalindrome);

        // Output:
        // Is palindrome: true
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