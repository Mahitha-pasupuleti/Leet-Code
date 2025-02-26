class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int start=0, end=0;
        double currAvg=0, maxAvg=Integer.MIN_VALUE;

        while ( end < nums.length ) {
            currAvg += nums[end];
            if ( end - start + 1 == k ) {
                maxAvg = Math.max(maxAvg, currAvg/k);
                currAvg -= nums[start];
                start++;
            }
            end++;
        }

        return maxAvg;
    }
}