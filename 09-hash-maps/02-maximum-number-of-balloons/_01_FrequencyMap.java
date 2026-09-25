// Time: O(n)
// Space: O(k)

import java.util.HashMap;
import java.util.Map;

public class _01_FrequencyMap {

    // static int maxBalloons(String text) {
    //     String balloon = "balloon";

    //     Map<Character, Integer> map = new HashMap<>();

    //     for (int i = 0; i < text.length(); i++) {
    //         char ch = text.charAt(i);
    //         if (map.containsKey(ch)) {
    //             int count = map.get(ch);
    //             map.put(ch, count + 1);
    //         } else {
    //             map.put(ch, 1);
    //         }
    //     }

    //     int maxBalloons = text.length() / balloon.length();

    //     int balloonCount = 0;

    //     for (int i = 0; i < maxBalloons; i++) {
    //         for (int j = 0; j < text.length(); i++) {
    //             char bal = balloon.charAt(j);
    //             int count = map.get(bal);

    //             if(count> 0) {
    //                 map.put(bal, count - 1);
    //             }
    //             else {
    //                 return balloonCount;
    //             }
    //         }
    //         balloonCount++;
    //     }
    //     return balloonCount;

    // }


    static int maxBalloons(String text) {

        Map<Character, Integer> freq = new HashMap<>();

        // Count characters
        for (char ch : text.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        int b = freq.getOrDefault('b', 0);
        int a = freq.getOrDefault('a', 0);
        int l = freq.getOrDefault('l', 0) / 2;
        int o = freq.getOrDefault('o', 0) / 2;
        int n = freq.getOrDefault('n', 0);

        return Math.min(Math.min(b, a), Math.min(Math.min(l, o), n));
    }

    public static void main(String[] args) {

        String text = "loonbalxballpoon";

        int result = maxBalloons(text);

        System.out.println("Maximum balloons: " + result);

        // Expected Output:
        // Maximum balloons: 2
    }
}