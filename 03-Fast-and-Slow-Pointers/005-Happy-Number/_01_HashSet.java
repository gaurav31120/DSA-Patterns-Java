import java.util.HashSet;

// Approach 01: HashSet
// Time: O(k)
// Space: O(k)

public class _01_HashSet {

    static boolean isHappy(int num) {

        HashSet<Integer> set = new HashSet<>();
        int n = num;

        while (n != 1) {

            // Repeated value means a cycle.
            if (set.contains(n)) {
                return false;
            }

            set.add(n);

            int sum = 0;

            // Calculate sum of squared digits.
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }

            n = sum;
        }

        return true;
    }

    public static void main(String[] args) {

        int num = 19;

        boolean isHappy = isHappy(num);

        System.out.println("Is happy: " + isHappy);
    }
}