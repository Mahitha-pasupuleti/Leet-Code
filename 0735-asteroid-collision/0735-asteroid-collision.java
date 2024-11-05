class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for ( int i=0; i<asteroids.length; i++ ) {
            // int[] value = new int[2];
            // value[0] = Math.abs(asteroids[i]);
            // value[1] = ( asteroids[i] >= 0 ) ? 1 : -1;
            // for ( int j=0; j<value.length; j++ ) {
            //     System.out.println(value[j]);
            // }

            boolean destroyed = false;

            // if ( stack.isEmpty() ) {
            //     stack.push(value);
            // }
            // else if ( !stack.isEmpty() && value[1] == -1 ) {
            while ( !stack.isEmpty() && asteroids[i]<0 && stack.peek()>0 ) {
                if ( stack.peek() < Math.abs(asteroids[i]) ) {
                    stack.pop();
                } else if ( stack.peek() == Math.abs(asteroids[i]) ) {
                    stack.pop();
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }
            if ( !destroyed ) {
                stack.push(asteroids[i]);
            }
        }

        // Iterator value = stack.iterator(); 
        // System.out.println("The iterator values are: "); 
        // while (value.hasNext()) { 
        //     System.out.println(value.next()); 
        // }

        // for (int arr : stack) {
        //     System.out.println(arr);
        // }

        int[] result = new int[stack.size()];
        for ( int i=result.length-1; i>=0; i-- ) {
            result[i] = stack.pop();
        }

        return result;
    }
}