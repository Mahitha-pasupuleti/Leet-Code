class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList();
        int i=0, j, k, l;
        int n = nums.length;

        Arrays.sort(nums);

        while ( i < n-3 ) {
            j = i+1;
            while ( j < n-2 ) {
                k = j+1;
                l = n-1;
                while ( k < l ) {
                    long currentSum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if ( currentSum == target ) {
                        resultList.add(List.of(nums[i], nums[j], nums[k], nums[l]));
                        while ( k < l && nums[k] == nums[k+1] ) k++;
                        while ( k < l && nums[l] == nums[l-1] ) l--;
                        k++;
                        l--;
                    } 
                    else if ( currentSum < target ) k++;
                    else l--;
                }
                while ( j < n-2 && nums[j] == nums[j+1] ) j++;
                j++;
            }
            while ( i < n-3 && nums[i] == nums[i+1] ) i++;
            i++;
        }

        return resultList;
    }
}