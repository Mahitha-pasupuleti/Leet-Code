class Solution {
    
    // Cyclic Sort
    // Hint-1 : algorithm that runs in O(n)
    // Hint-2 : O(1) auxiliary space

    public void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
    public int firstMissingPositive(int[] nums) {
        int currentIndex = 0;
        int n = nums.length;
        while ( currentIndex < n ) {
            int correctIndex = nums[currentIndex] - 1;
            if ( correctIndex >= 0 && correctIndex < n && nums[currentIndex] != nums[correctIndex] ) {
                swap(nums, currentIndex, correctIndex);
            } else {
                currentIndex++;
            }
        }

        for ( int i=0; i<n; i++ ) {
            if ( i+1 != nums[i] ) {
                return i+1;
            }
        }

        return n+1;
    }
}