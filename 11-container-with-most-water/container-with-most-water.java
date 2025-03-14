class Solution {
    public int maxArea(int[] height) {
        
        int maxArea = 0, left = 0, right = height.length - 1;

        while(left < right){
            
            int area = (height[left] < height[right] ? height[left] : height[right]) * (right - left);

            if(area > maxArea){
                maxArea = area;
            }

            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}