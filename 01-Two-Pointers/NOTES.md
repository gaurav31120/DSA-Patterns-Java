# 🎯 Two Pointers Pattern

![Java](https://img.shields.io/badge/Java-17-red)
![Pattern](https://img.shields.io/badge/Pattern-Two%20Pointers-blue)
![Difficulty](https://img.shields.io/badge/Difficulty-Easy%20%7C%20Medium-green)
![Time](https://img.shields.io/badge/Time-O(n)-brightgreen)
![Space](https://img.shields.io/badge/Space-O(1)-orange)

> 📌 **Master the Two Pointers pattern to optimize pair-based problems from O(n²) to O(n).**

---

# 📖 What is Two Pointers?

The **Two Pointers** pattern is an optimization technique where **two indices (pointers)** traverse an array, string, or linked list to solve a problem efficiently.

Instead of checking every possible combination (**O(n²)**), the pointers move intelligently to reduce the complexity to **O(n)**.

> 💡 **Goal:** Reduce unnecessary comparisons and optimize brute-force solutions.

---

# 🧠 Core Intuition

Imagine two people searching for a friend standing in a straight line.

- 👉 One starts from the **left**.
- 👈 One starts from the **right**.

Instead of one person checking everyone, both move towards each other intelligently.

This significantly reduces the number of comparisons.

---

# 🔍 When Should You Think of Two Pointers?

If the problem contains any of these clues:

- ✅ Sorted Array
- ✅ Pair Sum
- ✅ Triplets
- ✅ Closest Pair
- ✅ Reverse String/Array
- ✅ Palindrome
- ✅ Remove Duplicates
- ✅ Merge Sorted Arrays
- ✅ Move Zeroes

> 🚀 **Interview Rule:**  
> If the array is sorted and you're searching for a pair or trying to optimize comparisons, think **Two Pointers** first.

---

# ❌ When NOT to Use

| Situation | Better Pattern |
|-----------|----------------|
| Unsorted array (original indices required) | HashMap |
| Frequency counting | HashMap |
| Range sum queries | Prefix Sum |
| Graph problems | BFS / DFS |
| Tree problems | DFS / BFS |
| Dynamic Programming | DP |

---

# 🔄 Types of Two Pointers

## 1️⃣ Opposite Direction

```text
L             R
1 2 3 4 6 8 9
```

**Used In**

- Two Sum II
- Valid Palindrome
- Container With Most Water

---

## 2️⃣ Same Direction (Fast & Slow)

```text
S
F

0 1 0 3 12
```

**Used In**

- Move Zeroes
- Remove Duplicates
- Remove Element

---

## 3️⃣ Fast & Slow Pointer

```text
Fast ➜➜

Slow ➜
```

**Used In**

- Linked List Cycle
- Middle of Linked List
- Happy Number

---

## 4️⃣ Three Pointers

Used in

- Sort Colors
- Dutch National Flag

---

# ⚡ Approaches

| Approach | Time | Space |
|----------|------|-------|
| Brute Force | O(n²) | O(1) |
| HashMap | O(n) | O(n) |
| Two Pointers | ⭐ O(n) | ⭐ O(1) |

---

# 🚀 Optimal Algorithm

### Step 1

Initialize

```java
left = 0;
right = n - 1;
```

### Step 2

Calculate

```java
sum = arr[left] + arr[right];
```

### Step 3

- ✅ If `sum == target` → Answer Found
- ➡️ If `sum < target` → `left++`
- ⬅️ If `sum > target` → `right--`

### Step 4

Repeat until

```java
left < right
```

---

# 💻 Generic Java Template

```java
public int[] twoSum(int[] arr, int target) {

    int left = 0;
    int right = arr.length - 1;

    while (left < right) {

        int sum = arr[left] + arr[right];

        if (sum == target) {
            return new int[]{left, right};
        }

        if (sum < target) {
            left++;
        } else {
            right--;
        }
    }

    return new int[]{-1, -1};
}
```

---

# 📊 Dry Run

### Input

```text
Array = [2,3,4,7,11,15]

Target = 15
```

| Left | Right | Sum | Action |
|------|-------|-----|--------|
| 2 | 15 | 17 | Right-- |
| 2 | 11 | 13 | Left++ |
| 3 | 11 | 14 | Left++ |
| 4 | 11 | 15 | ✅ Found |

---

# ⏱️ Complexity Analysis

| Complexity | Value |
|------------|-------|
| Time | **O(n)** |
| Space | **O(1)** |

### Why O(n)?

Each pointer moves in only one direction.

- Left pointer moves at most **n** times.
- Right pointer moves at most **n** times.

Total operations remain linear.

---

# ⚠️ Common Mistakes

- ❌ Using Two Pointers on an unsorted array.
- ❌ Sorting when original indices are required.
- ❌ Moving both pointers together.
- ❌ Ignoring duplicate values in 3Sum.
- ❌ Using `while(left <= right)` when two distinct elements are required.

---

# 🧪 Edge Cases

Always test:

- Empty Array
- Single Element
- Duplicate Values
- Negative Numbers
- No Valid Pair
- Large Integer Values

---

# 📚 Practice Problems

## 🟢 Easy

- Reverse String
- Valid Palindrome
- Remove Duplicates from Sorted Array
- Remove Element
- Move Zeroes

---

## 🟡 Medium

- Two Sum II
- 3Sum
- 3Sum Closest
- Container With Most Water
- Sort Colors

---

## 🔴 Hard

- Trapping Rain Water
- 4Sum

---

# 🎯 Interview Tips

✔️ Ask these questions before coding:

- Is the array sorted?
- Can I use Two Pointers?
- Do I need original indices?
- Would HashMap be a better choice?

Interviewers appreciate candidates who clarify assumptions before writing code.

---

# 📝 Quick Revision

```text
Recognition Clues

✔ Sorted Array
✔ Pair
✔ Triplet
✔ Palindrome
✔ Reverse

-----------------------------

Sum < Target ➜ Left++

Sum > Target ➜ Right--

-----------------------------

Time  : O(n)

Space : O(1)

-----------------------------

Golden Rule

Sorted Array + Pair Problem

        ↓

Think Two Pointers
```

---

# 🏆 Top Interview Questions

| Problem | Difficulty |
|----------|------------|
| Two Sum II | 🟡 Medium |
| Valid Palindrome | 🟢 Easy |
| Reverse String | 🟢 Easy |
| Move Zeroes | 🟢 Easy |
| Container With Most Water | 🟡 Medium |
| 3Sum | 🟡 Medium |
| Trapping Rain Water | 🔴 Hard |

---

⭐ **Key Takeaway**

> Two Pointers is one of the most powerful optimization patterns. Whenever you see a **sorted array** and need to find a **pair**, **triplet**, or **optimize comparisons**, always check whether Two Pointers can reduce the solution from **O(n²)** to **O(n)**.