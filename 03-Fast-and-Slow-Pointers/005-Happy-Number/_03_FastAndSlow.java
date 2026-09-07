// Approach 03: Fast & Slow Pointers
// Time: O(k)
// Space: O(1)

public class _03_FastAndSlow {

    static int getNext(int n) {

        int sum = 0;

        // Calculate sum of squared digits.
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }

    static boolean isHappy(int num) {

        int slow = num;
        int fast = num;

        // Detect a cycle.
        do {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        } while (slow != fast);

        // Meeting at 1 means happy.
        return slow == 1;
    }

    public static void main(String[] args) {

        int num = 19;

        boolean isHappy = isHappy(num);

        System.out.println("Is happy: " + isHappy);
    }
}