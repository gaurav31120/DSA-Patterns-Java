// Time Complexity: O(n)
// Space Complexity: O(1)

public class _02_CountArray {

    static int maxBalloons(String text) {

        // Create frequency array for lowercase English letters
        int[] characterFrequency = new int[26];

        // Count frequency of every character
        for (char currentCharacter : text.toCharArray()) {
            characterFrequency[currentCharacter - 'a']++;
        }

        // Calculate how many balloons each required character can make
        int bFrequency = characterFrequency['b' - 'a'];
        int aFrequency = characterFrequency['a' - 'a'];
        int lFrequency = characterFrequency['l' - 'a'] / 2;
        int oFrequency = characterFrequency['o' - 'a'] / 2;
        int nFrequency = characterFrequency['n' - 'a'];

        // The character with the smallest available count limits the answer
        int maximumBalloons = bFrequency;

        maximumBalloons = Math.min(maximumBalloons, aFrequency);
        maximumBalloons = Math.min(maximumBalloons, lFrequency);
        maximumBalloons = Math.min(maximumBalloons, oFrequency);
        maximumBalloons = Math.min(maximumBalloons, nFrequency);

        return maximumBalloons;
    }

    public static void main(String[] args) {

        String text = "loonbalxballpoon";

        int result = maxBalloons(text);

        System.out.println("Maximum balloons: " + result);

        // Expected Output:
        // Maximum balloons: 2
    }
}