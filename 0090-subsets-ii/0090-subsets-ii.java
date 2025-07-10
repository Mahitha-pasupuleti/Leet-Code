class Solution {
    private void generateSubsets(int[] nums, int start, List<List<Integer>> result, List<Integer> subResult) {
        result.add(new ArrayList<>(subResult));
        for ( int i=start; i<nums.length; i++ ) {
            if ( i>start && nums[i] == nums[i-1] ) continue;
            subResult.add(nums[i]);
            generateSubsets(nums, i+1, result, subResult);
            subResult.remove(subResult.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subResult = new ArrayList<>();
        Arrays.sort(nums);
        generateSubsets(nums, 0, result, subResult);
        return result;
    }
}