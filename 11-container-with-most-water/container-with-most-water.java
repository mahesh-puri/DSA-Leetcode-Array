class Solution {
    public int maxArea(int[] height) {
        // Initialize variables:
        // maxArea to keep track of the maximum water area found.
        // left pointer starting from the beginning of the array.
        // right pointer starting from the end of the array.
        int maxArea = 0, left = 0, right = height.length - 1;

        // Iterate while the left pointer is less than the right pointer.
        while (left < right) {
            // Calculate the area formed between the lines at the left and right pointers.
            // The height is determined by the shorter line (to ensure water doesn't spill over),
            // and the width is the distance between the two pointers.
            int area = Math.min(height[left], height[right]) * (right - left);

            // Update maxArea if the newly calculated area is greater.
            if (area > maxArea) {
                maxArea = area;
            }

            // Move the pointers to explore potentially larger areas:
            // - If the line at the left pointer is shorter, move the left pointer to the right.
            // - Otherwise, move the right pointer to the left.
            // This strategy aims to find taller lines that might form a larger area.
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        // Return the maximum area found.
        return maxArea;
    }
}
