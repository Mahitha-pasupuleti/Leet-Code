class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for ( char ch : s.toCharArray() ) {
            // To check if a "ch" is actually a digit use Character.isDigit()
            // Or directly check ch >= '0' && ch <= '9'
            if ( ch >= '0' && ch <= '9' ) {
                if ( !stack.isEmpty() ) stack.pop();
            }
            else stack.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        // To iterate through a stack
        for ( char ch : stack ) {
            sb.append(ch);
        }
        return sb.toString();
    }
}