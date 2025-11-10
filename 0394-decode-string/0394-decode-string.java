class Solution {
    public String decodeString(String s) {
        s = "1[" + s + "]";
        int i = 0;
        Stack<String> stack = new Stack<>();
        while ( i < s.length() ) {
            char ch = s.charAt(i);
            if ( ch == ']' ) {
                StringBuilder str = new StringBuilder();
                while ( !stack.isEmpty() && !stack.peek().equals("[") ) {
                    str.insert(0, stack.pop());
                }
                stack.pop();
                int repeat = Integer.parseInt(stack.pop());

                StringBuilder toAdd = new StringBuilder();
                while ( repeat != 0 ) {
                    toAdd.append(str);
                    repeat--;
                }
                stack.push(toAdd.toString());
            } else if (Character.isDigit(ch)) {
                int index = s.indexOf('[', i);
                String repeat = s.substring(i, index);
                stack.push(repeat);
                i = index - 1; // move i just before '['
                
            } else if (ch == '[') {
                stack.push("[");
            } else { // letters
                stack.push(String.valueOf(ch));
            }
            i++;
        }

        return stack.pop();
    }
}