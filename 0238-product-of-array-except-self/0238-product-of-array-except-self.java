class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixProduct = new int[n];
        int[] suffixProduct = new int[n];

        // Step 1: Compute prefix product
        prefixProduct[0] = 1;
        for (int i = 1; i < n; i++) {
            prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
        }

        // Step 2: Compute suffix product
        suffixProduct[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffixProduct[i] = suffixProduct[i + 1] * nums[i + 1];
        }

        // Step 3: Compute final result by multiplying prefix and suffix
        for (int i = 0; i < n; i++) {
            nums[i] = prefixProduct[i] * suffixProduct[i];
        }

        return nums;
    }
}


// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int[] output = new int[nums.length];

//         output[0] = 1;
//         for ( int i=1; i<nums.length; i++ ) {
//            output[i] = output[i-1] * nums[i-1];
//         }
    
//         int suffix = 1;
//         for ( int i=nums.length-1; i>=0; i-- ) {
//            output[i] = output[i] * suffix;
//            suffix *= nums[i];
//         }
//         return output;
//     }
// }

// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int[] prefix_product = new int[nums.length+1];
//         int[] suffix_product = new int[nums.length+1];

//         prefix_product[0] = 1;
//         for ( int i=0; i<nums.length; i++ ) {
//              prefix_product[i+1] = prefix_product[i] * nums[i];
//         }

//         suffix_product[nums.length] = 1;
//         for ( int i=nums.length-1; i>=0; i-- ) {
//              suffix_product[i] = suffix_product[i+1] * nums[i];
//         }

//         for ( int i=1; i<=nums.length; i++ ) {
//              nums[i-1] = prefix_product[i-1] * suffix_product[i];
//         }

//         return nums;

//     }
// }