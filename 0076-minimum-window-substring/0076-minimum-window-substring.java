class Solution {
    public String minWindow(String s, String t) {
        if ( t.length() > s.length() ) return "";

        Map<Character, Integer> tMap = new HashMap<>();
        for ( int i=0; i<t.length(); i++ ) {
            char ch = t.charAt(i);
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        int count = 0, start = 0, end = 0, startIndex = 0, minLen = Integer.MAX_VALUE;

        while ( end < s.length() ) {
            char endCh = s.charAt(end);

            if (tMap.containsKey(endCh) && tMap.get(endCh) > 0) {
                count++;
                tMap.put(endCh, tMap.get(endCh) - 1);
            }

            // if (tMap.containsKey(endCh)) {
            //     tMap.put(endCh, tMap.get(endCh) - 1);
            // }

            while ( count == t.length() ) {
                if ( minLen > end - start + 1 ) {
                    minLen = end - start + 1;
                    startIndex = start;
                }
                
                // remove start
                char startCh = s.charAt(start);
                if ( tMap.containsKey(startCh) ) {
                    tMap.put(startCh, tMap.get(startCh) + 1);
                    int value = tMap.get(startCh);
                    if ( value > 0 ) count--;
                }

                start++;
            }

            end++;
        }

        if ( minLen == Integer.MAX_VALUE ) return "";

        return s.substring(startIndex, startIndex + minLen);
    }
}