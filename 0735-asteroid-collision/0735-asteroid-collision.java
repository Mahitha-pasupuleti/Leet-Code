class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for ( int asteriod : asteroids ) {
            boolean destroyed = false;
            if ( !stack.isEmpty() && stack.peek()>0 && asteriod<0 ) {
                while ( !stack.isEmpty() && stack.peek()>0 && asteriod<0 ) {
                    int top = stack.peek();
                    if ( top > Math.abs(asteriod) ) {
                        destroyed = false;
                        break;
                    }
                    else if ( top < Math.abs(asteriod) ) {
                        stack.pop();
                        destroyed = true;
                    } 
                    else if ( top == Math.abs(asteriod) ) {
                        stack.pop();
                        destroyed = false;
                        break;
                    }
                }
                if ( destroyed == true ) stack.push( asteriod );
            } else {
                stack.push( asteriod );
            }
        }

        int n = stack.size();
        int[] result = new int[n];
        for ( int i=n-1; i>=0; i-- ) {
            result[i] = stack.pop();
        }
        return result;
    }
}