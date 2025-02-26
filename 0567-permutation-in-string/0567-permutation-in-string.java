class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int start=0, end=0;
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();

        for ( int i=0; i<s1.length(); i++ ) {
            char ch = s1.charAt(i);
            s1Map.put(ch, s1Map.getOrDefault(ch, 0)+1);
        }

        while ( end < s2.length() ) {

            if ( s1Map.containsKey(s2.charAt(end)) ) {
                char ch = s2.charAt(end);
                s2Map.put(ch, s2Map.getOrDefault(ch, 0)+1);
            } else {
                if ( !s2Map.isEmpty() ) s2Map.clear();
                start = end;
                start++;
            }

            if ( end - start + 1 == s1.length() ) {
                if ( s1Map.equals(s2Map) ) return true;
                char ch = s2.charAt(start);
                s2Map.put(ch, s2Map.get(ch)-1);
                if ( s2Map.get(ch) == 0 ) s2Map.remove(ch);
                start++;
            }
            end++;

        }
        return false;
    }
}