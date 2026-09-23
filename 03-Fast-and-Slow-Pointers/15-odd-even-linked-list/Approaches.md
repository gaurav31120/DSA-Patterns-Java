# Approach 01 — Separate Odd and Even Chains

## Idea

Create two separate linked-list chains:

- Odd-position chain
- Even-position chain

Traverse the original linked list once.

If the current node is at an odd position, add it to the odd chain.

If the current node is at an even position, add it to the even chain.

Finally connect the odd chain to the even chain.

The node values are not changed. We only change the `next` pointers.

---

## Example

Input:

    1 -> 2 -> 3 -> 4 -> 5

Odd positions:

    1 -> 3 -> 5

Even positions:

    2 -> 4

Connect them:

    1 -> 3 -> 5 -> 2 -> 4

---

## Pointers Used

Use four pointers:

    oddHead
    oddTail
    evenHead
    evenTail

### oddHead

Stores the first node of the odd-position chain.

### oddTail

Stores the last node of the odd-position chain.

### evenHead

Stores the first node of the even-position chain.

### evenTail

Stores the last node of the even-position chain.

---

## Step 1 — Traverse the List

Start with:

    curr = head
    position = 1

For every node:

    position % 2 == 1

means the node is at an odd position.

Otherwise, it is at an even position.

---

## Step 2 — Add Node to Odd Chain

If the position is odd:

    if (oddHead == null) {
        oddHead = curr;
        oddTail = curr;
    } else {
        oddTail.next = curr;
        oddTail = curr;
    }

The first odd node becomes both the head and tail.

Every following odd node is attached after `oddTail`.

---

## Step 3 — Add Node to Even Chain

If the position is even:

    if (evenHead == null) {
        evenHead = curr;
        evenTail = curr;
    } else {
        evenTail.next = curr;
        evenTail = curr;
    }

The first even node becomes both the head and tail.

Every following even node is attached after `evenTail`.

---

## Step 4 — Detach the Current Node

Before processing the next node, save:

    Node next = curr.next;

Then detach the current node:

    curr.next = null;

This prevents old links from interfering with the newly created chains.

---

## Step 5 — Move to the Next Node

    curr = next;
    position++;

Continue until `curr == null`.

---

## Step 6 — Connect the Two Chains

After the traversal:

    oddTail.next = evenHead;

This gives:

    Odd chain -> Even chain

Example:

    1 -> 3 -> 5
              \
               2 -> 4

Final:

    1 -> 3 -> 5 -> 2 -> 4

---

## Important Point

This problem is based on the **position of the node**, not the value.

For:

    2 -> 1 -> 3 -> 5 -> 6 -> 4 -> 7

Odd-position nodes:

    2 -> 3 -> 6 -> 7

Even-position nodes:

    1 -> 5 -> 4

Final:

    2 -> 3 -> 6 -> 7 -> 1 -> 5 -> 4

---

## Edge Cases

### Empty List

    head == null

Return:

    null

### One Node

    1

Return:

    1

### Two Nodes

    1 -> 2

Odd chain:

    1

Even chain:

    2

Final:

    1 -> 2

---

## Complexity

- Time: O(n)
- Space: O(1)

Only pointer variables are used. No extra list or array is created.

---

## Java File

    _01_SeparateChains.java

---

## Status

✅ Solved

-----------------------------

# Approach 02 — In-Place Two Pointers

## Idea

Rearrange the existing linked list so that all odd-position nodes come first, followed by all even-position nodes.

We do not change the node values and we do not create new nodes.

We only modify the `next` pointers.

For:

    1 -> 2 -> 3 -> 4 -> 5

the result should be:

    1 -> 3 -> 5 -> 2 -> 4

---

## Pointers Used

Use three pointers:

    odd
    even
    evenHead

### odd

Points to the current odd-position node.

### even

Points to the current even-position node.

### evenHead

Stores the first even-position node.

This is necessary because `even` moves forward, but we need the original even head at the end.

---

## Step 1 — Handle Small Lists

If the list has zero or one node, no rearrangement is required.

    if (head == null || head.next == null) {
        return head;
    }

---

## Step 2 — Initialize Pointers

    Node odd = head;
    Node even = head.next;
    Node evenHead = even;

For:

    1 -> 2 -> 3 -> 4 -> 5

we have:

    odd -> 1
    even -> 2
    evenHead -> 2

---

## Step 3 — Connect Odd Nodes

The next odd-position node is two nodes ahead.

    odd.next = odd.next.next;

Then move:

    odd = odd.next;

This creates:

    1 -> 3 -> 5

---

## Step 4 — Connect Even Nodes

The next even-position node is also two nodes ahead.

    even.next = even.next.next;

Then move:

    even = even.next;

This creates:

    2 -> 4

---

## Step 5 — Repeat

Continue while:

    even != null && even.next != null

Inside the loop:

    odd.next = odd.next.next;
    odd = odd.next;

    even.next = even.next.next;
    even = even.next;

---

## Step 6 — Connect Both Chains

After the loop:

    Odd chain:
    1 -> 3 -> 5

    Even chain:
    2 -> 4

Connect the end of the odd chain to the saved even head:

    odd.next = evenHead;

Final:

    1 -> 3 -> 5 -> 2 -> 4

---

## Important Point

This problem is based on the **position** of a node, not its value.

For:

    2 -> 1 -> 3 -> 5 -> 6 -> 4 -> 7

Odd-position nodes:

    2 -> 3 -> 6 -> 7

Even-position nodes:

    1 -> 5 -> 4

Final:

    2 -> 3 -> 6 -> 7 -> 1 -> 5 -> 4

---

## Edge Cases

### Empty List

    null

Return:

    null

### One Node

    1

Return:

    1

### Two Nodes

    1 -> 2

Result:

    1 -> 2

### Even Number of Nodes

    1 -> 2 -> 3 -> 4 -> 5 -> 6

Result:

    1 -> 3 -> 5 -> 2 -> 4 -> 6

---

## Complexity

- Time: O(n)
- Space: O(1)

---

## Java File

    _02_TwoPointers.java

---

## Status

✅ Solved