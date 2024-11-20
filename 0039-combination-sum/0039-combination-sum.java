class Solution {

    /*
    public void findCombinations(int[] candidates, int target, int start, List<Integer> templist, List<List<Integer>> list) {
        if ( target < 0 ) {
            return;
        }
        else if ( target == 0 ) {
            list.add(new ArrayList<>(templist));
        } 
        else {
            for ( int i=start; i<candidates.length; i++ ) {
                templist.add(candidates[i]);
                findCombinations(candidates, target-candidates[i], i, templist, list);
                templist.remove(templist.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

        findCombinations(candidates, target, 0, new ArrayList<>(), result);
        return result;

    }
    */

    public void solve(int start, int n, int[] candidates, int target, int remain
    , List<Integer> temp, List<List<Integer>> result) {

        if ( remain == 0 ) {
            result.add(new ArrayList<>(temp));
            // System.out.println(result);
            // System.out.println("THere");
            return;
        }
        else if ( remain < 0 ) {
            // System.out.println("Here");
            return;
        }
        else {
            for ( int i=start; i<candidates.length; i++ ) {
                temp.add(candidates[i]);
                // System.out.println(temp);
                solve(i, n, candidates, target, remain-candidates[i], temp, result);
                temp.remove(temp.size()-1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int n = candidates.length;
        Arrays.sort(candidates);

        solve(0, n, candidates, target, target, temp, result);
        return result;
    }

}