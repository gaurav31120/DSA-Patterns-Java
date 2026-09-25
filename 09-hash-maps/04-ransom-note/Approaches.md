# P004 — Ransom Note

## Approach 01 — Frequency Map

### Idea

Use a `HashMap<Character, Integer>` to store how many times each character
is available in `magazine`.

Then traverse `ransomNote`.

For every required character:

- Check how many copies are available.
- If the count is `0`, return `false`.
- Otherwise, use one copy and decrease the count.

If every character in `ransomNote` is successfully processed, return `true`.

### Example

ransomNote:

    "aa"

magazine:

    "aab"

Frequency map:

    a → 2
    b → 1

Process ransomNote:

    first 'a' → available 2 → use one → remaining 1
    second 'a' → available 1 → use one → remaining 0

All required characters are available.

Result:

    true

### Important Java Point

`HashMap.get(key)` returns `null` when the key does not exist.

Therefore, use:

    map.getOrDefault(character, 0)

when a missing character should be treated as frequency `0`.

### Java Implementation

    // Time Complexity: O(n + m)
    // Space Complexity: O(k)

    import java.util.HashMap;
    import java.util.Map;

    public class _01_FrequencyMap {

        static boolean canConstruct(
                String ransomNote,
                String magazine) {

            Map<Character, Integer> availableCharacterFrequency =
                    new HashMap<>();

            // Count characters available in magazine
            for (char currentCharacter : magazine.toCharArray()) {

                int currentFrequency =
                        availableCharacterFrequency.getOrDefault(
                                currentCharacter,
                                0
                        );

                availableCharacterFrequency.put(
                        currentCharacter,
                        currentFrequency + 1
                );
            }

            // Check characters required by ransomNote
            for (char requiredCharacter : ransomNote.toCharArray()) {

                int availableCount =
                        availableCharacterFrequency.getOrDefault(
                                requiredCharacter,
                                0
                        );

                if (availableCount == 0) {
                    return false;
                }

                availableCharacterFrequency.put(
                        requiredCharacter,
                        availableCount - 1
                );
            }

            return true;
        }

        public static void main(String[] args) {

            String ransomNote = "aa";
            String magazine = "aab";

            boolean result = canConstruct(
                    ransomNote,
                    magazine
            );

            System.out.println(
                    "Can construct ransom note: " + result
            );

            // Expected Output:
            // Can construct ransom note: true
        }
    }

### Complexity

- Time Complexity: O(n + m)
- Space Complexity: O(k)

where:

- `n` = length of `magazine`
- `m` = length of `ransomNote`
- `k` = number of distinct characters

### Key Learning

The important HashMap pattern is:

    available resource → frequency

Then consume the frequency as the resource is used.

For missing keys:

    getOrDefault(key, 0)