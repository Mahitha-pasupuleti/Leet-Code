class Solution {
    public boolean solve(int index, int step, Set<Integer> isLand, int target, Map<String, Boolean> memo) {

        if ( step == 0 || index > target ) return false;

        String key = index + "_" + step;
        if ( memo.containsKey( key ) ) return memo.get( key );

        if ( index == target ) return true;
        if ( !isLand.contains(index) ) return false;

        if (   solve(index + step - 1, step - 1, isLand, target, memo)
            || solve(index + step, step, isLand, target, memo) 
            || solve(index + step + 1, step + 1, isLand, target, memo)  
        ) {
            memo.put(key, true);
            return true;
        }

        memo.put(key, false);
        return false;

    }
    public boolean canCross(int[] stones) {

        if ( stones[1] != 1 ) return false;

        int n = stones.length;

        // Memoization
        Map<String, Boolean> memo = new HashMap<>();

        Set<Integer> isLand = new HashSet<>();
        for ( int i=0; i<n; i++ ) {
            isLand.add(stones[i]);
        }

        return solve(1, 1, isLand, stones[n-1], memo);
    }
}