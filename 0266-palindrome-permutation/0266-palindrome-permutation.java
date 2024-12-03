class Solution {
    public boolean canPermutePalindrome(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();

        for ( int i=0; i<s.length(); i++ ) {
            if ( !map.containsKey(s.charAt(i)) ) map.put(s.charAt(i), 1);
            else {
                int value = map.get(s.charAt(i));
                map.put(s.charAt(i), ++value);
            }
        }

        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();

        int count = 0;
        while ( iterator.hasNext() ) {
            Map.Entry<Character, Integer> entry = iterator.next();
            if ( entry.getValue()%2 != 0 ) {
                count++;
            }
        }

        if ( count > 1 ) return false;

        return true;
    }
}