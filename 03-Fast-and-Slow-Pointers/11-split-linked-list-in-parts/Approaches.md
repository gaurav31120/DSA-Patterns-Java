# Approach 01 — ArrayList

## Idea

Store every node of the linked list in an `ArrayList<Node>`.

This allows us to access nodes directly using their index.

After storing the nodes, calculate how many nodes each part should contain.

---

## Steps

1. Traverse the linked list and store every node in an ArrayList.
2. Find the total number of nodes.
3. Calculate:

    eachPartLength = len / k
    extra = len % k

4. The first `extra` parts receive one additional node.
5. Create a `Node[]` of size `k`.
6. For each part:
   - Store the head of the part in `parts[i]`.
   - Connect the required nodes.
   - Set the last node's `next` to `null`.
   - Move the index to the next unused node.
7. Return `parts`.

---

## Example

    Input:

    1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
    k = 3

    len = 10
    eachPartLength = 3
    extra = 1

    Part sizes:

    4, 3, 3

    Result:

    Part 1: 1 -> 2 -> 3 -> 4
    Part 2: 5 -> 6 -> 7
    Part 3: 8 -> 9 -> 10

---

## Important Point

`parts[i]` stores only the head of the current part.

For example:

    parts[0] -> 1 -> 2 -> 3 -> 4

It does not store every node separately.

---

## Edge Case

If:

    k > len

then the remaining parts are:

    null

Example:

    1 -> 2 -> 3
    k = 5

Result:

    Part 1: 1
    Part 2: 2
    Part 3: 3
    Part 4: null
    Part 5: null

---

## Complexity

- Time: O(n + k)
- Space: O(n + k)

---

## Java File

    _01_ArrayList.java

---

-------------------------------------------------------------------------

# Approach 02 — Length & Traversal

## Idea

First find the total number of nodes in the linked list.

Then divide the nodes as evenly as possible among `k` parts.

Calculate:

    baseSize = len / k
    extra = len % k

Every part gets `baseSize` nodes.

The first `extra` parts get one additional node.

For example:

    len = 10
    k = 3

    baseSize = 3
    extra = 1

So the part sizes are:

    4, 3, 3

---

## Steps

### Step 1 — Find Length

Traverse the linked list and count the nodes.

    int len = 0;

    while (curr != null) {
        len++;
        curr = curr.next;
    }

---

### Step 2 — Calculate Part Sizes

    int baseSize = len / k;
    int extra = len % k;

The first `extra` parts get one additional node.

Example:

    len = 10
    k = 3

    baseSize = 3
    extra = 1

Therefore:

    Part 1 = 4 nodes
    Part 2 = 3 nodes
    Part 3 = 3 nodes

---

### Step 3 — Reset the Pointer

After calculating the length, `curr` is `null`.

Reset it to the beginning:

    curr = head;

---

### Step 4 — Create Result Array

The result must contain exactly `k` parts.

    Node[] parts = new Node[k];

Each element stores the head of one part.

---

### Step 5 — Create Each Part

For every part:

1. Check whether nodes are still available.
2. Calculate the current part size.
3. Store the current node as the part head.
4. Move to the last node of the current part.
5. Save the next node.
6. Disconnect the current part.
7. Continue from the next node.

The head of the current part is stored using:

    parts[i] = curr;

---

### Step 6 — Disconnect the Part

Suppose the current part is:

    1 -> 2 -> 3 -> 4 -> 5

and the current part size is `4`.

The last node is `4`.

Save the next part:

    Node next = last.next;

Then disconnect:

    last.next = null;

Now:

    Part 1:
    1 -> 2 -> 3 -> 4 -> null

and:

    next -> 5

So the next iteration can start from node `5`.

---

## Example

Input:

    1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10

    k = 3

Length:

    10

Base size:

    10 / 3 = 3

Extra:

    10 % 3 = 1

Part sizes:

    4, 3, 3

Result:

    Part 1: 1 -> 2 -> 3 -> 4
    Part 2: 5 -> 6 -> 7
    Part 3: 8 -> 9 -> 10

---

## Edge Case

If `k` is greater than the number of nodes:

    1 -> 2 -> 3

    k = 5

Result:

    Part 1: 1
    Part 2: 2
    Part 3: 3
    Part 4: null
    Part 5: null

When `curr == null`, the remaining parts are simply `null`.

---

## Complexity

- Time: O(n + k)
- Space: O(k) for the result array
- Auxiliary Space: O(1)

---

## Java File

    _02_LengthAndTraversal.java

---

## Status

✅ Solved