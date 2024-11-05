class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<Integer>();
        int n = nums.length;

        for ( int i=(2*n)-1; i>=0; i-- ) {
            while ( !stack.isEmpty() && nums[i%n] >= stack.peek() ) {
                stack.pop();
            }
            if ( stack.isEmpty() ) {
                result[i%n] = -1;
            } 
            else {
                result[i%n] = stack.peek();
            }
            stack.push(nums[i%n]);
        }

        return result;

    }
}