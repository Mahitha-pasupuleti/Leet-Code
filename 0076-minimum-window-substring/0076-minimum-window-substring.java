class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<t.length(); i++ ) map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);

        int count = 0, minLen = Integer.MAX_VALUE, start = 0, end = 0, validStart = -1;
        while ( end < s.length() ) {
            if ( map.containsKey(s.charAt(end)) ) {
                if ( map.get(s.charAt(end)) > 0 ) count++;
                int value = map.get(s.charAt(end));
                map.put(s.charAt(end), --value);
            }

            while ( count == t.length() ) {
                if ( minLen > end - start + 1 ) {
                    minLen = end - start + 1;
                    validStart = start;
                }
                if ( map.containsKey(s.charAt(start)) ) {
                    int value = map.get(s.charAt(start));
                    map.put(s.charAt(start), ++value);
                    if ( value > 0 ) count--;
                }
                start++;
            }

            end++;
        }

        if ( minLen == Integer.MAX_VALUE ) return "";

        return s.substring(validStart, validStart + minLen);
    }
}