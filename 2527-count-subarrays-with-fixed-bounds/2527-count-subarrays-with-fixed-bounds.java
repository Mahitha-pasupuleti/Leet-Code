class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int minKIndex = -1, maxKIndex = -1, invalid = -1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                invalid = i;   // reset the window
            }
            if (nums[i] == minK) minKIndex = i;
            if (nums[i] == maxK) maxKIndex = i;
            
            // number of subarrays ending at i
            count += Math.max(0, Math.min(minKIndex, maxKIndex) - invalid);
        }
        
        return count;
    }
}
