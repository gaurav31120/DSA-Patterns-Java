// Approach 02: Two Pointers
// Time: O(n)
// Space: O(1)

public class _02_TwoPointers {

    static int maxArea(int[] arr) {

        int left = 0;
        int right = arr.length - 1;
        int maxArea = 0;

        // Start with the widest container.
        while (left < right) {

            int width = right - left;
            int height = Math.min(arr[left], arr[right]);

            int area = width * height;

            // Update maximum area.
            if (area > maxArea) {
                maxArea = area;
            }

            // Move the shorter line.
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int maxArea = maxArea(arr);

        System.out.println("Maximum water: " + maxArea);
    }
}

// Output:
// Maximum water: 49