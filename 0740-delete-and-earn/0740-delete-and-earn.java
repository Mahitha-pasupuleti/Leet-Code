class Solution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n + 1]; // dp[n] = 0 by default

        for (int start = n - 1; start >= 0; start--) {
            int i = start + 1;
            int val = nums[start];
            int earnedPoints = nums[start];

            // collect duplicates
            while (i < n && nums[i] == val) {
                earnedPoints += val;
                i++;
            }

            // skip all nums == val + 1
            while (i < n && nums[i] - val == 1) {
                i++;
            }

            int take = earnedPoints + dp[i];
            int notTake = dp[start + 1];
            dp[start] = Math.max(take, notTake);
        }

        return dp[0];
    }
}
