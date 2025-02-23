class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0;
        int maxLength = 0;
        Map<Integer, Integer> prefixSums = new HashMap<>();

        for ( int i=0; i<nums.length; i++ ) {
            sum += nums[i];
            if ( sum-k == 0 ) {
                maxLength = i + 1;
            } else if ( prefixSums.containsKey(sum-k) ) {
                maxLength = Math.max(maxLength, i-prefixSums.get(sum-k));
            }

            prefixSums.putIfAbsent(sum, i);
            // if (!prefixSums.containsKey(sum)) {
            //     prefixSums.put(sum, i);
            // }
        }

        return maxLength;
    }
}