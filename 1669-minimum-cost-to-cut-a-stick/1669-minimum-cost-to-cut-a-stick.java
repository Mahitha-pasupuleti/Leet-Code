class Solution {
    Map<String, Integer> memo;
    private int solve(int start, int end, int rodStart, int rodEnd, int[] nums) {
        if ( start > end ) return 0;
        String key = new String(start + ":" + end + ":" + rodStart + ":" + rodEnd);
        if ( memo.containsKey(key) ) return memo.get(key);
        int result = Integer.MAX_VALUE;
        for ( int i=start; i<=end; i++ ) {
            int left = solve(start, i-1, rodStart, nums[i], nums);
            int right = solve(i+1, end, nums[i], rodEnd, nums);
            int current = rodEnd - rodStart + left + right;
            result = Math.min(result, current);
        }
        memo.put(key, result);
        return result;
    }
    public int minCost(int n, int[] cuts) {
        memo = new HashMap<>();
        Arrays.sort(cuts);
        return solve(0, cuts.length-1, 0, n, cuts);
    }
}