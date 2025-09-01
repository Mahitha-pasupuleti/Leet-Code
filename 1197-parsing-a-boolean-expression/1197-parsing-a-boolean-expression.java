class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> mainStack = new Stack<>();
        Stack<Character> subStack = new Stack<>();
        for ( int i=0; i<expression.length(); i++ ) {
            char ch = expression.charAt(i);

            if ( ch == ',' ) continue;
            if ( ch != ')' ) mainStack.push(ch);
            else {
                while ( mainStack.peek() != '(' ) {
                    char currVal = mainStack.pop();
                    subStack.push(currVal);
                }
                mainStack.pop(); // remove '('
                char currOp = mainStack.pop();
                if ( subStack.size() == 1 ) {
                    if ( currOp == '!' ) {
                        char currExp = subStack.pop();
                        if ( currExp == 't' ) subStack.push('f');
                        else subStack.push('t');
                    }
                } else {
                    while ( subStack.size() > 1 ) {
                        char currExp1 = subStack.pop();
                        char currExp2 = subStack.pop();
                        boolean currExp1Val = false, currExp2Val = false;
                        if ( currExp1 == 't' ) currExp1Val = true;
                        if ( currExp2 == 't' ) currExp2Val = true;

                        if ( currOp == '|' ) {
                            boolean result = currExp1Val || currExp2Val;
                            if ( result == true ) subStack.push( 't' );
                            else subStack.push( 'f' );
                        } else {
                            boolean result = currExp1Val && currExp2Val;
                            if ( result == true ) subStack.push( 't' );
                            else subStack.push( 'f' );
                        }
                    }
                }
                mainStack.push( subStack.pop() );
            }
        }
        
        char finalResult = mainStack.pop();
        if ( finalResult == 't' ) return true;
        else return false;
    }
}