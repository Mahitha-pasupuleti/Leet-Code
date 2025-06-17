class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        /*
            \U0001f4cc SHORT NOTES:
            - Goal: Find all unique quadruplets (a, b, c, d) such that a + b + c + d == target.
            - Sort the array to apply two-pointer efficiently and handle duplicates easily.
            - Fix the first two numbers using nested loops.
            - Use two-pointer approach for the remaining two numbers.
            - Skip duplicates at all four levels to ensure unique quadruplets.
            - Use long for sum to avoid integer overflow.

            \U0001f50d Example:
            Input: nums = [1,0,-1,0,-2,2], target = 0
            Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

            ⏱️ TIME COMPLEXITY: O(n³)
              - Outer loop (i): O(n)
              - Second loop (j): O(n)
              - Two-pointer search (k, l): O(n)
              - Total: O(n³)

            \U0001f4be SPACE COMPLEXITY: O(1) (excluding result list)
        */

        Arrays.sort(nums);  // Sorting helps skip duplicates and apply two-pointer technique
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        // Fix first element of quadruplet
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Fix second element of quadruplet
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicate values for j
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int k = j + 1;     // Start pointer
                int l = n - 1;     // End pointer

                while (k < l) {
                    // Use long to avoid integer overflow when summing
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target) {
                        // Add the valid quadruplet to result
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));

                        // Skip duplicates for k and l
                        while (k < l && nums[k] == nums[k + 1]) k++;
                        while (k < l && nums[l] == nums[l - 1]) l--;

                        // Move both pointers inward
                        k++;
                        l--;
                    } else if (sum < target) {
                        k++;  // Need a larger sum
                    } else {
                        l--;  // Need a smaller sum
                    }
                }
            }
        }

        return result;
    }
}