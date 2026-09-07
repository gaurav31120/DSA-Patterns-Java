## Approach 01 — Brute Force — Time: O(n²), Space: O(1)

### Idea

Compare every pair of elements.

If two elements are equal, that value is the duplicate.

### Steps

1. Start with the first element.
2. Compare it with every element after it.
3. If both values are equal, return the value.
4. Repeat for all elements.
5. Return `-1` if no duplicate is found.

### Why It Works

Since the array contains one repeated number, comparing every pair
will eventually find the duplicate.

### Complexity

- **Time:** O(n²)
- **Space:** O(1)

### Status

✅ Completed

## Approach 02 — Sorting — Time: O(n log n), Space: O(1)

### Idea

Sort the array so that duplicate values become adjacent.

Then compare neighboring elements to find the duplicate.

### Steps

1. Sort the array.
2. Traverse the sorted array.
3. Compare each element with the next element.
4. If they are equal, return that value.
5. Return `-1` if no duplicate is found.

### Why It Works

After sorting, equal values are placed next to each other.

Therefore, the duplicate can be found by checking adjacent elements.

### Limitation

Sorting modifies the input array, so this approach violates the
problem's requirement of not modifying the array.

### Complexity

- **Time:** O(n log n)
- **Space:** O(1) auxiliary

### Status

⚠️ Conceptual / Skip

## Approach 03 — Fast & Slow Pointers — Time: O(n), Space: O(1)

### Idea

Treat the array like a linked list where `arr[i]` is the next position.

The duplicate creates a cycle.

Use Fast & Slow Pointers to find the cycle and its starting point.

### Steps

#### Phase 1 — Find Meeting Point

1. Start `slow` and `fast` at `arr[0]`.
2. Move `slow` one step.
3. Move `fast` two steps.
4. Continue until they meet.

#### Phase 2 — Find Cycle Start

1. Reset `slow` to `arr[0]`.
2. Move both pointers one step at a time.
3. When they meet, that value is the duplicate.

### Why It Works

The duplicate creates a cycle in the array's index path.

Floyd's algorithm finds the cycle and then identifies its starting point,
which is the duplicate number.

### Complexity

- **Time:** O(n)
- **Space:** O(1)

### Status

✅ Completed