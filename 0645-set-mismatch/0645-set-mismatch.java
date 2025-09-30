class Solution {
    private void swap(int x, int y, int[] nums) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    public int[] findErrorNums(int[] nums) {
        int currIndex = 0, n = nums.length;

        while ( currIndex < n ) {
            int correctIndex = nums[currIndex] - 1;
            if ( correctIndex != nums[correctIndex]-1 ) {
                swap(currIndex, correctIndex, nums);
            } else currIndex++;
        }

        // System.out.println( Arrays.toString(nums) );

        int[] result = new int[2];
        for ( int i=0; i<n; i++ ) {
            if ( i != nums[i]-1 ) {
                result[0] = nums[i];
                result[1] = i+1;
            }
        }

        return result;
    }
}