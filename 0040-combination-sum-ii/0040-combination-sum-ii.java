class Solution {
    public void generateSubset(List<List<Integer>> result, List<Integer> subresult, int[] candidates, int target, int remain, int start) {
        if ( remain == 0 ) result.add(new ArrayList<>(subresult));
        else if ( remain < 0 ) return;
        else {
            for ( int i=start; i<candidates.length; i++ ) {
                if ( i>start && candidates[i] == candidates[i-1]) continue;
                subresult.add(candidates[i]);
                generateSubset(result, subresult, candidates, target, remain-candidates[i], i+1);
                subresult.remove(subresult.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        generateSubset(result , new ArrayList<>(), candidates, target, target, 0);
        return result;
    }
}