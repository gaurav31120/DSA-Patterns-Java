# Approach 01 — ArrayList

## Idea

Store all node values of the linked list in an `ArrayList`.

Once the values are stored, we can use two indices:

    left = 0
    right = n - 1

The first node and last node form a twin pair.

Then move both indices toward the center:

    left++
    right--

For every pair, calculate:

    values[left] + values[right]

and keep track of the maximum twin sum.

---

## Example

Input:

    5 -> 4 -> 2 -> 1

Store the values:

    [5, 4, 2, 1]

Start:

    left = 0
    right = 3

First twin pair:

    5 + 1 = 6

Move:

    left = 1
    right = 2

Second twin pair:

    4 + 2 = 6

Maximum:

    6

Output:

    6

---

## Steps

### Step 1 — Store Values

Traverse the linked list and add each value to the ArrayList.

    List<Integer> values = new ArrayList<>();

    Node curr = head;

    while (curr != null) {
        values.add(curr.data);
        curr = curr.next;
    }

---

### Step 2 — Initialize Two Indices

    int left = 0;
    int right = values.size() - 1;

`left` starts from the beginning.

`right` starts from the end.

---

### Step 3 — Calculate Twin Sums

Continue while:

    left < right

For each pair:

    int twinSum = values.get(left) + values.get(right);

Update the maximum twin sum.

---

### Step 4 — Move Toward the Center

After processing a pair:

    left++;
    right--;

This moves to the next twin pair.

---

## Important Point

Twin nodes are based on their positions.

For:

    5 -> 4 -> 2 -> 1

The pairs are:

    5 <-> 1
    4 <-> 2

We do not compare adjacent nodes.

---

## Complexity

- Time: O(n)
- Space: O(n)

---

## Java File

    _01_ArrayList.java

---

## Status

✅ Solved

----------------------------------------------------------------------------

# Approach 02 — Fast & Slow Pointers + Reverse Second Half

## Idea

A linked list cannot move backward, but twin nodes need to be compared from opposite ends.

For example:

    5 -> 4 -> 2 -> 1

Twin pairs are:

    5 <-> 1
    4 <-> 2

To compare these pairs efficiently:

1. Find the beginning of the second half using Fast & Slow Pointers.
2. Reverse the second half.
3. Compare the first half with the reversed second half.
4. Keep track of the maximum twin sum.

---

## Step 1 — Find the Second Half

Initialize:

    slow = head
    fast = head

Move:

    slow -> 1 node
    fast -> 2 nodes

using:

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

For:

    5 -> 4 -> 2 -> 1

`slow` reaches:

    2

So the list is divided into:

    First half:
    5 -> 4

    Second half:
    2 -> 1

---

## Step 2 — Reverse the Second Half

Reverse:

    2 -> 1

into:

    1 -> 2

Use the standard linked-list reversal:

    prev
    curr
    next

After reversal:

    First half:
    5 -> 4

    Reversed second half:
    1 -> 2

---

## Step 3 — Compare Twin Nodes

Initialize:

    first = head
    second = reversed second half

Now calculate:

    first.data + second.data

For the example:

    5 + 1 = 6
    4 + 2 = 6

Maximum:

    6

---

## Example

Input:

    5 -> 4 -> 2 -> 1

Find second half:

    5 -> 4 | 2 -> 1

Reverse second half:

    5 -> 4 | 1 -> 2

Compare:

    5 + 1 = 6
    4 + 2 = 6

Output:

    6

---

## Why This Works

The second half is reversed so that the last node of the original list becomes the first node of the reversed half.

Therefore:

    first node of first half
                +
    first node of reversed second half

represents a twin pair.

The same process continues for every twin pair.

---

## Complexity

- Time: O(n)
- Space: O(1)

The linked list is traversed a constant number of times.

No ArrayList or additional data structure is required.

---

## Java File

    _02_FastSlowReverse.java

---

## Status

✅ Solved