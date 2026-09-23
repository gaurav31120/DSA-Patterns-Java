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