class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int prefix = 1, suffix = 1;
        int n = nums.length;
        for ( int i=0; i<n; i++ ) {
            if ( prefix == 0 ) prefix = 1;
            if ( suffix == 0 ) suffix = 1;
            prefix *= nums[i];
            suffix *= nums[n-i-1];
            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }
        return maxProduct;
    }
}

/*
 - Maximum Subarray Sum - Kadane's Algorithm
 - Maximum Product Subarray - Kandane Version works - but it is not intuitive - Striver

 The optimal approach
 4 Cases
 Case 1 : All positive numbers in array, the maxProduct will be totalProduct - [1, 4, 4, 5]
 Case 2 : There are even negatives in array, the maxProduct will be totalProduct - [1, 4, 4, 5, -1, -2]
 Case 3 : There are odd negatives in array, now this tricky

 [3, 3, -1, 4, -6, 3, -2, 6]
    - Now to getmaxProduct, we need to avoid odd no.of negatives, we can achieve that by omitting 1 of them
    - the maxProduct lies in one of below scenarios
        - [3, 3] "-1" [4, -6, 3, -2, 6]
        - [3, 3, -1, 4] "-6" [3, -1, 6]
        - [3, 3, -1, 4, -6, 3] "-1" [6]
        i.e. either prefix/suffix of -1, prefix/suffix of -6, prefix/suffix of -1
    - By checking the maxProduct of both prefix and suffix we can get our answer
    - Example
     arr = [3, 3, -1, 4, -6, 3, -2, 6]
     prefix = [3, 9, -9, -36, 216, 648, -1296, -7776]
     suffix = [-7776, -2592, 432, -144, 216, -36, -12, 6]
     The maximum value among both the array is our result

Case 4: Having 0's in between, in these cases the product becomes 0
    Example : [-2, 3, 4, 1, 0, 2, 3, 1, 4, 0, 4, 6, 4, -1]
    In this case, the maxProduct lies in the subArrays exclusing 0
    - [-2, 3, 4, 1], [2, 3, 1, 4], [4, 6, 4, -1]
    - whenevr 0 is encountered the product becomes 0, then make the product again 1

*/