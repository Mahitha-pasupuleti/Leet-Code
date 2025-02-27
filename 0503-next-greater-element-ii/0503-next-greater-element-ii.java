class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int[] doubleNums = new int[2 * nums.length];
        for ( int i=0; i<nums.length; i++ ) {
            doubleNums[i] = nums[i];
            doubleNums[i+nums.length] = nums[i];
        }

        Stack<Integer> idxStack = new Stack<>();
        for ( int i=0; i<doubleNums.length; i++ ) {
            while ( !idxStack.isEmpty() && doubleNums[idxStack.peek()] < doubleNums[i] ) {
                doubleNums[idxStack.peek()] = doubleNums[i];
                idxStack.pop();
            }
            idxStack.push(i);
        }

        while ( !idxStack.isEmpty() ) {
            doubleNums[idxStack.peek()] = -1;
            idxStack.pop();
        }

        return Arrays.copyOfRange(doubleNums, 0, nums.length);

    }
}