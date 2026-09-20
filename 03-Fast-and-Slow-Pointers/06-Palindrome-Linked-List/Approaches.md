# P006 — Palindrome Linked List

**LeetCode:** #234  
**Pattern:** Fast & Slow Pointers  
**Difficulty:** Medium

---

# Approaches

We have **3 meaningful approaches**:

| Approach | Technique | Time | Space | Status | Priority |
|---|---|---:|---:|---|---|
| Approach 01 | ArrayList | O(n) | O(n) | Solved | OPTIONAL |
| Approach 02 | Stack | O(n) | O(n) | Parked | OPTIONAL |
| Approach 03 | Fast & Slow + Reverse Second Half | O(n) | O(1) | Solved | MUST MASTER 🔥 |

---

# Approach 01 — ArrayList

- **Status:** Solved
- **Time Complexity:** O(n)
- **Space Complexity:** O(n)
- **Priority:** OPTIONAL

## Idea

A singly linked list cannot be traversed backward easily.

So, store all node values in an `ArrayList`.

Then use two pointers:

    left = 0
    right = list.size() - 1

Compare values from both ends.

If any pair is different, the linked list is not a palindrome.

## Steps

1. Traverse the linked list.
2. Store every node value in an `ArrayList`.
3. Initialize `left` and `right`.
4. Compare values at both positions.
5. If they differ, return `false`.
6. Move `left` forward and `right` backward.
7. Continue until the pointers meet.
8. Return `true`.

## Example

    Linked List:
    1 → 2 → 2 → 1

    ArrayList:
    [1, 2, 2, 1]

Compare:

    1 == 1 ✅
    2 == 2 ✅

Result:

    true

## Important Point

When comparing `Integer` values stored in the `ArrayList`, use:

    list.get(left).equals(list.get(right))

rather than `==`.

## Complexity

    Time: O(n)
    Space: O(n)

---

# Approach 02 — Stack

- **Status:** Parked
- **Time Complexity:** O(n)
- **Space Complexity:** O(n)
- **Priority:** OPTIONAL

## Idea

A stack follows **Last In, First Out (LIFO)**.

Store the linked-list values in a stack.

Then compare the original linked-list values with values popped from the stack.

Because the stack returns values in reverse order, it can be used to check whether the linked list reads the same forward and backward.

## Steps

1. Traverse the linked list.
2. Push every node value onto the stack.
3. Traverse the linked list again.
4. Compare each node value with the value popped from the stack.
5. If any value differs, return `false`.
6. If all values match, return `true`.

## Complexity

    Time: O(n)
    Space: O(n)

## Note

This approach is parked for now because Stack has not been studied yet.

---

# Approach 03 — Fast & Slow + Reverse Second Half

- **Status:** Solved
- **Time Complexity:** O(n)
- **Space Complexity:** O(1)
- **Priority:** MUST MASTER 🔥

## Idea

A palindrome has matching values from both ends.

For a linked list, we can:

1. Find the middle using Fast & Slow Pointers.
2. Reverse the second half of the linked list.
3. Compare the first half with the reversed second half.

This achieves constant extra space.

## Step 1 — Find the Middle

Use:

    slow
    fast

Move:

    slow → 1 step
    fast → 2 steps

When `fast` reaches the end, `slow` is around the middle.

## Step 2 — Reverse the Second Half

For:

    1 → 2 → 2 → 1

split conceptually:

    1 → 2 | 2 → 1

Reverse the second half:

    1 → 2 | 1 → 2

## Step 3 — Compare Both Halves

Compare:

    First half:
    1 → 2

    Reversed second half:
    1 → 2

Every corresponding value matches.

Therefore:

    true

## Important Edge Cases

- Empty linked list → `true`
- Single node → `true`
- Even-length palindrome → `true`
- Odd-length palindrome → `true`
- Non-palindrome → `false`

## Key Pattern

    Fast & Slow Pointers
            ↓
       Find middle
            ↓
      Reverse second half
            ↓
        Compare halves

## Complexity

    Time: O(n)
    Space: O(1)