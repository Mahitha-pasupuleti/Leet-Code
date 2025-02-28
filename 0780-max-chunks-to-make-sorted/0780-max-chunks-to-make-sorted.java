class Solution {
    public int maxChunksToSorted(int[] arr) {
        // Stack<Integer> myStack = new Stack<>();
        // for ( int i=0; i<arr.length; i++ ) {
        //     // monotonic increasing order stack
        //     while ( !myStack.isEmpty() && myStack.peek() > arr[i] ) {
        //         myStack.pop();
        //     }
        //     myStack.push(arr[i]);
        // }
        // return myStack.size();

        int[] org_Prefix_Sum = new int[arr.length];

        org_Prefix_Sum[0] = 0;
        for ( int i=1; i<arr.length; i++ ) {
            org_Prefix_Sum[i] = org_Prefix_Sum[i-1] + i;
        }

        // updating arr[] with its prefix_sum
        for ( int i=1; i<arr.length; i++ ) {
            arr[i] += arr[i-1];
        }

        int count = 0;
        for ( int i=0; i<arr.length; i++ ) {
            if ( arr[i] == org_Prefix_Sum[i] ) count++;
        }

        return count;

    }
}