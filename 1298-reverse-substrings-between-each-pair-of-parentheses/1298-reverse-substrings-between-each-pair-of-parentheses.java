class Solution {
    public String reverseParentheses(String s) {
        /*
        - What is no character between paranthesis ()
        - what if ch == '('
        - what if ch == ")"
        - what if ch == a-z
        */

        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for ( char ch : s.toCharArray() ) {
            if ( ch == '(' ) {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if ( ch == ')' ) {
                String current = sb.reverse().toString();
                sb.setLength(0);
                sb.append(stack.pop());
                sb.append(current);
                // if ( sb.length() > 0 ) {
                //     if ( !stack.isEmpty() ) StringBuilder curr = stack.pop();
                //     curr.append(sb.reverse())
                //     stack.push(curr.toString());
                //     sb.setLength(0);
                // }
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}