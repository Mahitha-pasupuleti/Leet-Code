class Solution {
    public int[] maximumLengthOfRanges(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> myStack = new Stack<>();

        for ( int i=0; i<n; i++ ) {
            while ( !myStack.isEmpty() && nums[myStack.peek()] < nums[i] ) {
                myStack.pop();
            }
            left[i] = myStack.isEmpty() ? -1 : myStack.peek();
            myStack.push(i);
        }

        myStack.clear();

        for ( int i=n-1; i>=0; i-- ) {
            while ( !myStack.isEmpty() && nums[myStack.peek()] < nums[i] ) {
                myStack.pop();
            }
            right[i] = myStack.empty() ? n : myStack.peek();
            myStack.push(i);
        }

        int[] ans = new int[n];
        for ( int i=0; i<n; i++ ) {
            ans[i] = right[i] - left[i] - 1;
        }

        return ans;
    }
}