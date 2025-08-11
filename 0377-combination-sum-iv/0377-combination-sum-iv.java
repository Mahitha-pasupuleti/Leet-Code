class Solution {
    int[] dp;
    public int solve(int[] nums, int target) {
        if ( target == 0 ) return 1;
        if ( target < 0 ) return 0;
        if ( dp[target] != -1 ) return dp[target];

        int count = 0;
        for ( int i=0; i<nums.length; i++ ) {
            count += solve(nums, target-nums[i]);
        }
        return dp[target] = count;
    }
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target+1];
        Arrays.fill(dp, -1);
        return solve(nums, target); // 1
    }
}

/*
1️⃣ Knapsack (classic definition)
- You have items with weights and values.
- You want to maximize or minimize something (usually value) while staying within a capacity.
- Order of items does not matter — {1, 2} is the same as {2, 1}.
- Usually involves a boolean choice at each step: take it or skip it.
- State often depends on both index and remaining capacity.
Knapsack([1, 2, 3], target=4) would consider {1,3} and {3,1} the same.

2️⃣ Combination Sum IV (the LeetCode version)
- You’re counting all possible sequences that sum to target.
- Order does matter — [1, 2] and [2, 1] are different.
- Numbers can be reused unlimited times.
- There is no "skip this item forever" decision — you can always pick any number again.
- State depends only on remaining target, not on index.
Example for target = 4, nums = [1, 2, 3]:

Knapsack → Combinations without regard to order → "choose" logic.
Combination Sum IV → Permutations with repetition → "arrange" logic.
*/