
public class _01_BruteForce {

    static int smallerSubarray(int[] arr, int target) {

        int n = arr.length;
        int ws = 0;
        int sum = 0;
        int minWs = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum = 0;
            ws = 0;
            for (int j = i; j < n; j++) {
                sum = sum + arr[j];
                if (sum >= target) {

                    ws = j - i + 1;
                    break;
                }
            }
            if (ws < minWs) {
                minWs = ws;
            }

        }
        return minWs;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 2, 3, 2 };
        int target = 7;

        int ws = smallerSubarray(arr, target);
        System.out.println(ws);
    }

}
