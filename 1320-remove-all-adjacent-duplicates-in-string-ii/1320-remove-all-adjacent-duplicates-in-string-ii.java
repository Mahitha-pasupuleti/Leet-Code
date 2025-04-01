class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().getKey() == ch) {
                int count = stack.peek().getValue() + 1;
                stack.pop(); // Remove the old entry
                if (count != k) {
                    stack.push(new Pair<>(ch, count));
                }
            } else {
                stack.push(new Pair<>(ch, 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Pair<Character, Integer> p : stack) {
            sb.append(String.valueOf(p.getKey()).repeat(p.getValue()));
        }

        return sb.toString();
    }
}
