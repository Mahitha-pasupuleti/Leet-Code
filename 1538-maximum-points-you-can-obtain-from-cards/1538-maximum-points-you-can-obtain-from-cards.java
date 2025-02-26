class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int left = k-1, right = cardPoints.length-1;
        int leftSum = 0, rightSum = 0, totalSum = 0;

        // get leftSum
        for ( int i=0; i<=left; i++ ) {
            leftSum += cardPoints[i];
        }
        totalSum = leftSum;

        // 
        while ( k != 0 ) {
            leftSum -= cardPoints[left];
            left--;
            rightSum += cardPoints[right];
            right--;
            totalSum = Math.max(totalSum, leftSum + rightSum);
            k--;
        }

        return totalSum;
    }
}