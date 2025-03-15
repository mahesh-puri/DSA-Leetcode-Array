class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        // Initialize the result list to store the triplets
        List<List<Integer>> result = new ArrayList<>();

        // Sort the array to facilitate the two-pointer approach
        Arrays.sort(nums);

        // Iterate through the array, considering each number as a potential first element of a triplet
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements to avoid duplicate triplets in the result
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // If the current number is greater than zero, break the loop
            // Since the array is sorted, no three positive numbers can sum to zero
            if (nums[i] > 0) {
                break;
            }

            // Initialize two pointers for the current subarray
            int left = i + 1; // The element immediately after nums[i]
            int right = nums.length - 1; // The last element in the array

            // Use the two-pointer technique to find pairs that, together with nums[i], sum to zero
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // Check if the sum of the triplet is zero
                if (sum == 0) {
                    // Add the triplet to the result list
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move the left pointer to the right, skipping over duplicate elements
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Move the right pointer to the left, skipping over duplicate elements
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move both pointers inward to continue searching for other potential triplets
                    left++;
                    right--;
                } else if (sum < 0) {
                    // If the sum is less than zero, move the left pointer to the right
                    // to increase the sum
                    left++;
                } else {
                    // If the sum is greater than zero, move the right pointer to the left
                    // to decrease the sum
                    right--;
                }
            }
        }
        // Return the list of triplets that sum to zero
        return result;
    }
}