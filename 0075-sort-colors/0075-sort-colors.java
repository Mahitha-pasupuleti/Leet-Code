class Solution {
    private void swap(int x, int y, int[] nums) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    public void sortColors(int[] nums) {
        // low, migh, high pointers
        // arr[0] - arr[low-1] all 0's.   -----> low part
        // arr[low] - arr[mid-1] all 1's  -----> mid part
        // arr[mid] - arr[n-1] all 2's    -----> high part

        int low = 0, mid = 0, high = nums.length-1;
        while ( mid <= high ) {
            if ( nums[mid] == 0 ) {
                swap(low, mid, nums);
                low++;
                mid++;
            } else if ( nums[mid] == 1 ) {
                mid ++;
            } else {
                swap(mid, high, nums);
                high--;
            }
        }

    }
}