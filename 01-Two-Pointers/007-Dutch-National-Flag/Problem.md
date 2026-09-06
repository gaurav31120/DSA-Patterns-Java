# P007 — Dutch National Flag Problem

## Pattern

Two Pointers

## Difficulty

Medium

## Problem

Given an array containing only `0`, `1`, and `2`, sort the array
in-place so that all `0`s come first, followed by all `1`s, and
then all `2`s.

You must solve the problem without using the library's sorting
function.

## Example 1

Input:

arr = [2, 0, 2, 1, 1, 0]

Output:

[0, 0, 1, 1, 2, 2]

## Example 2

Input:

arr = [2, 0, 1]

Output:

[0, 1, 2]

## Example 3

Input:

arr = [0]

Output:

[0]

## Example 4

Input:

arr = [1]

Output:

[1]

## Constraints

- `1 <= arr.length <= 300`
- `arr[i]` is either `0`, `1`, or `2`

## Requirements

- Sort the array in-place.
- Do not use a built-in sorting function.
- Aim for O(n) time.
- Use O(1) extra space.

## Key Learning

The Dutch National Flag algorithm divides the array into three
regions:

- `0` → left region
- `1` → middle region
- `2` → right region

The three-pointer approach maintains these regions while scanning
the array only once.