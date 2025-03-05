class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        int i=0, j, k;
        List<List<Integer>> myResult = new ArrayList();

        Arrays.sort(nums);

        while ( i < n-2 ) {
            j = i+1; 
            k = n-1;
            while ( j < k ) {
                int currentSum = nums[j] + nums[k];
                if ( currentSum == 0-nums[i] ) {
                    myResult.add(List.of(nums[i], nums[j], nums[k]));
                    while ( j < k && nums[j] == nums[j+1] ) j++;
                    while ( j < k && nums[k] == nums[k-1] ) k--;
                    j++;
                    k--;
                } 
                else if ( currentSum < 0-nums[i] ) j++;
                else k--;
            }
            while ( i < n-2 && nums[i] == nums[i+1] ) i++;
            i++;
        }

        return myResult;

    }
}