class Solution {
    public void backtracking(int index, int n, int k, List<Integer> subResult, List<List<Integer>> result) {

        if ( subResult.size() == k ) {
            result.add(new ArrayList<>(subResult));
            return;
        }
        for ( int i=index; i<=n; i++ ) {
            subResult.add(i);
            backtracking(i+1, n, k, subResult, result);
            subResult.remove(subResult.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        
        List<Integer> subResult = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        backtracking(1, n, k, subResult, result);

        return result;
    }
}