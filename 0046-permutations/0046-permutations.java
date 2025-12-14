class Solution {
    private void solve(int[] nums, List<List<Integer>> result, List<Integer> subResult, boolean[] visited) {
        if ( subResult.size() == nums.length ) {
            result.add(new ArrayList<>(subResult));
            return;
        }
        for ( int i=0; i<nums.length; i++ ) {
            if ( visited[i] ) continue;
            visited[i] = true;
            subResult.add(nums[i]);
            solve(nums, result, subResult, visited);
            visited[i] = false;
            subResult.remove(subResult.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subResult = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        solve(nums, result, subResult, visited);
        return result;
    }
}