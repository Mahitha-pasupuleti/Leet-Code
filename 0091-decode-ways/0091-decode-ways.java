class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int solve(String s, int i) {
        // Successfully reached end
        if (i == s.length()) return 1;
        // Leading zero is invalid
        if (s.charAt(i) == '0') return 0;

        if (memo.containsKey(i)) return memo.get(i);

        int result = solve(s, i + 1); // One-digit decode

        // Two-digit decode
        if (i + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(i, i + 2));
            if (num <= 26) {
                result += solve(s, i + 2);
            }
        }

        memo.put(i, result);
        return result;
    }

    public int numDecodings(String s) {
        return solve(s, 0);
    }
}
