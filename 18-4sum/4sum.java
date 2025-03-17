class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>>  result = new ArrayList<>();

        // Edge case: if nums is null or has fewer than 4 elements, return empty list
        if (nums == null || nums.length < 4) {
            return result;
        }

        // Sort the array to facilitate the two-pointer approach
        Arrays.sort(nums);

        // Iterate through the array with the first pointer
        for(int first = 0; first < nums.length-3; first++){

            // Skip duplicate elements to avoid duplicate quadruplets
            if(first > 0 && nums[first] == nums[first - 1]){
                continue;
            }

            // Iterate through the array with the second pointer
            for(int second = first + 1; second < nums.length-2; second++){

                // Skip duplicate elements to avoid duplicate quadruplets
                if(second > first + 1 && nums[second] == nums[second - 1]){
                 continue;
                }

                int left = second + 1;
                int right = nums.length - 1;

                // Use the two-pointer technique to find the remaining two numbers
                while(left < right){

                    long sum = (long) nums[first] + nums[second] + nums[left] + nums[right];

                    if (sum == target){
                        result.add(Arrays.asList(nums[first], nums[second], nums[left], nums[right]));

                        // Move left pointer to the right, skipping over duplicates
                        while(left < right && nums[left] == nums[left + 1]){
                            left++;
                        }
                    
                        // Move right pointer to the left, skipping over duplicates
                        while(left < right && nums[right] == nums[right - 1]){
                            right--;
                        }

                        // Move both pointers inward after finding a valid quadruplet
                        left++;
                        right--;

                    } else if(sum < target){
                        left++;
                    } else {
                        right--;
                    }

                }

            }


        }

        return result;

    }

}