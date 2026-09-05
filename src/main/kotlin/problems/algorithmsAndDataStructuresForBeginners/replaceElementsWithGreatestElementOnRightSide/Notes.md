arr = [17,18,5,4,6,1]

Draw a diagram to make it clear

Brute solution use repeating sub arrays of diminishing length

But better solution:

new[0] = max(arr[1:5])

new[1] = max(arr[2:5])

Instead of recalculating max(arr[1:5]) we should store the max from arr[2:5] and compare it with arr[1]

new[0] = max(arr[1], new[1])

with the new solution we only need to compare two values to get maximum, this prevents the repeated work

to know new[i] we need to already know new[i+1] so we need to go through the array backwards, right to left

Base case: set arr[arr.size - 1] (last element in arr) to be -1

Side by side comparison (index, arr value, new value):

index:      0  1  2  3  4  5
arr:      [17, 18, 5, 4, 6, 1]
new:      [18,  6, 6, 6, 1, -1]
