read/write ith element of dynamic array : O(1)
insert/remove end element of dynamic array : O(1)
insert middle element of dynamic array : O(n)
remove middle element of dynamic array : O(n)

The key insight: copying is expensive, but each copy doubles the array, so copies get exponentially less frequent. That trade-off is what makes it O(1) amortized.
Aggregate method (count total work over n pushes):
- Total work to grow = 1 + 2 + 4 + 8 + ... + n ≈ 2n
- Other pushes are O(1) each ≈ n
- Total ≈ 3n over n operations → 3n/n = O(1) amortized per push.
