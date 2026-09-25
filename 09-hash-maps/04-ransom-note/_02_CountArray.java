// Time Complexity: O(n + m)
// Space Complexity: O(1)

public class _02_CountArray {

    static boolean canConstruct(String ransomNote, String magazine) {

        int[] characterFrequency = new int[26];

        // Count characters available in magazine
        for (char ch : magazine.toCharArray()) {
            characterFrequency[ch - 'a']++;
        }

        // Use characters required by ransomNote
        for (char ch : ransomNote.toCharArray()) {

            int availableCount = characterFrequency[ch - 'a'];

            if (availableCount == 0) {
                return false;
            }

            characterFrequency[ch - 'a']--;
        }

        return true;
    }

    public static void main(String[] args) {

        String ransomNote = "aa";
        String magazine = "aab";

        boolean result = canConstruct(ransomNote, magazine);

        System.out.println("Can construct ransom note: " + result);

        // Expected Output:
        // Can construct ransom note: true
    }
}