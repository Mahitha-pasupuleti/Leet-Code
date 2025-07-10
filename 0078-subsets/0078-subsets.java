class Solution {
    public void generateSubsets(List<List<Integer>> result, List<Integer> subResult, int[] nums, int i) {
        if ( i == nums.length ) {
            result.add(new ArrayList<>(subResult));
            return;
        }
        subResult.add(nums[i]);
        generateSubsets(result, subResult, nums, i+1);
        subResult.remove(subResult.size()-1);
        generateSubsets(result, subResult, nums, i+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subResult = new ArrayList<>();
        // Arrays.sort(nums);
        generateSubsets(result, subResult, nums, 0);
        return result;
    }
}