class Solution {
    public int evalRPN(String[] tokens) {
        // [4, 2, -] = 6
        Stack<Integer> stack = new Stack<>();
        for ( int i=0; i<tokens.length; i++ ) {

            if ( tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/") ) {
                int second = stack.pop();
                int first = stack.pop();

                if ( tokens[i].equals("+") ) {
                    stack.push(first + second);
                } else if ( tokens[i].equals("-") ) {
                    stack.push(first - second);
                } else if ( tokens[i].equals("*") ) {
                    stack.push(first * second);
                } else if ( tokens[i].equals("/") ) {
                    stack.push(first / second);
                }
            }
            else {
                stack.push( Integer.parseInt(tokens[i]) );
            }

        }

        return stack.pop();
    }
}