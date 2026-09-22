# Approaches — P010 Intersection of Two Linked Lists

## Approach 01 — ArrayList

### Idea

Store all nodes of List A inside an `ArrayList<Node>`.

Then traverse List B and check whether the current node already exists in List A.

The important point is that we must compare the actual `Node` objects, not just their values.

For example:

    List A:
    1 -> 2 -> 3 -> 6 -> 7

    List B:
    4 -> 5 -> 6 -> 7

If both lists point to the same `Node(6)` object, that node is the intersection.

### Steps

1. Create an `ArrayList<Node>` for List A.
2. Traverse List A and store every node.
3. Traverse List B.
4. For every node in List B, check:

    listA.contains(currB)

5. Return the first matching node.
6. If no node matches, return `null`.

### Complexity

- Time: O(n * m)
- Space: O(n)

### Java File

    _01_ArrayList.java

### Status

✅ Solved

---

# Approach 02 — Two Pointers

## Idea

Use two pointers:

    pointerA
    pointerB

Start:

    pointerA = headA
    pointerB = headB

Move both pointers one node at a time.

When a pointer reaches the end of its list, move it to the head of the other list.

That means:

    pointerA = pointerA.next

and when it reaches null:

    pointerA = headB

Similarly:

    pointerB = pointerB.next

and when it reaches null:

    pointerB = headA

Because both pointers travel the same total distance, they will eventually meet at the intersection node.

If there is no intersection, both pointers will eventually become `null`.

### Why It Works

Suppose:

    List A:
    1 -> 2 -> 3 -> 6 -> 7

    List B:
    4 -> 5 -> 6 -> 7

The lists have different lengths.

Pointer A travels:

    A + B

Pointer B travels:

    B + A

Therefore both pointers travel the same total distance.

After switching lists, the length difference is automatically cancelled.

If an intersection exists, they meet at that exact shared node.

### Steps

1. Initialize:

    Node pointerA = headA;
    Node pointerB = headB;

2. Continue until both pointers become equal:

    while (pointerA != pointerB)

3. Move each pointer forward.
4. When pointerA becomes `null`, move it to `headB`.
5. When pointerB becomes `null`, move it to `headA`.
6. Return `pointerA`.

### Important Condition

The loop should be:

    while (pointerA != pointerB)

not:

    while (pointerA != null && pointerB != null)

Because we also need to detect the case where both become `null`.

### Complexity

- Time: O(n + m)
- Space: O(1)

### Java File

    _02_TwoPointers.java

### Status

⏳ In Progress

---

# Comparison

| Approach | Time | Space |
|---|---:|---:|
| ArrayList | O(n * m) | O(n) |
| Two Pointers | O(n + m) | O(1) |

---

# Interview Focus

Approach 02 is the important solution to master because it gives:

    O(n + m) time
    O(1) space

The key pattern is:

    Traverse your list
    -> switch to the other list
    -> both pointers travel equal total distance
    -> meet at intersection

--------------------------------------------------------------------------------

x# Approach 02 — Two Pointers: Length Difference Alignment

## Idea

Find the lengths of both linked lists first.

If the lists have different lengths, move the pointer of the longer list forward by the length difference.

After that, both pointers are the same distance from the end.

Then move both pointers one step at a time.

The first point where:

    currA == currB

is the intersection node.

If there is no intersection, both pointers eventually become `null`.

---

## Steps

### Step 1 — Find Length of List A

    while (currA != null) {
        currA = currA.next;
        m++;
    }

### Step 2 — Find Length of List B

    while (currB != null) {
        currB = currB.next;
        n++;
    }

### Step 3 — Reset Both Pointers

After calculating the lengths, both pointers are `null`.

Reset them:

    currA = headA;
    currB = headB;

### Step 4 — Align the Pointers

If List A is longer:

    skipA = m - n

Move `currA` forward by `skipA` nodes.

If List B is longer:

    skipB = n - m

Move `currB` forward by `skipB` nodes.

Now both pointers have the same number of nodes remaining until the end.

### Step 5 — Find Intersection

Move both pointers together:

    while (currA != null) {

        if (currA == currB) {
            return currA;
        }

        currA = currA.next;
        currB = currB.next;
    }

If they never meet, return:

    null

---

## Example

    List A:

    1 -> 2 -> 3 -> 6 -> 7

    List B:

    4 -> 5 -> 6 -> 7

Lengths:

    A = 5
    B = 4

Difference:

    5 - 4 = 1

Move List A pointer one step forward.

Now:

    currA -> 2
    currB -> 4

Both pointers now have the same number of nodes remaining.

Move them together:

    2 -> 3 -> 6 -> 7
    4 -> 5 -> 6 -> 7

They meet at:

    6

Therefore:

    return currA

---

## Important Point

Use:

    currA == currB

Do not compare:

    currA.data == currB.data

Two different nodes can contain the same value but are not an intersection.

---

## Complexity

- Time: O(n + m)
- Space: O(1)

---

## Java File

    _02_TwoPointers.java

---

## Status

✅ Solved