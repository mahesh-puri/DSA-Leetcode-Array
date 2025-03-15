class Solution {
    public int removeDuplicates(int[] nums) {
        
        // Single Pointer Approach
        int count = 0;
        for(int i = 0; i <= nums.length-1; i++){
            if(i == nums.length-1 || nums[i] != nums[i+1]){
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
}