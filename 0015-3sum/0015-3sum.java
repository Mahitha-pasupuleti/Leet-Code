class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
         [-1,0,1,2,-1,-4]
         [-1,-1,0,1,2,4]
         -1 -> get (0, 1), (2, -1)
          0 -> get ( 1, -1)
          distinct triplets : use set
        */

        Arrays.sort(nums);

        int n = nums.length;
        Set<List<Integer>> tripletSet = new HashSet<>();
        for ( int i=0; i<n-2; i++ ) { // i=1
            if ( i>0 && nums[i] == nums[i-1] ) continue;
            int currVal = nums[i]; // -1, need to find pairs with target 1 // 0
            int target = 0 - currVal; // 0
            Map<Integer, Integer> valueIndexMap = new HashMap<>();
            for ( int j=i+1; j<n; j++ ) { // j = 4
                int diff = target - nums[j]; // -2
                if ( valueIndexMap.containsKey( diff ) ) {
                    tripletSet.add( Arrays.asList(nums[i], diff, nums[j]) );
                }
                valueIndexMap.put(nums[j], j); // [1:2], [2:3]
            }
        }
        // System.out.println(tripletSet);
        return new ArrayList<>(tripletSet);
    }
}