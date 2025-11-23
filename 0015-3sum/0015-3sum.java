class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> result = new HashSet<>();
        // List<List<Integer>> result = new ArrayList<>();
        for ( int i=0; i<n-1; i++ ) {
            if ( i>0 && nums[i] == nums[i-1] ) continue;
            int rem = 0 - nums[i];
            // find two values giving rem
            Map<Integer, Integer> map = new HashMap<>();
            for ( int j=i+1; j<n; j++ ) {
                // if ( j > i+1 && nums[j] == nums[j-1] ) continue;
                int diff = rem - nums[j];
                if ( map.containsKey(diff) ) {
                    List<Integer> subResult = new ArrayList<>(List.of(nums[i], nums[j], diff));
                    // Collections.sort(subResult);
                    result.add(subResult);
                }
                map.put(nums[j], j);
            }
        }
        return new ArrayList<>(result);
    }
}