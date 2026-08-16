---
neetcode: 1
leetcode: 1929
title: Concatenation of Array
---

# Concatenation of Array

- **NeetCode:** #1
- **LeetCode:** #1929
- **Category:** Arrays & Hashing
- **Solution:** https://www.youtube.com/watch?v=68isPRHgcFQ&list=PLot-Xpze53ldOyuteC44ap08G1YvCc0Gy

## Problem
Given an integer array `nums` of length `n`, return an array `ans` of length `2n` where `ans[i] == nums[i]` and `ans[i + n] == nums[i]` for `0 <= i < n`. In other words, `ans` is `nums` followed by `nums`.

## Approach
Allocate `ans` of size `2 * n`. In a single pass, copy `nums[i]` into both `ans[i]` and `ans[i + n]`.

- **Time:** O(n)
- **Space:** O(n) for the output (no extra auxiliary space)

## Key ideas
- The second copy is just `nums` offset by `n`, so a single loop with two writes suffices.
- Can also be written as `nums + nums` (Kotlin `IntArray` supports `+` concatenation).

## Notes
- Edges: empty array returns empty, single element returns the element twice.
