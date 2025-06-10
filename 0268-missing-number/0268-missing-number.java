class Solution {
    public void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
    public int missingNumber(int[] nums) {
        // Using cyclic sort
        int currentIndex = 0, n = nums.length;
        while ( currentIndex < n ) {
            int correctIndex = nums[currentIndex];
            // If element is at the wrong index - nums[i] != nums[correctIndex]
            if ( correctIndex < n && nums[currentIndex] != nums[correctIndex] ) {
                swap( nums, currentIndex, correctIndex);
            } else {
                currentIndex++;
            }
        }

        for ( int i=0; i<n; i++ ) {
            if ( i != nums[i] ) return i;
        }

        return n;
    }
}