class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, maxFreq = 0, maxLen = 0;

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));

            while ((end - start + 1) - maxFreq > k) {
                char c = s.charAt(start);
                int value = map.get(c) - 1;
                if (value == 0) map.remove(c);
                else map.put(c, value);
                start++;
            }

            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}

/*
- can string be empty?
- can string have only 1 character
- is string case sensitive
- is string sorted

TC: O(n)
SC: O(26) since only 26 alphabets exists
*/