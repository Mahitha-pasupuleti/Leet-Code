class Solution {
    public void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int currentIndex = 0;
        int n = nums.length;
        while ( currentIndex < n ) {
            int correctIndex = nums[currentIndex] - 1; // get correctIndex of value at currentIndex, where it should be
            if ( nums[currentIndex] != nums[correctIndex] ) { // check if the value at currentIndex and correctIndex, both are not same
                swap(nums, currentIndex, correctIndex);
            } else {
                currentIndex++;
            }
        }
        List<Integer> missingValues = new ArrayList<>();
        for ( int i=0; i<n; i++ ) {
            if ( i+1 != nums[i] ) {
                missingValues.add( i+1 );
            }
        }

        return missingValues;
    }
}