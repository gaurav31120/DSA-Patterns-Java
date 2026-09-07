// Approach 03: Fast & Slow Pointers
// Time: O(n)
// Space: O(1)

public class _03_FastAndSlow {

    static int findDuplicate(int[] arr) {

        // Start both pointers from the first value.
        int slow = arr[0];
        int fast = arr[0];

        // Find the meeting point inside the cycle.
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        // Reset slow to the start.
        slow = arr[0];

        // Move both one step to find the cycle start.
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        return slow;
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 2, 2};

        int duplicate = findDuplicate(arr);

        System.out.println("Duplicate number: " + duplicate);
    }
}