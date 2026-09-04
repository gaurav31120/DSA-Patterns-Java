import java.util.HashSet;
import java.util.Set;

// Approach 2: HashSet
// Time: O(n)
// Space: O(n)

public class _02_HashSet {

    public static int removeDuplicates(int[] arr) {

        Set<Integer> seen = new HashSet<>();

        int j = 0;

        for (int i = 0; i < arr.length; i++) {

            if (seen.add(arr[i])) {
                arr[j] = arr[i];
                j++;
            }
        }

        return j;
    }

    public static void main(String[] args) {

        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int uniqueElements = removeDuplicates(arr);

        System.out.println(uniqueElements);
    }
}