class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for ( char ch : s.toCharArray() ) {
            if ( !stack.isEmpty() ) {
                char curr = stack.peek();
                if ( ch == 'B' && curr == 'A' ) stack.pop();
                else if ( ch == 'D' && curr == 'C' ) stack.pop();
                else stack.push(ch);
            } else{
                stack.push(ch);
            }
        }

        return stack.size();
    }
}