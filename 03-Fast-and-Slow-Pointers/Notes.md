# 🎯 Fast & Slow Pointers Pattern

![Java](https://img.shields.io/badge/Java-17-red)

![Pattern](https://img.shields.io/badge/Pattern-Fast%20%26%20Slow%20Pointers-blue)

![Difficulty](https://img.shields.io/badge/Difficulty-Easy%20%7C%20Medium-green)

![Time](https://img.shields.io/badge/Time-O\(n\)-brightgreen)

![Space](https://img.shields.io/badge/Space-O\(1\)-orange)

> 📌 **Master the Fast & Slow Pointers pattern to solve cycle, middle, and repeated-state problems efficiently using O(1) extra space.**

---

# 📖 What is Fast & Slow Pointers?

The **Fast & Slow Pointers** pattern uses two pointers that move through a data structure at different speeds.

* 🐢 **Slow pointer** → moves one step at a time.
* 🐇 **Fast pointer** → moves two steps at a time.

The difference in their speeds allows us to detect:

* Cycles
* Middle positions
* Repeated states
* Circular sequences

> 💡 **Goal:** Use pointer movement instead of extra memory to detect structure or repetition.

---

# 🧠 Core Intuition

Imagine two runners on a circular track.

* 🐢 Slow runner takes **1 step**.
* 🐇 Fast runner takes **2 steps**.

If there is a cycle, the faster runner will eventually catch the slower runner.

```text
Slow  →  →
Fast  →  →  →  →
```

If there is no cycle, the fast pointer eventually reaches the end.

This simple idea is the foundation of the pattern.

---

# 🔍 When Should You Think of Fast & Slow Pointers?

Look for clues such as:

* ✅ Linked List
* ✅ Detect Cycle
* ✅ Find Middle
* ✅ Find Cycle Start
* ✅ Repeated Values / States
* ✅ Circular Sequence
* ✅ Constant Extra Space Requirement
* ✅ "Move one pointer twice as fast"

> 🚀 **Interview Rule:**
> If a linked list or sequence may contain a cycle, immediately think **Fast & Slow Pointers**.

---

# ❌ When NOT to Use

| Situation                 | Better Pattern      |
| ------------------------- | ------------------- |
| Sorted array + pair       | Two Pointers        |
| Sliding contiguous range  | Sliding Window      |
| Frequency counting        | HashMap             |
| Shortest path             | BFS                 |
| Tree traversal            | DFS / BFS           |
| Range sum                 | Prefix Sum          |
| Optimization over choices | Dynamic Programming |

---

# 🔄 Core Fast & Slow Pointer Patterns

## 1️⃣ Cycle Detection

Use:

```text
slow → 1 step
fast → 2 steps
```

Example:

```text
1 → 2 → 3 → 4
    ↑       ↓
    ← ← ← ←
```

If a cycle exists:

```text
slow == fast
```

### Used In

* Linked List Cycle
* Circular Array Cycle
* Happy Number

---

# 2️⃣ Find Middle of Linked List

Move:

```text
slow → 1 step
fast → 2 steps
```

When `fast` reaches the end:

```text
slow → middle
```

Example:

```text
1 → 2 → 3 → 4 → 5
        ↑
       slow
```

At the end:

```text
slow = 3
```

### Used In

* Middle of the Linked List
* Splitting a linked list into halves
* Merge Sort on Linked Lists

---

# 3️⃣ Find Start of Cycle

First detect the meeting point:

```text
slow == fast
```

Then:

```text
slow = head
```

Move both one step at a time:

```text
slow → 1 step
fast → 1 step
```

Where they meet again:

```text
cycle start
```

### Used In

* Linked List Cycle II

---

# 4️⃣ Repeated State Detection

Fast & Slow Pointers can also work when repeatedly applying a function.

Example:

```text
n → f(n) → f(f(n)) → ...
```

If a value repeats, a cycle exists.

### Used In

* Happy Number
* Repeated transformations

---

# ⚡ Approaches

| Approach                   | Time   | Space  |
| -------------------------- | ------ | ------ |
| Brute Force / Extra Memory | O(n)   | O(n)   |
| HashSet                    | O(n)   | O(n)   |
| Fast & Slow Pointers       | ⭐ O(n) | ⭐ O(1) |

---

# 🚀 Cycle Detection Algorithm

### Step 1

Initialize:

```java
ListNode slow = head;
ListNode fast = head;
```

### Step 2

Move the pointers:

```java
slow = slow.next;
fast = fast.next.next;
```

### Step 3

Check whether they meet:

```java
if (slow == fast) {
    return true;
}
```

### Step 4

Continue while the fast pointer can safely move:

```java
while (fast != null && fast.next != null)
```

---

# 💻 Generic Java Template — Cycle Detection

```java
public boolean hasCycle(ListNode head) {

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {

        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) {
            return true;
        }
    }

    return false;
}
```

---

# 💻 Generic Java Template — Find Middle

```java
public ListNode middleNode(ListNode head) {

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {

        slow = slow.next;
        fast = fast.next.next;
    }

    return slow;
}
```

---

# 🔄 Pointer Movement

```text
Slow:
1 → 2 → 3 → 4 → 5

Fast:
1 → 3 → 5 → null
```

Therefore:

```text
slow = middle
```

---

# 📊 Dry Run — Cycle Detection

### Input

```text
1 → 2 → 3 → 4
        ↑     ↓
        ← ← ←
```

| Step  | Slow | Fast |
| ----- | ---- | ---- |
| Start | 1    | 1    |
| 1     | 2    | 3    |
| 2     | 3    | 3    |
| 3     | 4    | 4    |
| 4     | 3    | 3    |

Eventually:

```text
slow == fast
```

Therefore:

```text
Cycle exists
```

---

# 📊 Dry Run — Find Middle

### Input

```text
1 → 2 → 3 → 4 → 5
```

| Step  | Slow | Fast |
| ----- | ---- | ---- |
| Start | 1    | 1    |
| 1     | 2    | 3    |
| 2     | 3    | 5    |

Now:

```text
fast.next == null
```

Therefore:

```text
slow = 3
```

Answer:

```text
3
```

---

# ⏱️ Complexity Analysis

| Complexity | Value    |
| ---------- | -------- |
| Time       | **O(n)** |
| Space      | **O(1)** |

### Why O(n)?

The slow pointer moves at most `n` steps.

The fast pointer moves at most `2n` steps.

Therefore the total work remains linear:

```text
O(n + 2n)
= O(3n)
= O(n)
```

### Why O(1) Space?

Only two pointers are used:

```java
slow
fast
```

No HashSet, array, or additional data structure is required.

---

# ⚠️ Common Mistakes

* ❌ Writing `fast = fast.next` instead of `fast = fast.next.next`
* ❌ Forgetting `fast != null && fast.next != null`
* ❌ Comparing values instead of node references for cycle detection
* ❌ Moving `slow` twice
* ❌ Forgetting that `fast` can reach `null`
* ❌ Resetting pointers incorrectly when finding cycle start
* ❌ Using extra memory when O(1) space is expected

---

# 🧪 Edge Cases

Always test:

* Empty linked list
* Single node
* Two nodes
* No cycle
* Cycle at the head
* Cycle in the middle
* Cycle at the last node
* Even number of nodes
* Odd number of nodes
* Self-loop

Example self-loop:

```text
1
↑
└──
```

---

# 📚 Practice Problems

## 🟢 Easy

* Middle of the Linked List
* Linked List Cycle
* Happy Number

---

## 🟡 Medium

* Linked List Cycle II
* Circular Array Loop

---

## 🔴 Hard

Fast & Slow Pointers is primarily an **Easy–Medium pattern**. Hard problems usually combine it with another technique.

---

# 🎯 Interview Tips

Before coding, ask:

* Is this a linked list?
* Can there be a cycle?
* Do I need to find the middle?
* Can I use two pointers moving at different speeds?
* Is O(1) extra space required?
* Do I need the cycle's meeting point or its starting point?

> ⭐ **Important:** In cycle detection, compare nodes using:
>
> ```java
> slow == fast
> ```
>
> Not:
>
> ```java
> slow.val == fast.val
> ```

Two different nodes can contain the same value.

---

# 📝 Quick Revision

```text
FAST & SLOW POINTERS

Slow → 1 step
Fast → 2 steps

--------------------------------

Cycle Detection

slow = slow.next
fast = fast.next.next

slow == fast
      ↓
Cycle exists

--------------------------------

Find Middle

fast reaches end
      ↓
slow = middle

--------------------------------

Cycle Start

1. Detect meeting point
2. slow = head
3. Move both one step
4. Meeting point = cycle start

--------------------------------

Time  : O(n)
Space : O(1)

--------------------------------

Golden Rule

Linked List + Cycle
        ↓
Fast & Slow Pointers

Linked List + Middle
        ↓
Fast & Slow Pointers
```

---

# 🏆 Top Interview Questions

| Problem                   | Difficulty | Core Concept    |
| ------------------------- | ---------- | --------------- |
| Middle of the Linked List | 🟢 Easy    | Find Middle     |
| Linked List Cycle         | 🟢 Easy    | Cycle Detection |
| Happy Number              | 🟢 Easy    | Repeated State  |
| Linked List Cycle II      | 🟡 Medium  | Cycle Start     |
| Circular Array Loop       | 🟡 Medium  | Cycle Detection |

---

# ⭐ Key Takeaway

> **Fast & Slow Pointers uses two pointers moving at different speeds to detect cycles, find middle positions, and identify repeated states using O(1) extra space.**

```text
Different Speeds
      ↓
Fast + Slow
      ↓
Cycle / Middle / Repetition
      ↓
O(n) Time
O(1) Space
```
