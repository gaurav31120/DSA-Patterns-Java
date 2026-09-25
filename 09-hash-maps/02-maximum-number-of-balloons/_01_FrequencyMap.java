import java.util.HashMap;
import java.util.Map;

public class _01_FrequencyMap {

    static int maxBalloons(String text) {
        String balloon = "balloon";

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (map.containsKey(ch)) {
                int count = map.get(ch);
                map.put(ch, count + 1);
            } else {
                map.put(ch, 1);
            }
        }

        int maxBalloons = text.length() / balloon.length();

        int balloonCount = 0;

        for (int i = 0; i < maxBalloons; i++) {
            for (int j = 0; j < balloon.length(); j++) {
                char bal = balloon.charAt(j);

                int count = map.getOrDefault(bal, 0);

                if (count > 0) {
                    map.put(bal, count - 1);
                } else {
                    return balloonCount;
                }
            }
            balloonCount++;
        }
        return balloonCount;

    }

    public static void main(String[] args) {

        String text = "nlaebolko";

        int result = maxBalloons(text);
        System.out.println(result);
    }

}
