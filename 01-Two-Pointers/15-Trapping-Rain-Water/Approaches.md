# P015 — Trapping Rain Water

**LeetCode:** #42  
**Pattern:** Two Pointers  
**Difficulty:** Hard

---

# Approaches

We have **3 meaningful approaches**:

| Approach | Technique | Time | Space | Status | Priority |
|---|---|---:|---:|---|---|
| Approach 01 | Prefix/Suffix Max Arrays | O(n) | O(n) | Solved | OPTIONAL |
| Approach 02 | Monotonic Stack | O(n) | O(n) | Pending | OPTIONAL |
| Approach 03 | Two Pointers | O(n) | O(1) | Pending | MUST MASTER 🔥 |

---

# Approach 01 — Prefix/Suffix Max Arrays

- **Status:** Solved
- **Time Complexity:** O(n)
- **Space Complexity:** O(n)
- **Priority:** OPTIONAL

## Idea

For every index, the amount of trapped water depends on the tallest bar on its left and the tallest bar on its right.

We precompute:

- `leftMax[i]` → maximum height from index `0` to `i`
- `rightMax[i]` → maximum height from index `i` to `n - 1`

The water stored at an index is:

    waterAtIndex = min(leftMax[i], rightMax[i]) - arr[i]

## Steps

1. Create a `leftMax[]` array.
2. Build it from left to right.
3. Create a `rightMax[]` array.
4. Build it from right to left.
5. For every index, calculate the trapped water.
6. Add the water from every index to the final answer.

## Building `leftMax[]`

    leftMax[0] = arr[0];

    for (int i = 1; i < n; i++) {
        leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
    }

## Building `rightMax[]`

    rightMax[n - 1] = arr[n - 1];

    for (int i = n - 2; i >= 0; i--) {
        rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
    }

## Calculating Water

    int waterStored = 0;

    for (int i = 0; i < n; i++) {
        int waterAtIndex =
                Math.min(leftMax[i], rightMax[i]) - arr[i];

        waterStored += waterAtIndex;
    }

## Key Formula

    waterAtIndex = min(leftMax[i], rightMax[i]) - arr[i]

## Why `min()`?

The water level cannot be higher than the shorter boundary.

For example:

    leftMax  = 4
    rightMax = 5
    current height = 2

    water = min(4, 5) - 2
          = 2

## Example

    arr = [4, 2, 0, 3, 2, 5]

    leftMax  = [4, 4, 4, 4, 4, 5]
    rightMax = [5, 5, 5, 5, 5, 5]

At index `2`:

    leftMax[2] = 4
    rightMax[2] = 5
    arr[2] = 0

    water = min(4, 5) - 0
          = 4

## Important Points

- Prefix maximum is built from left to right.
- Suffix maximum is built from right to left.
- Water depends on the smaller of the two boundary maxima.
- The current bar height must be subtracted.
- Total water is the sum of water stored at every index.

## Pattern Reinforced

- Prefix Maximum
- Suffix Maximum
- Array preprocessing
- Two-boundary reasoning

---

# Approach 02 — Monotonic Stack

- **Status:** Pending
- **Time Complexity:** O(n)
- **Space Complexity:** O(n)
- **Priority:** OPTIONAL

## Idea

Use a monotonic decreasing stack of indices.

The stack helps identify:

- Left boundary
- Current/right boundary
- The height of the valley between them

Whenever the current bar is taller than the bar at the top of the stack, a trapped-water region can be calculated.

## Core Concept

For a popped index:

    height = arr[popped]

The new stack top becomes the left boundary and the current index becomes the right boundary.

Then calculate:

    boundedHeight = min(arr[left], arr[right]) - height

and:

    distance = right - left - 1

Then:

    water = distance * boundedHeight

## Complexity

    Time: O(n)
    Space: O(n)

---

# Approach 03 — Two Pointers

- **Status:** Pending
- **Time Complexity:** O(n)
- **Space Complexity:** O(1)
- **Priority:** MUST MASTER 🔥

## Idea

Instead of creating `leftMax[]` and `rightMax[]`, maintain the required maximum values while using two pointers:

    left = 0
    right = n - 1

Maintain:

    leftMax
    rightMax

At every step, process the side with the smaller maximum boundary.

## Key Observation

If:

    leftMax <= rightMax

then the water at the left side is determined by `leftMax`.

Otherwise, the water at the right side is determined by `rightMax`.

This allows us to solve the problem using constant extra space.

## Complexity

    Time: O(n)
    Space: O(1)

---

# Summary

| Approach | Time | Space | Priority | Status |
|---|---:|---:|---|---|
| Prefix/Suffix Max Arrays | O(n) | O(n) | OPTIONAL | Solved |
| Monotonic Stack | O(n) | O(n) | OPTIONAL | Pending |
| Two Pointers | O(n) | O(1) | MUST MASTER 🔥 | Pending |

---

# Learning Order

    Approach 01 → Understand the core water calculation
    Approach 02 → Learn the stack-based way
    Approach 03 → Master the O(1) Two Pointers optimization