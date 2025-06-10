class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
            [1, 2, 3, 4]
            
            [-1, 1, 0, -3, 3] totalProductWithZero, totalProductWithoutZero

            [-1, 1, -3, 3] product = 9
            [-9, 9, -3, 3]
        */

        int totalProductWithZero = 1;
        int totalProductWithoutZero = 1;
        int zeroCount = 0;

        for ( int num : nums ) {
            totalProductWithZero *= num;
            if ( num != 0 ) {
                totalProductWithoutZero *= num;
            } else {
                zeroCount++;
            }
        }

        for ( int i=0; i<nums.length; i++ ) {
            if ( nums[i] == 0 ) {
                if ( zeroCount > 1 ) nums[i] = totalProductWithZero;
                else if ( zeroCount == 1 ) nums[i] = totalProductWithoutZero;
            } else {
                nums[i] = totalProductWithZero / nums[i];
            }
        }

        return nums;
    }
}