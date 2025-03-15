class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        int resultSum = nums[0] + nums[1] + nums[2];
        int minDifference = Integer.MAX_VALUE;

        for(int index = 0; index < nums.length - 2; index++){
            // if(index > 0 && nums[index] == nums[index + 1]){
            //     continue;
            // }

            int left = index + 1, right = nums.length-1;

            while(left < right){
                int sum = nums[index] + nums[left] + nums[right];

                if(sum == target){
                    return target;
                }
                if(sum < target){
                    left++;
                } else {
                    right--;
                }

                // while(left < right && nums[left] == nums[left + 1] ){
                //     left++;
                // }

                // while(right > left && nums[right] == nums[right]) {
                //     right--;
                // }

                int diffToTarget = Math.abs(sum - target);

                if(diffToTarget < minDifference){
                    resultSum = sum;
                    minDifference = diffToTarget;
                }
            }
        }
        return resultSum;
    }
}