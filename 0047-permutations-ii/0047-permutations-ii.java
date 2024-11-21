class Solution {

    public void solve( int start, int[] nums, List<Integer> temp, List<List<Integer>> result, 
    boolean[] visited ) {
        if ( temp.size() == nums.length ) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for ( int i=0; i<nums.length; i++ ) {
            //if ( i>start && nums[i] == nums[i-1] ) continue;
            if ( visited[i] || ( i>0 && nums[i] == nums[i-1] && !visited[i-1] ) ) continue;
            visited[i] = true;
            temp.add(nums[i]);
            solve(i+1, nums, temp, result, visited);
            temp.remove(temp.size()-1);
            visited[i] = false;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        Arrays.sort(nums);

        solve(0, nums, temp, result, visited);
        // System.out.println(result);
        return result;
    }
}