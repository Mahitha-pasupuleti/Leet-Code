class Solution {
    public int longestConsecutive(int[] nums) {
        // consecutive 1 difference between values
        if ( nums.length == 0 ) return 0;
        Arrays.sort(nums); // [-1, -1, 0, 1, 3, 4, 5, 6, 7, 8, 9]
        System.out.println(Arrays.toString(nums));

        int currValue = nums[0], currLen = 1, maxLen = 1; // -1
        for ( int i=1; i<nums.length; i++ ) {
            int diff = nums[i] - currValue; // 1
            currValue = nums[i]; // 0
            if ( diff == 1 ) {
                currLen++; // 2
                maxLen = Math.max( maxLen, currLen ); // 2
            } else {
                if ( diff != 0 ) {
                    currLen = 1; 
                }
            }
        }
        return maxLen;
    }
}