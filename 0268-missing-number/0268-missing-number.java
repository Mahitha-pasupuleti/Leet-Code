class Solution {
    public int missingNumber(int[] nums) {

        int n = nums.length;
        // System.out.println(n);
        int sumOfN = (n*(n+1))/2;
        int sumOfNums = 0;

        for ( int i=0; i<nums.length; i++ ) {
            sumOfNums += nums[i];
        }

        // System.out.println(sumOfN + " " + sumOfNums);

        return sumOfN-sumOfNums;

        // Binary search
        // Arrays.sort(nums);
        // int start = 0, end = nums.length;
        // int mid = 0;

        // while ( start < end ) {
        //     mid = start + ( end - start ) / 2;
        //     if ( nums[mid] > mid ) end = mid;
        //     else start = mid+1;
        // }

        // return start;
    }
}