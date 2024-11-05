class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];

        for ( int i=n-1; i>=0; i-- ) {
            while ( !stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i] ) {
                stack.pop();
            }
            if ( stack.isEmpty() ) {
                result[i] = 0;
            }
            else if ( temperatures[stack.peek()] > temperatures[i] ) {
                result[i] = stack.peek() - i;
            }
            stack.push(i);
        }

        return result;
    }
}