class Solution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n + 1]; // dp[n] = 0

        for (int i = n - 1; i >= 0; i--) {
            int nextIndex = i + 1;
            int val = nums[i];
            int earnedPoints = val;

            // collect duplicates
            while (nextIndex < n && nums[nextIndex] == val) {
                earnedPoints += val;
                nextIndex++;
            }

            // skip adjacent numbers
            while (nextIndex < n && nums[nextIndex] - val == 1) {
                nextIndex++;
            }

            int take = earnedPoints + dp[nextIndex];
            int notTake = dp[i + 1];

            dp[i] = Math.max(take, notTake);
        }

        return dp[0];
    }
}