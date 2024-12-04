class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int l = 0, r = 0, count = 0, maxCount = 0;

        while ( r < nums.length ) {
            if ( nums[r] == 1 ) {
                maxCount = Math.max(maxCount, ++count);
                r++;
            } else {
                if ( l==r ) r++;
                else --count;
                l++;
            }
        }

        return maxCount;
    }
}