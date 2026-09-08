# 🎯 Sliding Window Pattern

![Java](https://img.shields.io/badge/Java-17-red)

![Pattern](https://img.shields.io/badge/Pattern-Sliding%20Window-blue)

![Difficulty](https://img.shields.io/badge/Difficulty-Easy%20%7C%20Medium-green)

![Time](https://img.shields.io/badge/Time-O%5C(n%5C)-brightgreen)

![Space](https://img.shields.io/badge/Space-O%5C(1%5C)-orange)

> 📌 **Master the Sliding Window pattern to solve contiguous subarray and substring problems efficiently by expanding and shrinking a window instead of recalculating every range.**

---

# 📖 What is Sliding Window?

The **Sliding Window** pattern is used to solve problems involving a **contiguous subarray or substring**.

Instead of checking every possible subarray or substring separately, we maintain a window and move it across the input.

The window is usually controlled by two pointers:

- 👈 **Left pointer** → represents the beginning of the window.
- 👉 **Right pointer** → represents the end of the window.

The window looks like:

    left
     ↓
    [ 2  1  5  1  3  2 ]
              ↑
             right

As the window moves:

    [ 2  1  5 ]
       [ 1  5  1 ]
          [ 5  1  3 ]
             [ 1  3  2 ]

> 💡 **Goal:** Maintain a contiguous range efficiently while moving through the input.

---

# 🧠 Core Intuition

Imagine a window moving from left to right.

Instead of rebuilding the window every time:

    Old Window
    [ 2  1  5 ]

    New Window
    [ 1  5  1 ]

We simply:

    Remove 2
    Add 1

Therefore:

    New Window = Old Window - Leaving Element + Entering Element

This avoids repeated calculations.

---

# 🔍 When Should You Think of Sliding Window?

Look for clues such as:

- ✅ Contiguous subarray
- ✅ Contiguous substring
- ✅ Subarray of size `k`
- ✅ Substring of size `k`
- ✅ Maximum sum
- ✅ Minimum sum
- ✅ Longest substring
- ✅ Shortest subarray
- ✅ At most `k`
- ✅ At least `k`
- ✅ No more than `k`
- ✅ Distinct elements
- ✅ Character frequency
- ✅ Consecutive elements
- ✅ Window / range

> 🚀 **Interview Rule:**
>
> If a problem asks about a **contiguous subarray or substring**, immediately consider **Sliding Window**.

---

# ❌ When NOT to Use

| Situation | Better Pattern |
|---|---|
| Sorted array + pair | Two Pointers |
| Linked list cycle | Fast & Slow Pointers |
| Frequency counting only | HashMap |
| Range sum queries | Prefix Sum |
| Shortest path | BFS |
| Tree traversal | DFS / BFS |
| Optimization over choices | Dynamic Programming |
| Non-contiguous subsequence | Dynamic Programming / Other |

---

# 🔄 Core Sliding Window Patterns

# 1️⃣ Fixed-Size Window

The window size remains constant.

Example:

> Find the maximum sum of a subarray of size `k`.

For:

    arr = [2, 1, 5, 1, 3, 2]
    k = 3

Windows:

    [2  1  5]
       [1  5  1]
          [5  1  3]
             [1  3  2]

Every window has exactly `3` elements.

### Used In

- Maximum sum subarray of size `K`
- Average of all subarrays of size `K`
- Maximum number of vowels in a substring of size `K`
- First negative number in every window
- Fixed-length substring problems

---

# 2️⃣ Variable-Size Window

The window size changes depending on a condition.

Example:

> Find the longest substring containing at most `K` distinct characters.

The window may expand:

    [a]
    [a b]
    [a b c]
    [a b c d]

If the window becomes invalid:

    [a b c d]
     ↑
    left

Move `left` forward:

    [a b c d]
        ↑
       left

Continue until the window becomes valid.

### Used In

- Longest substring without repeating characters
- Longest substring with at most `K` distinct characters
- Minimum size subarray sum
- Longest repeating character replacement
- Fruit Into Baskets

---

# 3️⃣ Frequency-Based Window

Some problems require us to know how many times elements appear inside the window.

Use:

- `HashMap`
- `HashSet`
- Frequency Array

Example:

    "abcabc"

We may maintain:

    Map<Character, Integer> freq = new HashMap<>();

When adding a character:

    freq.put(ch, freq.getOrDefault(ch, 0) + 1);

When removing:

    freq.put(ch, freq.get(ch) - 1);

If its frequency becomes zero:

    freq.remove(ch);

### Used In

- Character frequency problems
- Anagram problems
- Distinct character problems
- Repeating character problems

---

# ⚡ Approaches

| Approach | Time | Space |
|---|---:|---:|
| Brute Force | O(n²) / O(n³) | O(1) |
| Sliding Window | ⭐ O(n) | ⭐ O(1) |
| Sliding Window + HashMap | ⭐ O(n) | O(k) |

The exact complexity depends on the problem.

---

# 🚀 Fixed-Size Sliding Window Algorithm

### Step 1

Initialize the window:

    int left = 0;
    int windowValue = 0;

### Step 2

Move `right` and add the new element:

    windowValue += arr[right];

### Step 3

If the window becomes larger than `k`, remove the left element:

    windowValue -= arr[left];
    left++;

### Step 4

When the window size becomes `k`, update the answer:

    if (right - left + 1 == k) {
        // Update answer.
    }

---

# 💻 Generic Java Template — Fixed Window

    int left = 0;
    int windowValue = 0;

    for (int right = 0; right < arr.length; right++) {

        // Add the new element.
        windowValue += arr[right];

        // Shrink if window becomes too large.
        if (right - left + 1 > k) {
            windowValue -= arr[left];
            left++;
        }

        // Window size is exactly k.
        if (right - left + 1 == k) {

            // Update answer.
        }
    }

---

# 🚀 Variable-Size Sliding Window Algorithm

### Step 1

Start the left pointer:

    int left = 0;

### Step 2

Move `right` to expand the window.

### Step 3

Add the new element to the window.

### Step 4

Check whether the window is invalid.

If invalid:

    while (/* window is invalid */) {

        // Remove arr[left].
        left++;
    }

### Step 5

Once the window becomes valid, update the answer.

---

# 💻 Generic Java Template — Variable Window

    int left = 0;

    for (int right = 0; right < arr.length; right++) {

        // Add arr[right] to the window.

        while (/* window is invalid */) {

            // Remove arr[left] from the window.
            left++;
        }

        // Window is valid.
        // Update answer.
    }

---

# 🔄 Window Expansion

The `right` pointer expands the window.

    [ 2  1  5  1  3  2 ]
     ↑
    left

           ↑
          right

Move:

    right++;

The new element enters the window.

    [ 2  1  5  1 ]
     ↑           ↑
    left        right

---

# 🔽 Window Shrinking

The `left` pointer shrinks the window.

    [ 2  1  5  1 ]
     ↑           ↑
    left        right

Move:

    left++;

Now `2` leaves the window:

    [ 2  1  5  1 ]
        ↑         ↑
       left      right

---

# 🧠 The Three-Step Mental Model

For most variable-size Sliding Window problems:

    1. EXPAND
         ↓
    2. CHECK CONDITION
         ↓
    3. SHRINK IF INVALID

More clearly:

    right moves
         ↓
    add element
         ↓
    window valid?
       /       \
     YES        NO
      ↓          ↓
    update     shrink
    answer     left++
                 ↓
             valid again

---

# 📌 Fixed vs Variable Window

| Feature | Fixed Window | Variable Window |
|---|---|---|
| Size | Constant | Changes |
| Typical clue | `size k` | longest / shortest |
| Main movement | Add + Remove | Expand + Shrink |
| Condition | Window size | Window validity |
| Common tool | Sum / Count | HashMap / HashSet / Count |

---

# 📊 Dry Run — Fixed Window

### Input

    arr = [2, 1, 5, 1, 3, 2]
    k = 3

We need the maximum sum.

### Window 1

    [2  1  5]

    sum = 2 + 1 + 5
        = 8

Answer:

    8

### Window 2

Remove `2`, add `1`:

    [1  5  1]

    sum = 8 - 2 + 1
        = 7

Answer:

    8

### Window 3

Remove `1`, add `3`:

    [5  1  3]

    sum = 7 - 1 + 3
        = 9

Answer:

    9

### Window 4

Remove `5`, add `2`:

    [1  3  2]

    sum = 9 - 5 + 2
        = 6

Final answer:

    9

---

# 📊 Dry Run — Variable Window

### Example

Find the longest substring without repeating characters.

Input:

    "abcabcbb"

Start:

    left = 0

Expand:

    [a]
    [a b]
    [a b c]

Current window:

    "abc"

Length:

    3

Next character:

    [a b c a]

`a` is repeated.

The window is invalid.

Shrink from the left:

    [b c a]

Now the window is valid again.

Continue expanding.

The maximum valid window remains:

    "abc"

Answer:

    3

---

# 💻 Sliding Window + HashMap

For character-frequency problems:

    Map<Character, Integer> freq = new HashMap<>();

### Add character

    freq.put(ch, freq.getOrDefault(ch, 0) + 1);

### Remove character

    freq.put(ch, freq.get(ch) - 1);

### Remove completely

    if (freq.get(ch) == 0) {
        freq.remove(ch);
    }

This allows us to maintain the state of the current window.

---

# 🔄 Common Window Operations

### Add an element

    windowValue += arr[right];

### Remove an element

    windowValue -= arr[left];

### Expand

    right++;

### Shrink

    left++;

### Current window size

    right - left + 1

> ⭐ **Remember:** `right - left + 1` is the size of the current window.

---

# 🧩 Longest Valid Window

Typical problem:

> Find the longest window satisfying a condition.

Pattern:

    int left = 0;
    int answer = 0;

    for (int right = 0; right < arr.length; right++) {

        // Add arr[right].

        while (/* invalid */) {

            // Remove arr[left].
            left++;
        }

        answer = Math.max(answer, right - left + 1);
    }

### Key Rule

    Make window valid
           ↓
    Update maximum

---

# 🧩 Shortest Valid Window

Typical problem:

> Find the shortest window satisfying a condition.

Pattern:

    int left = 0;
    int answer = Integer.MAX_VALUE;

    for (int right = 0; right < arr.length; right++) {

        // Add arr[right].

        while (/* valid */) {

            answer = Math.min(answer, right - left + 1);

            // Remove arr[left].
            left++;
        }
    }

### Key Rule

    Make window valid
           ↓
    Shrink as much as possible
           ↓
    Update minimum

---

# 🔥 At Most K

Problems containing:

    "at most K"
    "no more than K"

often use:

    Variable Sliding Window

Example:

> Longest substring with at most `K` distinct characters.

Concept:

    Expand
       ↓
    Distinct > K?
       ↓
    Shrink
       ↓
    Distinct <= K
       ↓
    Update answer

---

# 🔥 Exactly K

Problems asking for:

    "exactly K"

can sometimes be solved using:

    Exactly K
    =
    At Most K - At Most (K - 1)

This is a useful advanced Sliding Window technique.

Example:

    countExactlyK
    =
    countAtMostK - countAtMostKMinusOne

---

# 🔥 Minimum Window

For minimum-window problems:

    Expand until valid
           ↓
    Shrink while valid
           ↓
    Record smallest valid window

This is the opposite intuition from many longest-window problems.

---

# ⚠️ Common Mistakes

- ❌ Recalculating the entire window every time
- ❌ Forgetting to remove the left element
- ❌ Moving `left` without updating window state
- ❌ Updating the answer before the window becomes valid
- ❌ Using `if` when repeated shrinking requires `while`
- ❌ Forgetting `right - left + 1`
- ❌ Confusing substring with subsequence
- ❌ Using Sliding Window for non-contiguous elements
- ❌ Forgetting to remove zero-frequency entries from a HashMap

---

# 🧪 Edge Cases

Always test:

- Empty array
- One element
- `k = 1`
- `k = array.length`
- `k > array.length`
- All elements equal
- All elements different
- Duplicate elements
- Negative numbers
- Zero
- Empty string
- One-character string
- Entire string is the answer
- No valid window exists

---

# ⏱️ Complexity Analysis

| Complexity | Typical Value |
|---|---|
| Time | **O(n)** |
| Space | **O(1)** or **O(k)** |

### Why O(n)?

Although a Sliding Window may contain a nested `while` loop, the algorithm can still be O(n).

Why?

    right moves forward at most n times
    left moves forward at most n times

Therefore:

    O(n + n)
    = O(2n)
    = O(n)

### Why O(1) Space?

For problems that only maintain a few variables:

    left
    right
    sum
    count

No additional data structure is required.

### Why O(k) Space?

When using:

    HashMap
    HashSet
    Frequency Array

the additional space depends on the number of tracked elements.

---

# 🔁 Sliding Window vs Two Pointers

These patterns are related but not identical.

### Two Pointers

Usually focuses on two positions moving through the input.

Examples:

- Two Sum
- 3Sum
- Remove Duplicates
- Container With Most Water

### Sliding Window

Specifically maintains a **contiguous range**.

Examples:

- Maximum Sum Subarray of Size K
- Longest Substring Without Repeating Characters
- Minimum Size Subarray Sum

> ⭐ **Remember:** Sliding Window often uses two pointers, but not every Two Pointers problem is a Sliding Window problem.

---

# 🆚 Brute Force vs Sliding Window

Suppose:

    arr = [2, 1, 5, 1, 3, 2]
    k = 3

### Brute Force

Calculate each window from scratch:

    [2,1,5] → calculate
    [1,5,1] → calculate
    [5,1,3] → calculate
    [1,3,2] → calculate

Repeated work occurs.

### Sliding Window

Reuse the previous result:

    Old Sum
       ↓
    Remove leaving element
       ↓
    Add entering element
       ↓
    New Sum

This reduces unnecessary work.

---

# 🧠 Pattern Recognition Checklist

When reading a problem, ask:

    1. Is the problem about a contiguous range?
            ↓
           YES

    2. Is it a subarray or substring?
            ↓
           YES

    3. Is the window fixed-size?
            ↓
       Fixed Window

    4. Is the window size changing?
            ↓
       Variable Window

    5. What makes the window invalid?
            ↓
       Define the condition

    6. What information must I maintain?
            ↓
       Sum / Count / Frequency / HashMap / HashSet

    7. When should I update the answer?
            ↓
       After maintaining the required window

---

# 📚 Practice Problems

## 🟢 Easy

- Maximum Average Subarray I
- Maximum Number of Vowels in a Substring of Given Length
- Contains Duplicate II

---

## 🟡 Medium

- Longest Substring Without Repeating Characters
- Longest Repeating Character Replacement
- Minimum Size Subarray Sum
- Permutation in String
- Fruit Into Baskets
- Max Consecutive Ones III

---

## 🔴 Hard

- Minimum Window Substring
- Sliding Window Maximum
- Subarrays with K Different Integers
- Count of Subarrays with Exactly K Different Integers

> 📌 Many Hard Sliding Window problems combine the pattern with HashMap, Deque, or advanced counting techniques.

---

# 🎯 Interview Tips

Before coding, ask:

- Is the range contiguous?
- Is it a subarray or substring?
- Is the window fixed-size or variable-size?
- What makes the window invalid?
- What information should I maintain?
- When should I expand?
- When should I shrink?
- When should I update the answer?
- Do I need a HashMap or HashSet?
- Can I achieve O(n)?

> ⭐ **Important:**
>
> The most important skill is recognizing when you can maintain a window instead of recalculating every subarray or substring.

---

# 📝 Quick Revision

    SLIDING WINDOW

            RIGHT
              ↓
        ┌─────────────┐
        │   WINDOW    │
        └─────────────┘
              ↑
             LEFT

    --------------------------------

    FIXED WINDOW

    Add right
    Remove left
    Keep size = k

    --------------------------------

    VARIABLE WINDOW

    Expand right
          ↓
    Check condition
          ↓
    Invalid?
          ↓
    Shrink left
          ↓
    Valid
          ↓
    Update answer

    --------------------------------

    WINDOW SIZE

    right - left + 1

    --------------------------------

    LONGEST WINDOW

    Make valid
        ↓
    Update maximum

    --------------------------------

    SHORTEST WINDOW

    Make valid
        ↓
    Shrink
        ↓
    Update minimum

    --------------------------------

    FREQUENCY WINDOW

    HashMap / HashSet / Array

    --------------------------------

    Time  : O(n)

    Space : O(1) or O(k)

    --------------------------------

    Golden Rule

    Contiguous Subarray / Substring
                 ↓
          Sliding Window

---

# 🏆 Top Interview Questions

| Problem | Difficulty | Core Concept |
|---|---|---|
| Maximum Average Subarray I | 🟢 Easy | Fixed Window |
| Maximum Number of Vowels in a Substring | 🟢 Easy | Fixed Window |
| Longest Substring Without Repeating Characters | 🟡 Medium | Variable Window |
| Minimum Size Subarray Sum | 🟡 Medium | Variable Window |
| Longest Repeating Character Replacement | 🟡 Medium | Frequency Window |
| Permutation in String | 🟡 Medium | Frequency Window |
| Fruit Into Baskets | 🟡 Medium | At Most K |
| Max Consecutive Ones III | 🟡 Medium | Variable Window |
| Minimum Window Substring | 🔴 Hard | Frequency + Variable Window |
| Sliding Window Maximum | 🔴 Hard | Window + Deque |

---

# ⭐ Key Takeaway

> **Sliding Window maintains a contiguous range and efficiently expands or shrinks that range to avoid repeated calculations.**

    Contiguous Range
           ↓
    Two Boundaries
           ↓
       Left + Right
           ↓
      Expand / Shrink
           ↓
    Maintain Window State
           ↓
         O(n) Time

> 🔥 **Golden Rule:**
>
> **Contiguous + Subarray/Substring + Optimization/Condition → Think Sliding Window.**