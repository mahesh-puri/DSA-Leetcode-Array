class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        if(nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        Set<List<Integer>> uniqueSet = new HashSet<>();

        for(int index = 0; index < nums.length-2; index++){

            int left = index+1, right = nums.length-1;
            while(left < right){
                int sum = nums[index] + nums[left] + nums[right];

                if(sum == 0){
                    uniqueSet.add(Arrays.asList(nums[index], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum > 0){
                    right--;
                } else{
                    left++;
                }
            }
        }
    return new ArrayList<>(uniqueSet);
    }
}