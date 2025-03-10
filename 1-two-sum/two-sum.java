class Solution {
    public int[] twoSum(int[] nums, int target) {
    
        // Brute force : iterating over each element and checking the addition with every other element,
        // if addition is equals to the target then we found our two-sum indices.
        //
        // for(int i = 0; i<nums.length; i++){
        //     for(int j=i+1; j<nums.length; j++){
        //         if(nums[i] + nums[j] == target){
        //             return new int[]{i, j};
        //         }
        //     }
        // }
        // return nums;
        //

        // Optimal Solution : 

        Map<Integer, Integer> complementNumsMap = new HashMap<>();

        for(int index = 0; index < nums.length; index++){
            Integer complementNum = target - nums[index];
            
            if(complementNumsMap.containsKey(nums[index])){
                return new int[]{complementNumsMap.get(nums[index]), index};
            }
            complementNumsMap.put(complementNum, index);
        }
        return nums;
    }
}