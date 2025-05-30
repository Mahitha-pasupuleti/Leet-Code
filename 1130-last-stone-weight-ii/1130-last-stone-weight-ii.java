class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totalWeight = 0;
        int numStones = stones.length;

        // Calculate the total weight of all stones
        for (int i = 0; i < numStones; i++) {
            totalWeight += stones[i];
        }

        int target = totalWeight / 2;

        // dp[i][j] = true if a subset of the first i stones can sum to j
        boolean[][] dp = new boolean[numStones + 1][target + 1];

        // A subset sum of 0 is always possible: the empty subset
        for (int i = 0; i <= numStones; i++) {
            dp[i][0] = true;
        }

        // No subset can be formed from 0 stones with positive sum
        for (int j = 1; j <= target; j++) {
            dp[0][j] = false;
        }

        // Build the DP table
        for (int i = 1; i <= numStones; i++) {
            for (int j = 1; j <= target; j++) {
                if (stones[i - 1] <= j) {
                    // Option to include the current stone or not
                    dp[i][j] = dp[i - 1][j - stones[i - 1]] || dp[i - 1][j];
                } else {
                    // Cannot include the stone since it's larger than the target
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Find the closest sum to half of totalWeight (to minimize difference)
        int bestPossibleHalfSum = 0;
        for (int j = target; j >= 0; j--) {
            if (dp[numStones][j]) {
                bestPossibleHalfSum = j;
                break;
            }
        }

        // The minimum possible difference is totalWeight - 2 * bestPossibleHalfSum
        return totalWeight - 2 * bestPossibleHalfSum;
    }
}
