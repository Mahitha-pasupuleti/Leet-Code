class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;

        Stack<Integer> stack = new Stack<>();
        int s3 = Integer.MIN_VALUE; // This will represent the "2" in the 132 pattern

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // If we find a number smaller than s3, we found a 132 pattern
            if (nums[i] < s3) return true;

            // While current number is greater than the top of stack,
            // update s3 to the popped element (potential nums[k])
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                s3 = stack.pop(); // This popped element is the largest "2" less than current "3"
            }

            // Push current number as a potential "3" candidate (nums[j])
            stack.push(nums[i]);
        }

        return false;
    }
}
