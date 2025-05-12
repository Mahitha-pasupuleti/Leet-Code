/*
    - there are 1 to 26 characters and associted "A" to "Z"
    - there is 0
    - there is no negative
    - if something starts with zero, it is invalid
    - find #valid decoded strings
    - so we need to find #valid decoded strings in a string
    - we need to check either length 1 character or length 2 characters
    - sequenctial, we can skip to next

    For example: 22065
    - we should definetly take either 1 character like "2" or 2 characters like 22
    - because we cannot skip charcters, its not like knapsack where u skip something
    - u should definetly check with either 1 or 2 characters

    How to do?
    - solve(s, i, j) -> i, j staring and endign indices
    - If i == 0, j == 0, "2" check if 2 is valid or not
    - If i == 0, j == 1, "22" check if 22 is valid or not
    - if character is return 0 i.e invalid return 0;
    - check if that substring is valid
*/


class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int solve(String s, int i) {
        if (i == s.length()) return 1; // Base: one valid decoding
        if (s.charAt(i) == '0') return 0; // Can't decode '0' alone

        if (memo.containsKey(i)) return memo.get(i);

        int ways = solve(s, i + 1); // Take one character

        if (i + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(i, i + 2));
            if (num <= 26) {
                ways += solve(s, i + 2); // Take two characters
            }
        }

        memo.put(i, ways);
        return ways;
    }

    public int numDecodings(String s) {
        return solve(s, 0);
    }
}
