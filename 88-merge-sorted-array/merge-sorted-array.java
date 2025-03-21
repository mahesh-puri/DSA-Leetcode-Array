class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       
// Pointers to track the last elements of nums1 and nums2
        int index1 = m - 1;  // Last valid element index in nums1
        int index2 = n - 1;  // Last element index in nums2
        int mergeIndex = m + n - 1;  // Last index of nums1 (final merged position)

        // Merge elements from the back to avoid overwriting elements in nums1
        while (index2 >= 0) {
            // If there are still elements left in nums1 and it is greater than nums2's current element
            if (index1 >= 0 && nums1[index1] > nums2[index2]) {
                nums1[mergeIndex] = nums1[index1];
                index1--; // Move nums1 pointer left
            } else {
                nums1[mergeIndex] = nums2[index2];
                index2--; // Move nums2 pointer left
            }
            mergeIndex--; // Move merged position left
        }


    }

}