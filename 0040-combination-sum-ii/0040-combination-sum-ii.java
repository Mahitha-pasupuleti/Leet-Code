class Solution {

    public void solve(int start, int n, int[] candidates, int target, int remain,
    List<Integer> temp, List<List<Integer>> result) {
        if ( remain == 0 ) {
            result.add(new ArrayList<>(temp));
            return;
        }
        else if ( remain < 0 ) {
            return;
        }
        else {
            for ( int i=start; i<n; i++ ) {
                if ( i > start && candidates[i] == candidates[i-1] ) continue;
                temp.add(candidates[i]);
                solve(i+1, n, candidates, target, remain-candidates[i], temp, result);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        // for ( int i=0; i<candidates.length; i++ ) {
        //     System.out.print(candidates[i]);
        // }

        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        solve(0, candidates.length, candidates, target, target, temp, result);
        return result;
    }
}