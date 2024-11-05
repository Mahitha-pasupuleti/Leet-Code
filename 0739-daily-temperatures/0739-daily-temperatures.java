class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];

        for ( int i=n-1; i>=0; i-- ) {
            while ( !stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i] ) {
                stack.pop();
            }
            // int[] value = new int[2];
            // value[0] = temperatures[i];
            // value[1] = i;
            if ( !stack.isEmpty() ) {
                result[i] = stack.peek() - i;
            }
            // else if ( temperatures[stack.peek()] > temperatures[i] ) {
            //     result[i] = stack.peek() - i;
            // }
            stack.push(i);
        }

        return result;
    }
}