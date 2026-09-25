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
# P002 — Maximum Number of Balloons

## Approach 01 — Frequency Map

### Idea

Count the frequency of each character using a `HashMap`.

The word `balloon` requires:

    b → 1
    a → 1
    l → 2
    o → 2
    n → 1

So calculate how many balloons each required character can support and take the minimum.

### Complexity

- Time: O(n)
- Space: O(k)

---

## Approach 02 — Count Array

### Idea

Use a fixed-size frequency array instead of a `HashMap`.

Since the input contains lowercase English letters, use:

    int[26]

Character mapping:

    'a' → 0
    'b' → 1
    ...
    'z' → 25

The index is calculated using:

    ch - 'a'

### Steps

1. Create a frequency array of size 26.
2. Traverse the string and count each character.
3. Get the counts of `b`, `a`, `l`, `o`, and `n`.
4. Divide the counts of `l` and `o` by 2.
5. Take the minimum of all five values.

### Example

Input:

    "nlaebolko"

Relevant counts:

    b → 1
    a → 1
    l → 1
    o → 1
    n → 1

For `balloon`:

    b → 1
    a → 1
    l → 1 / 2 = 0
    o → 1 / 2 = 0
    n → 1

Therefore:

    answer = 0

### Java Implementation

    public class _02_CountArray {

        // Time: O(n)
        // Space: O(1)

        static int maxBalloons(String text) {

            int[] freq = new int[26];

            for (char ch : text.toCharArray()) {
                freq[ch - 'a']++;
            }

            int result = freq['b' - 'a'];

            result = Math.min(result, freq['a' - 'a']);
            result = Math.min(result, freq['l' - 'a'] / 2);
            result = Math.min(result, freq['o' - 'a'] / 2);
            result = Math.min(result, freq['n' - 'a']);

            return result;
        }
    }

### Complexity

- Time: O(n)
- Space: O(1)

### Key Learning

A fixed-size count array can replace a `HashMap` when the possible characters come from a small known range.

For `balloon`, `l` and `o` require two occurrences, so:

    count(l) / 2
    count(o) / 2