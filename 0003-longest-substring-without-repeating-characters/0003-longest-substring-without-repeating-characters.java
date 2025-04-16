class Solution {
    public int lengthOfLongestSubstring(String s) {
        // two pointer
        // hashj map to keep track of value count
        // sliding windowe to keep the sbustring unique

        int start = 0, end = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        while ( end < s.length() ) {

            if ( !map.containsKey(s.charAt(end)) ) {
                map.put(s.charAt(end), 1);
            } else {
                // int value = map.get(s.charAt(end));
                while ( map.containsKey(s.charAt(end)) ) {
                    map.remove(s.charAt(start));
                    start++;
                }
                map.put(s.charAt(end), 1);
            }

            // map.put(s.charAt(end), map.getOrDefault(0, 1) + 1); // this is a bit off
            // Hopw to check duplicate value

            // if ( map.size() > 1 ) {
                maxLen = Math.max(maxLen, end-start+1);
            // }

            end++;
        }

        return maxLen;

        
    }
    // abaca
}