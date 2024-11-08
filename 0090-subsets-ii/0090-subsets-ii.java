class Solution {
    public void generateSubsets(int[] nums, int start, List<Integer> templist, List<List<Integer>> list) {
        list.add(new ArrayList<>(templist));
        // Set<Integer> mySet = new HashSet<>();
        for ( int i=start; i<nums.length; i++ ) {
            if ( i > start && nums[i] == nums[i-1]) {
                continue;
            }
            templist.add(nums[i]);
            generateSubsets(nums, i+1, templist, list);
            templist.remove(templist.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // List<Integer> templist = new ArrayList<>();
        Arrays.sort(nums);
        generateSubsets(nums, 0, new ArrayList<>(), list);
        return list;
    }
}