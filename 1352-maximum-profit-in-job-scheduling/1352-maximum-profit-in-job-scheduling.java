import java.util.*;

class Solution {
    private int findNextIndex(int targetEnd, int[][] jobs) {
        int lo = 0, hi = jobs.length, ans = jobs.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (jobs[mid][0] >= targetEnd) { 
                ans = mid;
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    private int solve(int i, int[][] jobs, int[] memo) {
        if (i >= jobs.length) return 0;
        if (memo[i] != -1) return memo[i];

        // option 1: skip
        int notTake = solve(i + 1, jobs, memo);

        // option 2: take
        int nextIndex = findNextIndex(jobs[i][1], jobs);
        int take = jobs[i][2] + solve(nextIndex, jobs, memo);

        return memo[i] = Math.max(take, notTake);
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        // sort by start time
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        int[] memo = new int[n];
        Arrays.fill(memo, -1);

        return solve(0, jobs, memo);
    }
}
