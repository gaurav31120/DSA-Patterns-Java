## Approach 01 — Stack / StringBuilder — Time: O(n), Space: O(n)

### Idea

Process each string from left to right and build the final string after
applying all backspaces.

A normal character is added to the `StringBuilder`.

A `#` removes the last character when one exists.

### Steps

1. Create a `StringBuilder`.
2. Traverse the string character by character.
3. If the character is normal, append it.
4. If the character is `#`, remove the last character if the builder
   is not empty.
5. Return the processed string.
6. Process both strings and compare them.

### Example

For:

`"ab#c"`

Processing:

`a → ab → a → ac`

Final string:

`"ac"`

### Complexity

- **Time:** O(n)
- **Space:** O(n)

### Status

✅ Completed — Seen