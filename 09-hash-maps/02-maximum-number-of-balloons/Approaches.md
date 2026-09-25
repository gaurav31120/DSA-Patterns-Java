# P002 — Maximum Number of Balloons

## Approach 01 — HashMap + Minimum Required Frequency

### Idea

Count the frequency of every character using a `HashMap`.

The word `balloon` requires:

    b → 1
    a → 1
    l → 2
    o → 2
    n → 1

Therefore:

    balloons from b = count(b)
    balloons from a = count(a)
    balloons from l = count(l) / 2
    balloons from o = count(o) / 2
    balloons from n = count(n)

The character that supports the fewest complete `balloon` words is the limiting character.

So the answer is the minimum of these five values.

### Example

Input:

    "loonbalxballpoon"

Relevant frequencies:

    b = 2
    a = 2
    l = 4
    o = 4
    n = 2

Possible balloons:

    b → 2
    a → 2
    l → 4 / 2 = 2
    o → 4 / 2 = 2
    n → 2

Answer:

    2

### Java Implementation

    import java.util.*;

    public class _01_FrequencyMap {

        // Time: O(n)
        // Space: O(k)

        static int maxBalloons(String text) {

            Map<Character, Integer> freq = new HashMap<>();

            // Count character frequencies
            for (char ch : text.toCharArray()) {
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            }

            int b = freq.getOrDefault('b', 0);
            int a = freq.getOrDefault('a', 0);
            int l = freq.getOrDefault('l', 0) / 2;
            int o = freq.getOrDefault('o', 0) / 2;
            int n = freq.getOrDefault('n', 0);

            return Math.min(
                    Math.min(b, a),
                    Math.min(
                            Math.min(l, o),
                            n
                    )
            );
        }
    }

### Complexity

- Time: O(n)
- Space: O(k)

where `k` is the number of distinct characters.

### Key Learning

When a target word must be constructed multiple times:

    1. Count available characters.
    2. Determine how many target words each required character can support.
    3. Take the minimum.

Repeated characters in the target must be divided accordingly.

For `balloon`:

    l → count / 2
    o → count / 2

---

## Approach 02 — Count Array + Minimum Required Frequency

### Idea

Since the required characters come from a small fixed character set, we can replace the `HashMap` with a fixed-size count array.

For lowercase English letters:

    'a' → 0
    'b' → 1
    ...
    'z' → 25

The frequency is stored using:

    freq[ch - 'a']

Then use the same minimum-frequency logic from Approach 01.

### Complexity

- Time: O(n)
- Space: O(1)

### Key Learning

Use a count array when the possible character/value range is small and fixed.

The algorithmic idea remains the same:

    count → calculate capacity → take minimum