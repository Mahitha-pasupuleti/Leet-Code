class Solution {
    private void swap(int x, int y, int[] nums) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    public void moveZeroes(int[] nums) {
        int low = 0, high = 0;
        // after low everything should be 0
        while ( low <= high && high < nums.length ) {
            if ( nums[high] != 0 ) {
                swap(low, high, nums);
                low++;
            }
            high++;
        }
    }
}