class Solution {
    public int firstUniqChar(String s) {

        LinkedHashMap<Character, Integer> map1 = new LinkedHashMap<>();

        for ( int i=0; i<s.length(); i++ ) {
            if ( map1.get( s.charAt(i) ) == null ) {
                map1.put( s.charAt(i), 1 );
            } else {
                int value = map1.get( s.charAt(i) );
                map1.put( s.charAt(i), ++value );
            }
        }

        Set<Character> keys = map1.keySet();

        for ( Character key: keys ) {
            if ( map1.get(key) == 1 ) return s.indexOf(key);
        }

        return -1;
    }
}