// Approach 01: Nested Loops
// Time: O(n²)
// Space: O(1)

public class _01_NestedLoops {

    static int maxArea(int[] arr) {

        int maxArea = 0;

        // Check every pair of lines.
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                int width = j - i;
                int height = Math.min(arr[i], arr[j]);

                int area = width * height;

                // Update maximum area.
                if (area > maxArea) {
                    maxArea = area;
                }
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