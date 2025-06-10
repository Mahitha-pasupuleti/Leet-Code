class Solution {
    public void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
    public int findDuplicate(int[] nums) {
        // Cyclic sort
        // Hint-1 : nums containing n + 1 integers where each integer is in the range [1, n] inclusive
        // Hint-2 : You must solve the problem without modifying the array nums and using only constant extra space.
        // No modifying the array, O(1) auxillary space
        // TC : O(n)

        int currentIndex = 0;
        int n = nums.length;
        while ( currentIndex < n ) {
            int correctIndex = nums[currentIndex] - 1;
            if ( nums[currentIndex] != nums[correctIndex] ) {
                swap(nums, currentIndex, correctIndex);
            } else {
                currentIndex++;
            }
        }

        for ( int i=0; i<n; i++ ) {
            if ( i+1 != nums[i] ) {
                return nums[i];
            }
        }

        return 0;
    }
}