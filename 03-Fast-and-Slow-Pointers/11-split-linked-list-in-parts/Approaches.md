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

## Status

⚠️ Stuck