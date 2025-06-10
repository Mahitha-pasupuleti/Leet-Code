class Solution {
    // Cyclic Sort
    // Hint-1 : n where all the integers of nums are in the range [1, n]
    // Hint-2 : algorithm that runs in O(n) time
    // Hint-3 : only constant auxiliary space -> no modifications to input array
    // 
    public void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
    public List<Integer> findDuplicates(int[] nums) {
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

        List<Integer> duplicates = new ArrayList<>();
        for ( int i=0; i<n; i++ ) {
            if ( i+1 != nums[i] ) {
                duplicates.add(nums[i]);
            }
        }

        return duplicates;
    }
}