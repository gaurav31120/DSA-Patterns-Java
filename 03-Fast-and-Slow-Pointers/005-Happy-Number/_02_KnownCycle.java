// Approach 02: Known Cycle
// Time: O(k)
// Space: O(1)

public class _02_KnownCycle {

    static boolean isHappy(int num) {

        int n = num;

        while (n != 1 && n != 4) {

            int sum = 0;

            // Calculate sum of squared digits.
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }

            n = sum;
        }

        // 1 means happy, 4 means unhappy.
        return n == 1;
    }

    public static void main(String[] args) {

        int num = 19;

        boolean isHappy = isHappy(num);

        System.out.println("Is happy: " + isHappy);
    }
}