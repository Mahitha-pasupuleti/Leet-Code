class Solution {

    // \U0001f504 Utility function to reverse elements in an array from index 'start' to 'end'
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        /*
            \U0001f4cc SHORT NOTES:
            - Problem: Rotate the array to the right by `k` steps.
            - Approach: Use in-place reversal (no extra space).
                1. Reverse the first (n - k) elements.
                2. Reverse the last k elements.
                3. Reverse the entire array.

            Example:
            nums = [1,2,3,4,5,6,7], k = 3
            Step 1: reverse(0,3)  -> [4,3,2,1,5,6,7]
            Step 2: reverse(4,6)  -> [4,3,2,1,7,6,5]
            Step 3: reverse(0,6)  -> [5,6,7,1,2,3,4]

            ✅ In-place operation with no extra memory used.

            ⏱️ TIME COMPLEXITY: O(n)
                - Each reverse is O(n), total 3 reversals: O(n)

            \U0001f4be SPACE COMPLEXITY: O(1)
                - No extra space used, operations are in-place.
        */

        int n = nums.length;
        int rotations = k % n; // Normalize k to be within bounds

        // Step 1: Reverse the first part
        reverse(nums, 0, n - rotations - 1);

        // Step 2: Reverse the second part
        reverse(nums, n - rotations, n - 1);

        // Step 3: Reverse the entire array
        reverse(nums, 0, n - 1);
    }
}