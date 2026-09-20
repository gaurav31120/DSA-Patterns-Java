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
| Approach 03 | Two Pointers | O(n) | O(1) | Solved | MUST MASTER 🔥 |

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

## Key Formula

    waterAtIndex = min(leftMax[i], rightMax[i]) - arr[i]

## Complexity

    Time: O(n)
    Space: O(n)

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
- Valley/bottom
- Right boundary

When the current bar is taller than the bar at the top of the stack, a trapped-water region can be calculated.

## Core Calculation

For a popped index:

    height = arr[popped]

The new stack top becomes the left boundary.

The current index becomes the right boundary.

Then:

    boundedHeight = min(arr[left], arr[right]) - height

    distance = right - left - 1

    water = distance * boundedHeight

## Complexity

    Time: O(n)
    Space: O(n)

---

# Approach 03 — Two Pointers

- **Status:** Solved
- **Time Complexity:** O(n)
- **Space Complexity:** O(1)
- **Priority:** MUST MASTER 🔥

## Idea

Instead of storing `leftMax[]` and `rightMax[]` arrays, maintain the maximum heights seen so far using two variables:

    leftMax
    rightMax

Use two pointers:

    left = 0
    right = n - 1

At every step, compare the heights at the two pointers.

## Key Observation

If:

    arr[left] <= arr[right]

we process the left side.

Otherwise, we process the right side.

The reason is that the side with the smaller current boundary can be resolved using the maximum boundary already maintained on that side.

## Left Side

When:

    arr[left] <= arr[right]

update:

    leftMax = max(leftMax, arr[left])

Then:

    waterAtIndex = leftMax - arr[left]

Finally:

    left++

## Right Side

When:

    arr[left] > arr[right]

update:

    rightMax = max(rightMax, arr[right])

Then:

    waterAtIndex = rightMax - arr[right]

Finally:

    right--

## Complexity

    Time: O(n)
    Space: O(1)

## Key Pattern

    Compare both ends
        ↓
    Process the smaller side
        ↓
    Maintain its maximum
        ↓
    Calculate trapped water
        ↓
    Move pointer inward

---

# Summary

| Approach | Time | Space | Priority | Status |
|---|---:|---:|---|---|
| Prefix/Suffix Max Arrays | O(n) | O(n) | OPTIONAL | Solved |
| Monotonic Stack | O(n) | O(n) | OPTIONAL | Pending |
| Two Pointers | O(n) | O(1) | MUST MASTER 🔥 | Solved |

---

# Learning Order

    Approach 01 → Understand the core water calculation
    Approach 02 → Learn after studying Stack
    Approach 03 → Master the O(1) Two Pointers optimization