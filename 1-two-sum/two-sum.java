class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> twoSumCompliments = new HashMap<>();

        for(int index = 0 ; index < nums.length ; index++ ){
            Integer complimentNum = target - nums[index];
            
            if(twoSumCompliments.containsKey(nums[index])){
                Integer complimentNumIndex = twoSumCompliments.get(nums[index]);
                return new int[]{complimentNumIndex, index};
            }
            twoSumCompliments.put(complimentNum, index);
        }
        return new int[]{};
    }
}