class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // [1, 2, 3, 4, 5, 6, 1] 
        // 1, 2, 1 = 4
        // 1, 6, 1 = 8
        // 5, 6, 1 = 12
        // 1, 2, 3 = 6

        int n = cardPoints.length;
        int start = 0, end = k-1, sum = 0;
        for ( int i=start; i<=end; i++ ) sum += cardPoints[i];
        int maxSum = sum;

        while ( end >= 0 ) {
            sum -= cardPoints[end];
            sum += cardPoints[n-start-1];
            maxSum = Math.max(sum, maxSum);
            end--;
            start++;
        }

        return maxSum;
    }
}