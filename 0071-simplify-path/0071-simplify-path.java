class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        path += "/"; // Ensure last component is processed

        for (char ch : path.toCharArray()) {
            if (ch == '/') {
                if (sb.length() > 0) {
                    String current = sb.toString();
                    sb.setLength(0); // Clear for the next part

                    if (current.equals(".")) {
                        continue; // Ignore current directory
                    } else if (current.equals("..")) {
                        if (!stack.isEmpty()) {
                            stack.pop(); // Remove last valid directory
                        }
                    } else {
                        stack.push(current);
                    }
                }
            } else {
                sb.append(ch);
            }
        }

        if (stack.isEmpty()) return "/"; // If stack is empty, return root "/"

        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        return result.toString();
    }
}