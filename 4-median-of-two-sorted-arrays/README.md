<h2><a href="https://leetcode.com/problems/median-of-two-sorted-arrays">Median of Two Sorted Arrays</a></h2> <img src='https://img.shields.io/badge/Difficulty-Hard-red' alt='Difficulty: Hard' /><hr><p>Given two sorted arrays <code>nums1</code> and <code>nums2</code> of size <code>m</code> and <code>n</code> respectively, return <strong>the median</strong> of the two sorted arrays.</p>

<p>The overall run time complexity should be <code>O(log (m+n))</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [1,3], nums2 = [2]
<strong>Output:</strong> 2.00000
<strong>Explanation:</strong> merged array = [1,2,3] and median is 2.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [1,2], nums2 = [3,4]
<strong>Output:</strong> 2.50000
<strong>Explanation:</strong> merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>nums1.length == m</code></li>
	<li><code>nums2.length == n</code></li>
	<li><code>0 &lt;= m &lt;= 1000</code></li>
	<li><code>0 &lt;= n &lt;= 1000</code></li>
	<li><code>1 &lt;= m + n &lt;= 2000</code></li>
	<li><code>-10<sup>6</sup> &lt;= nums1[i], nums2[i] &lt;= 10<sup>6</sup></code></li>
</ul>



<p>&nbsp;</p>
<p>&nbsp;</p>

##
<h1 style="color: orange;">Solution Explanation</h1>


Understanding the problem of finding the median of two sorted arrays can be challenging, but let's break it down step-by-step in simple terms.

**What is the Median?**

The median is the middle value in a list of numbers. If the list has an odd number of elements, the median is the center number. If it's even, the median is the average of the two central numbers.

**The Problem:**

You're given two sorted arrays (lists) of numbers, and you need to find the median of the combined set without actually merging them. The goal is to do this efficiently, ideally in logarithmic time complexity, O(log(min(n, m))), where n and m are the lengths of the two arrays.

**Approach: Binary Search**

To achieve this efficiency, we use a technique called binary search. Here's a step-by-step explanation:

1. **Identify the Smaller Array:**
   - Always perform the binary search on the smaller array to minimize the number of comparisons. If the first array is larger than the second, swap them.

2. **Set Up Binary Search:**
   - Initialize two pointers, `low` and `high`, to represent the current search range within the smaller array. Initially, `low` is 0, and `high` is the length of the smaller array.

3. **Partition the Arrays:**
   - Calculate the partition indices for both arrays. The partition index divides each array into two parts: left and right.
   - For the smaller array: `partitionX = (low + high) / 2`
   - For the larger array: `partitionY = (total number of elements + 1) / 2 - partitionX`

4. **Handle Edge Cases:**
   - Determine the maximum value on the left side and the minimum value on the right side of each partition.
   - If a partition index is at the boundary (0 or the length of the array), assign negative or positive infinity accordingly to handle edge cases.

5. **Check Valid Partition:**
   - Verify if the current partitions are correct by checking:
     - `maxLeftX <= minRightY`
     - `maxLeftY <= minRightX`
   - If both conditions are met, you've found the correct partition.

6. **Calculate the Median:**
   - If the total number of elements is even, the median is the average of the maximum value on the left side and the minimum value on the right side.
   - If odd, the median is the maximum value on the left side.

7. **Adjust Search Range:**
   - If the partitions aren't correct:
     - If `maxLeftX > minRightY`, move the `high` pointer left.
     - If `maxLeftY > minRightX`, move the `low` pointer right.

8. **Repeat:**
   - Continue adjusting the search range until you find the correct partition.

**Code Implementation:**

Here's how this approach translates into Java code:

```java
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to minimize the number of binary search iterations
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length; // Length of the smaller array
        int y = nums2.length; // Length of the larger array

        int low = 0, high = x; // Binary search range within nums1

        while (low <= high) {
            // Partition indices for nums1 and nums2
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            // Handle edge cases where partition is at the boundary
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            // Check if we have found the correct partitions
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // If the combined length is even, the median is the average of the two middle values
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else { // If odd, the median is the maximum of the left side
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                // Move towards the left in nums1
                high = partitionX - 1;
            } else {
                // Move towards the right in nums1
                low = partitionX + 1;
            }
        }

        // If input arrays are not sorted or inputs are invalid
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}

```

**Understanding the Code:**

- **Base Case:** If `nums1` is larger than `nums2`, swap them to ensure the binary search is performed on the smaller array.

- **Binary Search Loop:** Adjust the `low` and `high` pointers based on the partition conditions until the correct partition is found.

- **Partition Calculation:** Determine where to partition each array so that the left and right halves contain the correct number of elements.

- **Edge Cases:** Handle scenarios where the partition is at the start or end of an array by assigning infinity values appropriately.

- **Median Calculation:** Once the correct partition is found, calculate the median based on whether the total number of elements is even or odd.

- **Exception Handling:** If no valid partition is found, throw an exception indicating the input arrays are not sorted.

This approach ensures an efficient solution to finding the median of two sorted arrays without merging them, achieving a time complexity of O(log(min(n, m))).

For a visual explanation and further insights into this algorithm, you might find the following video helpful:

 
